package org.btsoft.jf.cloud.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 应用启动类
 * @author chenbin
 * @date 2018-11-27 23:06
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableSwagger2
@EnableAsync
public class CloudSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSsoApplication.class, args);
	}
}
