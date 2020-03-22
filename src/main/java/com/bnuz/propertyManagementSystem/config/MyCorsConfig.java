package com.bnuz.propertyManagementSystem.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static org.springframework.web.cors.CorsConfiguration.ALL;

/**
 * 跨域配置
 *
 * @Author: Harry
 * @Date: 2019-09-20 20:18
 * @Version 1.0
 */

@Slf4j
@Configuration
public class MyCorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        log.info("允许跨域配置启动!");
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 限制了路径和域名的访问
                /*registry.addMapping("/api*").allowedOrigins("http://localhost:8081");*/
                registry.addMapping("/**")
                        .allowedOrigins(ALL)
                        .allowedMethods(ALL)
                        .allowedHeaders(ALL)
                        .allowCredentials(true);

            }
        };
    }
}