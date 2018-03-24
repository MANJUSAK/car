package com.dhcc.car.config.filter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * ===>mvc配置属性类
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2017-12-28 10:06
 * @version 1.1.1
 */
@Configuration("webMvcConfigurer")
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    private static String urlPath = "/";
    private static String viewName = "redirect:/home.html";

    /**
     * 自定义系统主页
     *
     * @param registry <code>视图注册信息</code>
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(urlPath).setViewName(viewName);
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    /**
     * mvc返回json解析使用fastjson
     *
     * @param converters <code>FastJsonHttpMessageConverter</code>
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        /*GsonHttpMessageConverter converter1 = new GsonHttpMessageConverter();*/
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(fastMediaTypes);
        converter.setFastJsonConfig(config);
        converters.add(converter);
    }
}
