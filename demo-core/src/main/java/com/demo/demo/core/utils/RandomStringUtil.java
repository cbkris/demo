package com.demo.demo.core.utils;

import java.util.Random;

/**
 * Created by cb on 2017/4/11.
 */
public class RandomStringUtil {
    /**
     * 产生随机字符串，长度由参数指定。
     *
     * @param length 产生的字符串的长度
     * @return 已产生的字符串
     */
    public static String getRandString(int length) {
        String charList = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder rev = new StringBuilder();
        Random f = new Random();
        for (int i = 0; i < length; i++) {
            rev.append(charList.charAt(Math.abs(f.nextInt()) % charList.length()));
        }
        return rev.toString();
    }
}
