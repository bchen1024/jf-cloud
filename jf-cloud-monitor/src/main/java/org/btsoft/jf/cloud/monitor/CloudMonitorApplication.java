package org.btsoft.jf.cloud.monitor;

import org.btsoft.jf.cloud.core.web.interceptor.RestTemplateRequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableSwagger2
@EnableAsync
public class CloudMonitorApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CloudMonitorApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
    public RestTemplate restTemplate() {
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.getInterceptors().add(new RestTemplateRequestInterceptor());
        return restTemplate;
    }
	
}
