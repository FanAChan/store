package com.achan.service.impl;

import com.achan.dao.*;
import com.achan.entity.*;
import com.achan.entity.base.UserBase;
import com.achan.entity.base.UserBaseExample;
import com.achan.entity.base.UserRoleBase;
import com.achan.service.UserService;
import com.achan.util.Encryptor;
import com.achan.util.EntityConverter;
import com.achan.util.UUIDUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private StorehousePermissionDao storehousePermissionDao;

    @Override
    public int add(UserVo userVo) {
        if (!checkUserBase(userVo) && checkPhoneExit(userVo)) {
            return 0;
        }
        String credential = Encryptor.createCredential(userVo.getPhone(), userVo.getPassword());
        userVo.setPassword(credential);
        userVo.setDeleted(false);
        int insert = userDao.insert(userVo);
        List<RoleVo> roles = userVo.getRoles();
        if (insert > 0 && !CollectionUtils.isEmpty(roles)) {
            List<UserRoleBase> userRoleBaseList = buildUserRoleBase(roles, userVo.getId());
            insert = userRoleDao.batchInsert(userRoleBaseList);
            storehousePermissionDao.batchInsert(this.buildStorehousePermission(userVo));
        }
        return insert;
    }

    @Override
    public int delete(String id) {
        UserBase userBase = new UserBase();
        userBase.setId(id);
        userBase.setDeleted(true);
        //删除用户，删除用户权限等
        int update = userDao.updateByPrimaryKeySelective(userBase);
        if (update > 0) {
            update = userRoleDao.deleteUserRole(id);
        }
        return update;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(UserVo userVo) {
        if (!checkUserBase(userVo) && checkPhoneExit(userVo)) {
            return 0;
        }
//        String credential = Encryptor.createCredential(userVo.getPhone(), userVo.getPassword());
//        userVo.setPassword(credential);
        userVo.setDeleted(false);
        int update = userDao.updateByPrimaryKeySelective(userVo);
        List<RoleVo> roles = userVo.getRoles();
        List<StorehouseVo> storehouseVos = userVo.getStorehouseVos();
        if (update > 0) {
            if (!CollectionUtils.isEmpty(roles)) {
                userRoleDao.deleteUserRole(userVo.getId());

                List<UserRoleBase> userRoleBaseList = buildUserRoleBase(roles, userVo.getId());

                update = userRoleDao.batchInsert(userRoleBaseList);
            }
            //修改用户授权仓库
            if (!CollectionUtils.isEmpty(storehouseVos)) {
                storehousePermissionDao.deleteByUserId(userVo.getId());
                storehousePermissionDao.batchInsert(this.buildStorehousePermission(userVo));
            }
        }
        return update;
    }

    @Override
    public int updatePassword(UserVo user, String newPassword) {
        String newCredential = Encryptor.createCredential(user.getPhone(), newPassword);
        int update = 0;
        if (user.getPassword().equals(newCredential)) {
            UserBase userBase = new UserBase();
            userBase.setId(user.getId());
            userBase.setPassword(newCredential);
            update = userDao.updateByPrimaryKeySelective(userBase);
        }
        return update;
    }

    @Override
    public int resetPassword(String id, String phone) {
        int update = 0;
        String newCredential = Encryptor.createCredential(phone, "123456");
        UserBase userBase = new UserBase();
        userBase.setId(id);
        userBase.setPassword(newCredential);
        update = userDao.updateByPrimaryKeySelective(userBase);
        return update;
    }

    @Override
    public PageInfo selectUserVoPage(UserVo userVo, int page, int num) {
        UserBaseExample userBaseExample = new UserBaseExample();
        userBaseExample.createCriteria()
                .andDeletedEqualTo(false);
        List<UserBase> userBaseList = userDao.selectByExample(userBaseExample);
        List<UserVo> userVoList = EntityConverter.convert(userBaseList, UserVo.class);
        PageInfo pageInfo = new PageInfo<>(userBaseList);
        pageInfo.setList(userVoList);
        return pageInfo;
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
        List<String> menuIdList = roleMenuDao.selectByRoleIdList(roleIdList);
        List<MenuVo> menuVoList = menuDao.selectByIds(menuIdList);
        List<String> permissionIdList = rolePermissionDao.selectByRoleIdList(roleIdList);
        List<PermissionVo> permissionVos = permissionDao.selectByIds(permissionIdList);
        Map<String, MenuVo> menuVoMap = menuVoList.stream().collect(Collectors.toMap(MenuVo::getId, Function.identity()));
        permissionVos.stream()
                .forEach(permissionVo -> {
                    MenuVo menuVo = menuVoMap.get(permissionVo.getMenuId());
                    if (menuVo != null) {
                        menuVo.addPermissionVo(permissionVo);
                    }
                });
        userVo.setRoles(roleVoList);
        userVo.setPermissionVos(permissionVos);
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

    private List<UserRoleBase> buildUserRoleBase(List<RoleVo> roles, String userId) {
        List<UserRoleBase> userRoleBaseList = roles.stream().map(roleVo -> {
            UserRoleBase userRoleBase = new UserRoleBase();
            userRoleBase.setId(UUIDUtil.randomID());
            userRoleBase.setRoleId(roleVo.getId());
            userRoleBase.setUserId(userId);
            return userRoleBase;
        }).collect(Collectors.toList());
        return userRoleBaseList;
    }

    private List<StorehousePermissionVo> buildStorehousePermission(UserVo userVo) {

        List<StorehouseVo> storehouseVos = userVo.getStorehouseVos();
        String id = userVo.getId();
        List<StorehousePermissionVo> storehousePermissionVos = storehouseVos.stream()
                .map(storeHouseVo -> {
                    StorehousePermissionVo storehousePermissionVo = new StorehousePermissionVo();
                    storehousePermissionVo.setId(UUIDUtil.randomID());
                    storehousePermissionVo.setStorehouseId(storeHouseVo.getId());
                    storehousePermissionVo.setUserId(id);
                    return storehousePermissionVo;
                }).collect(Collectors.toList());
        return storehousePermissionVos;
    }

}
