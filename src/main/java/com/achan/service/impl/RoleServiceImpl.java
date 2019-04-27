package com.achan.service.impl;

import com.achan.dao.MenuDao;
import com.achan.dao.RoleDao;
import com.achan.dao.RoleMenuDao;
import com.achan.dao.RolePermissionDao;
import com.achan.entity.MenuVo;
import com.achan.entity.RoleVo;
import com.achan.entity.base.RoleBase;
import com.achan.entity.base.RoleBaseExample;
import com.achan.entity.base.RoleMenuBase;
import com.achan.service.RoleService;
import com.achan.util.EntityConverter;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author AChan
 * @title: RoleServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private static final int NAME_LENGTH = 64;

    private static final int DESCRIPTION_LENGTH = 256;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<RoleVo> getAll() {
        RoleBaseExample roleBaseExample = new RoleBaseExample();
        roleBaseExample.createCriteria().andDeletedEqualTo(false);
        List<RoleBase> list = roleDao.selectByExample(roleBaseExample);
        List<RoleVo> result = EntityConverter.convert(list, RoleVo.class);
        return result;
    }

    @Override
    public int delete(String id) {
        RoleBase roleBase = new RoleBase();
        roleBase.setId(id);
        roleBase.setDeleted(true);

        return roleDao.updateByPrimaryKeySelective(roleBase);
    }

    @Override
    public int add(RoleVo role) {
        if (checkNameExit(role)) {
            return 0;
        }
        role.setDeleted(false);
        return roleDao.insert(role);
    }

    @Override
    public int update(RoleVo role) {
        if (checkNameExit(role)) {
            return 0;
        }
        role.setDeleted(false);
        return roleDao.updateByPrimaryKey(role);
    }

    @Override
    public List<RoleVo> pageRole(RoleVo roleVo, int page, int num) {
        PageHelper.startPage(page, num);
        RoleBaseExample roleBaseExample = new RoleBaseExample();
        RoleBaseExample.Criteria criteria = roleBaseExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        String name = roleVo.getName();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike(name);
        }
        List<RoleBase> roleBases = roleDao.selectByExample(roleBaseExample);
        List<RoleVo> roleVos = EntityConverter.convert(roleBases, RoleVo.class);
        return roleVos;
    }

    @Override
    public RoleVo getById(String id) {
        RoleBase roleBase = roleDao.selectByPrimaryKey(id);
        RoleVo roleVo = EntityConverter.convert(roleBase, RoleVo.class);
        return roleVo;
    }

    @Override
    public List<RoleVo> getByIdList(List<String> idList) {
        List<RoleVo> roleVos = roleDao.selectByRoleIds(idList);
        List<String> menuIdList = roleMenuDao.selectByRoleIdList(idList);
        List<MenuVo> menuVoList = menuDao.selectByIds(menuIdList);

        return null;
    }

    /**
     * 判断角色名称是否已存在
     *
     * @param roleVo
     * @return boolean true 存在,false 不存在
     * @Author AChan
     * @Date 2019/4/18 11:36
     **/
    private boolean checkNameExit(RoleVo roleVo) {
        RoleBaseExample roleBaseExample = new RoleBaseExample();
        roleBaseExample.createCriteria()
                .andIdNotEqualTo(roleVo.getId())
                .andNameEqualTo(roleVo.getName())
                .andDeletedEqualTo(false);
        List<RoleBase> roleBases = roleDao.selectByExample(roleBaseExample);

        return !CollectionUtils.isEmpty(roleBases);
    }

    /**
     * 校验输入
     *
     * @param roleVo
     * @return boolean
     * @Author AChan
     * @Date 2019/4/18 11:36
     **/
    private boolean valid(RoleVo roleVo) {
        if (ObjectUtils.isEmpty(roleVo)) {
            return false;
        }
        String name = roleVo.getName();
        String descriptiontion = roleVo.getDescriptiontion();
        if (StringUtils.isEmpty(name) || name.length() > NAME_LENGTH) {
            return false;
        }
        if (StringUtils.isEmpty(descriptiontion) || descriptiontion.length() > DESCRIPTION_LENGTH) {
            return false;
        }
        return true;
    }
}
