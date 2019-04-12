package org.btsoft.jf.cloud.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableAdminServer
public class CloudAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudAdminServerApplication.class, args);
	}
}
