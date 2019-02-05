package com.example.restproyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestSimuganApplication {
	
//	private static final Logger logger = LogManager.getLogger(RestSimuganApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RestSimuganApplication.class, args);
	}
	
//	public void run(ApplicationArguments applicationArguments) throws Exception {
//        logger.debug("Debugging log");
//        logger.info("Info log");
//        logger.warn("Hey, This is a warning!");
//        logger.error("Oops! We have an Error. OK");
//        logger.fatal("Damn! Fatal error. Please fix me.");
//    }
	
}
