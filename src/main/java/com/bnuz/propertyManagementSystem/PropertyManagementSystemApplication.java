package com.bnuz.propertyManagementSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.bnuz.propertyManagementSystem.dao")
@SpringBootApplication
public class PropertyManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyManagementSystemApplication.class, args);
    }

}
