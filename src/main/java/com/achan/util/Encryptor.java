package com.achan.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author AChan
 * @title: Encryptor
 * @date 2019/4/20
 */
public class Encryptor {

    private static final String ALGORITHM = "SHA";

    /**
     * 具体加密方式
     *
     * @param password
     * @param salt
     * @return byte[]
     * @Author AChan
     * @Date 2019/4/20 20:51
     **/
    private static byte[] digest(String password, byte[] salt) {

        try {
            MessageDigest msgDigest = MessageDigest.getInstance(ALGORITHM);
            if (salt != null && salt.length > 0) {
                msgDigest.update(salt);
            }
            byte[] digest = msgDigest.digest(password.getBytes());
            return digest;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * 加密，用户名当盐
     *
     * @param name
     * @param password
     * @return java.lang.String
     * @Author AChan
     * @Date 2019/4/20 20:53
     **/
    public static String createCredential(String name, String password) {
        byte[] salt = null;
        try {
            salt = name.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(digest(password, salt));
    }

}
