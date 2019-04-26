package com.jj.learning.springboot.chapter37;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import com.jj.learning.springboot.chapter37.activemq.Sender;

@SpringBootApplication
public class Chapter37Application {
    
    @Autowired
    private Sender sender;

    @PostConstruct
    public void init() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        for (int i = 0; i < 1000; i++) {
//            sender.send("Hello J.J. Huang, This is message count" + i);
//        }
//        stopWatch.stop();
//        System.out.println("發送消息耗時:" + stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter37Application.class, args);
    }

}
