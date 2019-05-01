package com.achan.service;

import com.achan.entity.GoodsTypeVo;
import com.achan.entity.RoleVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author AChan
 * @title: GoodsTypeServiceTest
 * @date 2019/5/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.achan.dao")
public class GoodsTypeServiceTest {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Test
    public void getAllRoleTest() {
        List<GoodsTypeVo> allRole = goodsTypeService.getAll();
        System.out.println(allRole);
    }
}
