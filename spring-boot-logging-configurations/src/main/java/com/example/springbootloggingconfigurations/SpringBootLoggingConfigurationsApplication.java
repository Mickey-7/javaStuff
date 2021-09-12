package com.example.springbootloggingconfigurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggingConfigurationsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLoggingConfigurationsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingConfigurationsApplication.class, args);

		LOGGER.info("simple log statement with inputs {}, {}, and {}",1,2,3);
	}

}
