package com.jj.learning.springboot.chapter33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Chapter33Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter33Application.class, args);
	}

}
