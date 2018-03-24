package com.dhcc.car.config.filter;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * description:
 * ===>配置文件上传请求大小
 *
 * @author dhcc[manjusakachn@gmail.com] on 2017/8/7.
 * @version v1.1.0
 */
@Configuration("multipartConfig")
public class MultipartConfig {
    /**
     * 最大值
     */
    private static String max = "50MB";


    @Bean(name = "multipartConfigElement")
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory multipartConfig = new MultipartConfigFactory();
        //单次上传文件总数
        multipartConfig.setMaxFileSize(max);
        //每次http请求大小最大值
        multipartConfig.setMaxRequestSize(max);
        return multipartConfig.createMultipartConfig();
    }
}
