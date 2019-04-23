package com.jj.learning.springboot.chapter35;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
public class Chapter35Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter35Application.class, args);
    }

    @EnableAsync
    @Configuration
    class TaskPoolConfig {

        @Bean("taskExecutor")
        public Executor taskExecutor() {
            ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
            // 設置ScheduledExecutorService的池大小20。 默認值為1
            executor.setPoolSize(20);
            // 線程池名的前綴
            executor.setThreadNamePrefix("taskExecutor-");
            executor.setWaitForTasksToCompleteOnShutdown(true);
            executor.setAwaitTerminationSeconds(60);
            return executor;
        }

    }

}
