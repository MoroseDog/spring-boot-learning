package com.jj.learning.springboot.chapter14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// 啟用審計(Auditing)
@EnableJpaAuditing
public class Chapter14Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter14Application.class, args);
	}

}
