package com.privalia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootProjectApplication {
	private final static Logger logger = LoggerFactory.getLogger(SpringbootProjectApplication.class.getName());

	public static void main(String[] args) {
		logger.info("info msg");
		logger.debug("debug msg");
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}
}
