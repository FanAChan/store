package com.achan.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author AChan
 * @title: EncryptorTest
 * @date 2019/4/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptorTest {

    @Test
    public void test(){
        String s = Encryptor.createCredential("fanwuyin","12345678");
        System.out.println(s);
        System.out.println("------------------------------------------");
        String s2 = Encryptor.createCredential("fanwuyin","1234567891234567");
        System.out.println(s2);
    }
}
