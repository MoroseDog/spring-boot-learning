package com.jj.learning.springboot.chapter24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// 啟用審計(Auditing)
@EnableJpaAuditing
// 啟用緩存
@EnableCaching
public class Chapter24Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter24Application.class, args);
	}

}
