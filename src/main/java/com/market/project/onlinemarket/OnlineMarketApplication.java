package com.market.project.onlinemarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAutoConfiguration
@AutoConfiguration
@SpringBootApplication

public class OnlineMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMarketApplication.class, args);
	}

}
