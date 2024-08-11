package com.tharusha.webhook_implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class WebhookImplementationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebhookImplementationApplication.class, args);
	}

}
