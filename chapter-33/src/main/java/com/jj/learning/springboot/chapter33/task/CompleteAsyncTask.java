package com.jj.learning.springboot.chapter33.task;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CompleteAsyncTask {

    public static Random random = new Random();

    @Async
    public CompletableFuture<String> doTaskOne() throws Exception {
        System.out.println("開始做異步任務一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成異步任務一，耗時：" + (end - start) + "毫秒");
        return CompletableFuture.completedFuture("任務一完成");
    }

    @Async
    public CompletableFuture<String> doTaskTwo() throws Exception {
        System.out.println("開始做異步任務二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成異步任務二，耗時：" + (end - start) + "毫秒");
        return CompletableFuture.completedFuture("任務二完成");
    }

    @Async
    public CompletableFuture<String> doTaskThree() throws Exception {
        System.out.println("開始做異步任務三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成異步任務三，耗時：" + (end - start) + "毫秒");
        return CompletableFuture.completedFuture("任務三完成");
    }

}
