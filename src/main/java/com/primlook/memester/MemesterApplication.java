package com.primlook.memester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties(MemesterApplicationProperties.class)
@EnableFeignClients( value = "com.primlook.memester.infrastructure.facebook.service")
public class MemesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemesterApplication.class, args);
    }

}
