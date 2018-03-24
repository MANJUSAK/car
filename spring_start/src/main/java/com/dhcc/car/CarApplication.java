package com.dhcc.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * function 系统启动程序入口
 *
 * @author dhcc[manjusakachn@gmail.com] on 2017/11/7.
 * @version v1.1.0
 */
@SuppressWarnings("ALL")
@ServletComponentScan(basePackages = "com.dhcc.car.config.*")
@ComponentScan(basePackages = "com.dhcc.car.*")
@SpringBootApplication
@EnableScheduling
public class CarApplication extends SpringBootServletInitializer implements CommandLineRunner {
    /**
     * 实例化日志管理
     */
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private static long startTime = 0L;
    private static long endTime = 0L;
    private static double between = 0.0;
    private static final int MS = 1000;
    private static String sec = "S";
    private static String msec = "MS";

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        System.out.println("=================>正在启动系统！请等待...<==============");
        SpringApplication.run(CarApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        startTime = System.currentTimeMillis();
        System.out.println("=================>正在启动系统！请等待...<==============");
        return application.sources(CarApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        endTime = System.currentTimeMillis();
        between = endTime - startTime;
        if (between > MS) {
            between = between / MS;
            this.LOG.info("=================>系统启动成功!启动用时：" + between + sec + "<==============");
        } else {
            this.LOG.info("=================>系统启动成功!启动用时：" + between + msec + "<==============");
        }
        System.out.println("=================>系统启动成功，请使用！<==============");
    }
}
