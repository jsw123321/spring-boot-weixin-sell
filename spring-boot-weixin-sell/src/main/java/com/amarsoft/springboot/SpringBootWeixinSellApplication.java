package com.amarsoft.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("")
public class SpringBootWeixinSellApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeixinSellApplication.class, args);
	}

}
