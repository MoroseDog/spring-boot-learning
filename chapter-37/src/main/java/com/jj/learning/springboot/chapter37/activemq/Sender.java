package com.jj.learning.springboot.chapter37.activemq;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender implements CommandLineRunner {

    @Autowired
    // 也可以注入JmsTemplate，JmsMessagingTemplate對JmsTemplate進行了封裝
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
//        for (int i = 0; i <= 1000; i++) {
//            send("Hello J.J. Huang, This is message count" + i);
//        }
//        System.out.println("Messages was sent to the Queue");
    }

    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

}
