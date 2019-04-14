package com.jj.learning.springboot.chapter26.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // 建立一個隊列名稱為J.J.Huang
    @Bean
    public Queue jjQueue() {
        return new Queue("J.J.Huang");
    }
    
}
