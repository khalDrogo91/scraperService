package com.handzap.scraperService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.handzap.scraperService"})
public class ScraperServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScraperServiceApplication.class, args);
	}

}

