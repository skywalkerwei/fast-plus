package com.imguo.service.test;

import com.imguo.common.feign.annotation.FpEnableFeignClients;
import com.imguo.common.job.annotation.FpEnableXxlJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@FpEnableXxlJob
@FpEnableFeignClients
public class FpServiceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FpServiceTestApplication.class, args);
    }

}
