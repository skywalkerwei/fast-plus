package com.imguo.visual.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 监控模块
 *
 */
@EnableAdminServer
@SpringBootApplication
public class FpMonitorApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FpMonitorApplication.class, args);

    }
}
