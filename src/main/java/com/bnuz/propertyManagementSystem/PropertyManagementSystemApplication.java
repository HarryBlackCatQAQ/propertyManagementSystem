package com.bnuz.propertyManagementSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
@MapperScan("com.bnuz.propertyManagementSystem.dao")
@SpringBootApplication
public class PropertyManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyManagementSystemApplication.class, args);
    }

}
