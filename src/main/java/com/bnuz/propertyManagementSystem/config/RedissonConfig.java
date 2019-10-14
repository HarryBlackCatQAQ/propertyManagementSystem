package com.bnuz.propertyManagementSystem.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Harry
 * @Date: 2019-10-14 15:04
 * @Version 1.0
 */
@Configuration
@Slf4j
public class RedissonConfig {

    @Value("${redisson.address}")
    private String addressUrl;

    @Value("${redisson.database}")
    private int database;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedissonClient getRedisson() throws Exception{
        RedissonClient redisson = null;
        Config config = new Config();
        config.useSingleServer()
                .setAddress(addressUrl)
                .setDatabase(database)
                .setPassword(password);
        redisson = Redisson.create(config);

       log.info(redisson.getConfig().toJSON().toString());
        return redisson;
    }


}