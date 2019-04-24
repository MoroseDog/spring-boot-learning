package com.jj.learning.springboot.chapter36;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.learning.springboot.chapter36.task.CompleteAsyncTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter36ApplicationTests {

    @Autowired
    private CompleteAsyncTask completeAsyncTask;

    @Test
    public void test() throws Exception {
        CompletableFuture<String> futureResult = completeAsyncTask.doTaskOne();
        String result = futureResult.get(5, TimeUnit.SECONDS);
        log.info(result);
    }
}
