package com.example.wxorder.utils;

import java.util.Random;

/**
 * @Auther: 李清依
 * @Date: 2019/11/15 18:55
 * @Description:
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String getUniqueKey(){//加一个锁
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;//随机六位数
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
