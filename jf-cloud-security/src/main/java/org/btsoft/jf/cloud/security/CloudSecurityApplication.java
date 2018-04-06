package org.btsoft.jf.cloud.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableSwagger2
@MapperScan("org.btsoft.jf.cloud.security.mapper")
public class CloudSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSecurityApplication.class, args);
	}
}
