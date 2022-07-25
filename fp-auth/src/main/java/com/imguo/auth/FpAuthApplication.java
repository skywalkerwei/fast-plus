package com.imguo.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.imguo.feign")
public class FpAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(FpAuthApplication.class, args);
    }
}
