package com.gakki.util;

import java.util.UUID;

/**
 * @program: ssm_system
 * @description: 随机ID生成
 * @author: Gakki
 * @create: 2020-10-31 17:10
 **/
public class UUIDUtils {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }

}
