package com.jj.learning.springboot.chapter26.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "J.J.Huang")
public class Receiver {

    // 接收到消息的處理方法
    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
    }

}
