package com.jj.learning.springboot.chapter25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//啟用審計(Auditing)
@EnableJpaAuditing
//啟用緩存
@EnableCaching
public class Chapter25Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter25Application.class, args);
	}

}
