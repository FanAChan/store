package com.achan.service;

import com.achan.entity.UserVo;
import com.achan.entity.base.UserBase;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author AChan
 * @Date 2019/4/16 15:57
 **/
public interface UserService {

    /**
     * 新增
     *
     * @param userVo
     * @return int
     * @Author AChan
     * @Date 2019/4/16 15:50
     **/
    int add(UserVo userVo);

    /**
     * 删除
     *
     * @param id
     * @return int
     * @Author AChan
     * @Date 2019/4/16 15:50
     **/
    int delete(String id);

    /**
     * 修改用户基本信息
     *
     * @param userVo
     * @return int
     * @Author AChan
     * @Date 2019/4/16 15:51
     **/
    int updateUserBase(UserVo userVo);

    /**
     * 分页查询
     *
     * @param userVo
     * @param page
     * @param num
     * @return
     */
    PageInfo selectUserVoPage(UserVo userVo, int page, int num);

    /**
     * 根据Id获取用户基本信息
     *
     * @param id
     * @return com.achan.entity.UserVo
     * @Author AChan
     * @Date 2019/4/16 15:51
     **/
    UserVo getUserBase(String id);

    /**
     * 获取用户完整信息
     *
     * @param id
     * @return com.achan.entity.UserVo
     * @Author AChan
     * @Date 2019/4/16 15:51
     **/
    UserVo getUserVo(String id);

    /**
     * 审核
     *
     * @param id
     * @param state
     * @return int
     * @Author AChan
     * @Date 2019/4/21 10:44
     **/
    int verify(String id, Byte state);

    /**
     * 根据手机获取用户信息
     *
     * @param phone
     * @return com.achan.entity.UserVo
     * @Author AChan
     * @Date 2019/4/21 12:52
     **/
    UserVo getByPhone(String phone);

}
