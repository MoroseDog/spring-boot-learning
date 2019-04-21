package com.jj.learning.springboot.chapter32;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 啟用定時任務的配置
@EnableScheduling
public class Chapter32Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter32Application.class, args);
	}

}
