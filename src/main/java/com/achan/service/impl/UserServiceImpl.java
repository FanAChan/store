package com.achan.service.impl;

import com.achan.dao.RoleDao;
import com.achan.dao.UserDao;
import com.achan.dao.UserRoleDao;
import com.achan.dao.base.RoleMenuBaseMapper;
import com.achan.dao.base.RolePermissionBaseMapper;
import com.achan.entity.RoleVo;
import com.achan.entity.UserVo;
import com.achan.entity.base.UserBase;
import com.achan.entity.base.UserBaseExample;
import com.achan.service.UserService;
import com.achan.util.Encryptor;
import com.achan.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author AChan
 * @title: UserServiceImpl
 * @date 2019/4/11 8:56
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RolePermissionBaseMapper rolePermissionBaseMapper;

    @Autowired
    private RoleMenuBaseMapper roleMenuBaseMapper;

    @Override
    public int add(UserVo userVo) {
        if (checkPhoneExit(userVo)) {
            return 0;
        }
        String credential = Encryptor.createCredential(userVo.getPhone(), userVo.getPassword());
        userVo.setPassword(credential);
        userVo.setDeleted(false);
        return userDao.insert(userVo);
    }

    @Override
    public int delete(String id) {
        UserBase userBase = new UserBase();
        userBase.setId(id);
        userBase.setDeleted(true);
        //删除用户，删除用户权限等
        return userDao.updateByPrimaryKeySelective(userBase);
    }

    @Override
    public int updateUserBase(UserVo userVo) {
        if (checkPhoneExit(userVo)) {
            return 0;
        }
        String credential = Encryptor.createCredential(userVo.getName(), userVo.getPassword());
        userVo.setPassword(credential);
        userVo.setDeleted(false);
        return userDao.updateByPrimaryKey(userVo);
    }

    @Override
    public List<UserVo> selectUserVoPage(UserVo userVo, int page, int num) {
        return null;
    }

    @Override
    public int verify(String id, Byte state) {
        UserBase userBase = new UserBase();
        userBase.setId(id);
        userBase.setState(state);
        int i = userDao.updateByPrimaryKeySelective(userBase);
        return i;
    }

    @Override
    public UserVo getUserBase(String id) {
        UserBase userBase = userDao.selectByPrimaryKey(id);
        UserVo userVo = EntityConverter.convert(userBase, UserVo.class);
        return userVo;
    }

    @Override
    public UserVo getUserVo(String id) {
        UserBase userBase = userDao.selectByPrimaryKey(id);
        UserVo userVo = EntityConverter.convert(userBase, UserVo.class);
        return userVo;
    }

    @Override
    public UserVo getByPhone(String phone) {
        UserBaseExample userBaseExample = new UserBaseExample();
        userBaseExample.createCriteria()
                .andPhoneEqualTo(phone)
                .andStateEqualTo((byte) 1)
                .andDeletedEqualTo(false);
        List<UserBase> userBaseList = userDao.selectByExample(userBaseExample);
        if (CollectionUtils.isEmpty(userBaseList)) {
            return null;
        }
        UserVo userVo = EntityConverter.convert(userBaseList.get(0), UserVo.class);
        //获取用户权限
        //1，获取角色
        //2，获取菜单
        //3，获取具体权限
        List<String> roleIdList = userRoleDao.selectByUser(userVo.getId());



        List<RoleVo> roleVoList = roleDao.selectByRoleIds(roleIdList);

        userVo.setRoles(roleVoList);
        return userVo;
    }

    /**
     * 判断相同手机号码是否已存在
     *
     * @param userVo
     * @return true 存在 false 不存在
     */
    private boolean checkPhoneExit(UserVo userVo) {
        UserBaseExample userBaseExample = new UserBaseExample();
        userBaseExample.createCriteria()
                .andIdNotEqualTo(userVo.getId())
                .andPhoneEqualTo(userVo.getPhone())
                .andDeletedEqualTo(false);
        List<UserBase> userBases = userDao.selectByExample(userBaseExample);
        //当前手机号码已存在
        return !CollectionUtils.isEmpty(userBases);
    }

    /**
     * 校验用户基础信息
     *
     * @param userBase
     * @return boolean
     * @Author AChan
     * @Date 2019/4/16 21:21
     **/
    private boolean checkUserBase(UserBase userBase) {
        if (ObjectUtils.isEmpty(userBase)) {
            return false;
        }
        String name = userBase.getName();
        if (StringUtils.isEmpty(name) || name.length() > 32) {
            return false;
        }
        String phone = userBase.getPhone();
        if (StringUtils.isEmpty(phone) || phone.length() != 11) {
            return false;
        }
        String mail = userBase.getMail();
        if (!StringUtils.isEmpty(mail) && mail.length() > 32) {
            return false;
        }
        String password = userBase.getPassword();
        if (StringUtils.isEmpty(password) || password.length() > 16 || password.length() < 6) {
            return false;
        }
        return true;
    }
}
