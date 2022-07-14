package com.imguo.service.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.imguo.feign")
public class FpServiceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FpServiceTestApplication.class, args);
    }

}
