package com.dhcc.car.util;

/**
 * function 获取操作系统类型工具类
 *
 * @author dhcc[manjusakachn@gmail.com] on 2017/9/8.
 * @version V1.0
 */
public class OsNameUtil {

    /**
     * 定义初始变量为Linux系统
     */
    private final static String OSNAME = "linux";
    private final static String OS = "os.name";

    /**
     * 获取操作系统类型方法
     *
     * @return 操作系统类型
     */

    public static boolean getOsName() {
        String osName = System.getProperty(OS).toLowerCase();
        switch (osName) {
            case OSNAME:
                return true;
            default:
                return false;
        }
    }

}
