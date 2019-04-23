package com.jj.learning.springboot.chapter34.task;

import java.util.Random;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AsyncTask {

    public static Random random = new Random();

    @Async("taskExecutor")
    public void doTaskOne() throws Exception {
        log.info("開始做異步任務一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成異步任務一，耗時：" + (end - start) + "毫秒");

    }

    @Async("taskExecutor")
    public void doTaskTwo() throws Exception {
        log.info("開始做異步任務二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成異步任務二，耗時：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskThree() throws Exception {
        log.info("開始做異步任務三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成異步任務三，耗時：" + (end - start) + "毫秒");
    }

}
