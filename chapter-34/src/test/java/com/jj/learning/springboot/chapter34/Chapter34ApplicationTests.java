package com.jj.learning.springboot.chapter34;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.learning.springboot.chapter34.task.AsyncTask;
import com.jj.learning.springboot.chapter34.task.CompleteAsyncTask;
import com.jj.learning.springboot.chapter34.task.SyncTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter34ApplicationTests {

    @Autowired
    private SyncTask syncTask;

    @Autowired
    private AsyncTask asyncTask;

    @Autowired
    private CompleteAsyncTask completeAsyncTask;

//    @Test
//    public void test() throws Exception {
//        syncTask.doTaskOne();
//        syncTask.doTaskTwo();
//        syncTask.doTaskThree();
//    }
//
//    @Test
//    public void testAsync() throws Exception {
//        asyncTask.doTaskOne();
//        asyncTask.doTaskTwo();
//        asyncTask.doTaskThree();
//    }

    @Test
    public void testCompletable() throws Exception {
        // 任務開始時間
        long start = System.currentTimeMillis();
        
        CompletableFuture<String> one = completeAsyncTask.doTaskOne();
        CompletableFuture<String> two = completeAsyncTask.doTaskTwo();
        CompletableFuture<String> three = completeAsyncTask.doTaskThree();

        // 等待直到所有任務完成
        CompletableFuture.allOf(one, two, three).join();

        // 以下會等到任務都完成後才執行
        System.out.println("總共耗時: " + (System.currentTimeMillis() - start));
        
        // 將各個任務的執行結果印出
        System.out.println(one.get());
        System.out.println(two.get());
        System.out.println(three.get());
    }

}
