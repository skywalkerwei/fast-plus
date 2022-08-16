package com.imguo.visual.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableAdminServer
@SpringBootApplication
public class FpMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FpMonitorApplication.class, args);
	}

}
