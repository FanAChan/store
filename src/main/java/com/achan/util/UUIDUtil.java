package com.achan.util;

import java.util.UUID;

/**
 * @author AChan
 * @title: UUIDUtil
 * @date 2019/4/20
 */
public class UUIDUtil {

    public static String randomID() {
        String uuid = UUID.randomUUID().toString();
        String id = uuid.replaceAll("-", "");
        return id;
    }
}
