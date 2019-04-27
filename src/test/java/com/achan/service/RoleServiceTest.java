package com.achan.service;

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
 * @title: RoleServiceTest
 * @description: TODO
 * @date 2019/4/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.achan.dao")
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void getAllRoleTest(){
        List<RoleVo> allRole = roleService.getAll();
        System.out.println(allRole);
    }


}

