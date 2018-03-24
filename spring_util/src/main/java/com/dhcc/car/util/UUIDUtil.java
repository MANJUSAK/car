package com.dhcc.car.util;

import java.util.UUID;

/**
 * function UUID工具类
 * Created by  dhcc[manjusakachn@gmail.com] on 2017/8/4.
 *
 * @version v1.1.1
 */
public class UUIDUtil {
    /**
     * 生成前缀固定标识UUID
     *
     * @return StringBuilder
     */
    public static StringBuilder getUUID() {
        String str = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        String str2 = str.substring(0, 2);
        return new StringBuilder(str.replace(str2, "BK"));

    }

    /**
     * 生成前缀动态标识UUID
     *
     * @return StringBuilder
     */
    public static StringBuilder getUUID(String var) {
        String str = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        String str2 = str.substring(0, 2);
        return new StringBuilder(str.replace(str2, var));
    }

}
