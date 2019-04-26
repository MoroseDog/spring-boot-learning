package com.jj.learning.springboot.chapter37.config;


import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveConfig {
    
    // 建立一個隊列名稱為J.J.Huang
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("J.J.Huang");
    }

}
