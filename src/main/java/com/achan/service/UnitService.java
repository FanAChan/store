package com.achan.service;

import com.achan.entity.UnitVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author AChan
 * @title: UnitService
 * @description: TODO
 * @date 2019/4/16
 */
public interface UnitService {


    /**
     * 新增
     *
     * @param unitVo
     * @return int
     * @Author AChan
     * @Date 2019/4/17 22:50
     **/
    int add(UnitVo unitVo);

    /**
     * 更新
     *
     * @param unitVo
     * @return int
     * @Author AChan
     * @Date 2019/4/17 22:51
     **/
    int update(UnitVo unitVo);

    /**
     * 删除
     *
     * @param id
     * @return int
     * @Author AChan
     * @Date 2019/4/17 22:51
     **/
    int delete(String id);

    /**
     * 分页查找
     *
     * @param unitVo
     * @param page
     * @param num
     * @return
     */
    PageInfo pageUnitVo(UnitVo unitVo, int pageNum, int pageSize);

    /**
     * 根据Id获取详细信息
     *
     * @param id
     * @return com.achan.entity.UnitVo
     * @Author AChan
     * @Date 2019/4/17 22:51
     **/
    UnitVo getById(String id);
}
