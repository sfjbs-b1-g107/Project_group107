package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class PensionPortalApplication {
	
	@RequestMapping("/")
	public String home() {
		return "Service1";
	}

	public static void main(String[] args) {
		SpringApplication.run(PensionPortalApplication.class, args);
	}

}
