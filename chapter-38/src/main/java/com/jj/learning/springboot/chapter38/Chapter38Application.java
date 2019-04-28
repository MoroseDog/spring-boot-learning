package com.jj.learning.springboot.chapter38;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import com.jj.learning.springboot.chapter38.config.CustomFilter;

@SpringBootApplication
@ServletComponentScan
public class Chapter38Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter38Application.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 當過濾器有註入其他bean類時，可直接通過@bean的方式進行實體類過濾器，這樣不可自動注入過濾器使用的其他bean類。
        // 當然，若無其他bean需要獲取時，可直接new CustomFilter()，也可使用getBean的方式。
        registration.setFilter(customFilter());
        // 過濾器名稱
        registration.setName("customFilter");
        // 攔截路徑
        registration.addUrlPatterns("/*");
        // 設置順序
        registration.setOrder(10);
        return registration;
    }

    @Bean
    public Filter customFilter() {
        return new CustomFilter();
    }

}
