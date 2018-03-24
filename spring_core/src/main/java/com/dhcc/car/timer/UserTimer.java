package com.dhcc.car.timer;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * description:
 * ===>用户定时器
 * company：
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-08 11:37
 * @version V1.0.0
 */
//@Configuration
@Async
public class UserTimer {
    @Scheduled(cron = "0/5 * * * * ?")
    public void userTimer() throws InterruptedException {
        String time = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println(Thread.currentThread().getName() + ":开始执行定时任务！执行时间为：" + time);
    }
}
