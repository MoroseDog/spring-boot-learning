package com.jj.learning.springboot.chapter35.task;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class SyncTask {

    public static Random random = new Random();

    public void doTaskOne() throws Exception {
        System.out.println("開始做同步任務一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成同步任務一，耗時：" + (end - start) + "毫秒");

    }

    public void doTaskTwo() throws Exception {
        System.out.println("開始做同步任務二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成同步任務二，耗時：" + (end - start) + "毫秒");
    }

    public void doTaskThree() throws Exception {
        System.out.println("開始同步做任務三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成同步任務三，耗時：" + (end - start) + "毫秒");
    }

}