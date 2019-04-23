package com.jj.learning.springboot.chapter35;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.learning.springboot.chapter35.task.AsyncTask;

import lombok.SneakyThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter35ApplicationTests {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    @SneakyThrows
    public void test() {

        for (int i = 0; i < 200; i++) {
            asyncTask.doTaskOne();
            asyncTask.doTaskTwo();
            asyncTask.doTaskThree();

            if (i == 199) {
                System.exit(0);
            }
        }
    }

}
