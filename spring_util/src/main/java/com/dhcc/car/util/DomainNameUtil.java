package com.dhcc.car.util;

import javax.servlet.http.HttpServletRequest;

/**
 * function 获取服务器域名工具类
 * <p>
 * date 2017.08.04
 *
 * @author dhcc[manjusakachn@gmail.com]
 * @version v1.1.2
 */
public class DomainNameUtil {


    /**
     * @param request http请求
     * @return 服务器域名
     */
    public static StringBuilder getServerDomainName(HttpServletRequest request) {
        StringBuilder str;
        //判断服务器端口是否为80端开口 start
        if (request.getServerPort() == 80) {
            str = new StringBuilder(request.getScheme());
            str.append("://").append(request.getServerName());
        } else {
            str = new StringBuilder(request.getScheme());
            str.append("://").append(request.getServerName()).append(":").append(request.getServerPort());
        }
        //判断服务器端口是否为80端开口 end
        return str;
    }
}
