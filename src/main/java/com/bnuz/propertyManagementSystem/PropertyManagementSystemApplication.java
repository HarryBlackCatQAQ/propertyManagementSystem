package com.bnuz.propertyManagementSystem;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
@MapperScan("com.bnuz.propertyManagementSystem.dao")
@SpringBootApplication
@Slf4j
@EnableJpaAuditing
@EnableScheduling
public class PropertyManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyManagementSystemApplication.class, args);
    }

}
