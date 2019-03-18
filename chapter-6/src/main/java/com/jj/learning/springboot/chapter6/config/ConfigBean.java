package com.jj.learning.springboot.chapter6.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 加入@Component啟動時自動加載
@Component
@ConfigurationProperties(prefix = "com.jj")
public class ConfigBean {

    private String name;
    
    private String want;
    
    private String sentence;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
    
}
