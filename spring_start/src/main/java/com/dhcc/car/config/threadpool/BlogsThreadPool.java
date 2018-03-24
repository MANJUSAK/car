package com.dhcc.car.config.threadpool;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;

/**
 * description:
 * ===>线程池配置文件
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2017-11-12 10:58
 * @version v1.1.2
 */
@Configuration("blogsThreadPool")
@EnableAsync
public class BlogsThreadPool implements AsyncConfigurer, SchedulingConfigurer {
    @Value("${blogs.core.pool.size}")
    private int corePoolSize;
    @Value("${blogs.max.pool.size}")
    private int maxPoolSize;
    @Value("${blogs.queue.capacity}")
    private int queueCapacity;
    @Value("${blogs.task.scheduler.pool.size}")
    private int taskSchedulerPoolSize;
    @Value("${blogs.await.termination.seconds}")
    private int awaitTerminationSeconds;
    @Value("${blogs.wait.forTasksToComplete.onShutdown}")
    private boolean waitForTasksToCompleteOnShutdown;

    @Nullable
    @Bean(name = "blogsTaskScheduler")
    public ThreadPoolTaskScheduler blogsTaskScheduler() {
        //定时器线程池调度器配置
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(taskSchedulerPoolSize);
        scheduler.setAwaitTerminationSeconds(awaitTerminationSeconds);
        scheduler.setWaitForTasksToCompleteOnShutdown(waitForTasksToCompleteOnShutdown);
        return scheduler;
    }

    @Override
    public Executor getAsyncExecutor() {
        //线程池执行器
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setAwaitTerminationSeconds(taskSchedulerPoolSize);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        /*Executor scheduler = this.taskScheduler();*/
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        TaskScheduler taskScheduler = this.blogsTaskScheduler();
        scheduledTaskRegistrar.setTaskScheduler(taskScheduler);
    }
}
