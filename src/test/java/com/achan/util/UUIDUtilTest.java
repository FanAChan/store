package com.achan.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author AChan
 * @title: UUIDUtilTest
 * @date 2019/4/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UUIDUtilTest {

    @Test
    public void test(){
        String s = UUIDUtil.randomID();
        System.out.println(s);
    }
}
