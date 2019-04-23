package com.jj.learning.springboot.chapter35.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AsyncTask {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Async("taskExecutor")
    public void doTaskOne() throws Exception {
        log.info("開始做異步任務一");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成異步任務一，耗時：" + (end - start) + "毫秒");

    }

    @Async("taskExecutor")
    public void doTaskTwo() throws Exception {
        log.info("開始做異步任務二");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成異步任務二，耗時：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskThree() throws Exception {
        log.info("開始做異步任務三");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成異步任務三，耗時：" + (end - start) + "毫秒");
    }

}
