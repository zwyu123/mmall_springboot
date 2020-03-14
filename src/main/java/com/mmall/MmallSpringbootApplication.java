package com.mmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mmall.dao")
public class MmallSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmallSpringbootApplication.class, args);
	}

}
