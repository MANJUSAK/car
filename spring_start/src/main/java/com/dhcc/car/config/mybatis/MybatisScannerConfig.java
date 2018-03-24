package com.dhcc.car.config.mybatis;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 * ===> mybatis包扫描配置文件
 *
 * @author dhcc[manjusakachn@gmail.com] Created by on 2017/8/3.
 * @version v1.1.5
 */
@Configuration("mybatisScannerConfig")
@AutoConfigureAfter(MybatisConfig.class)
public class MybatisScannerConfig {

    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.dhcc.car.dao");
        mapperScannerConfigurer.setProcessPropertyPlaceHolders(false);
        return mapperScannerConfigurer;
    }
}
