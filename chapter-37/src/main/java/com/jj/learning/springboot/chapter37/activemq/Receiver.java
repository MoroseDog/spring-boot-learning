package com.jj.learning.springboot.chapter37.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @JmsListener(destination = "J.J.Huang")
    public void receive(String message) {
        System.out.println("收到的 message 是：" + message);
    }
}
