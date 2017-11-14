package com.ying.js.car.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 村淘服务启动类
 * @author risheng
 */
@EnableAutoConfiguration
@ComponentScan({"com.ying"})
@SpringBootApplication
@EnableTransactionManagement
public class CarCrmApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CarCrmApplication.class, args);
	}
	
}
