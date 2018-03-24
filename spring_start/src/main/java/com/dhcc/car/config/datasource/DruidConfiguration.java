package com.dhcc.car.config.datasource;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 * ===>数据库监控配置
 * <p>
 * 这样的方式不需要添加注解：@ServletComponentScan
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2017-7-19 16:30
 * @version v1.1.5
 */
@SuppressWarnings("ALL")
@Configuration("druidConfiguration")
public class DruidConfiguration {
    /**
     * 注册一个StatViewServlet
     *
     * @return <code>servletRegistrationBean（数据源监控配置）</code>
     */
    @Bean(name = "druidStatViewServelt")
    public ServletRegistrationBean druidStatViewServelt() {
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/data/monitor/*");
        //添加初始化参数：initParams
        //白名单(允许访问数据监控ip)：
        /*servletRegistrationBean.addInitParameter("allow", "*");*/
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:无权访问.
        //servletRegistrationBean.addInitParameter("deny", "127.0.0.1");
        //登录查看信息的账号密码
        servletRegistrationBean.addInitParameter("loginUsername", "dhcc");
        servletRegistrationBean.addInitParameter("loginPassword", "2015my");
        //备用地址
        servletRegistrationBean.addUrlMappings("/monitor/car/*");
        //是否重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "true");
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     *
     * @return <code>FilterRegistrationBean</code>
     */
    @Bean(name = "druidStatFilter")
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.jpeg,*.png,*.css,*.ico,/data/monitor/*,/monitor/car/*");
        filterRegistrationBean.addInitParameter("principalSessionName", "USER_SESSION");
        filterRegistrationBean.addInitParameter("principalCookieName", "USER_COOKIE");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        filterRegistrationBean.addInitParameter("sessionStatEnable", "true");
        return filterRegistrationBean;
    }
}
