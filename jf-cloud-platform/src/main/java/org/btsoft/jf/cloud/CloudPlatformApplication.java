package org.btsoft.jf.cloud;

import javax.servlet.Filter;

import org.btsoft.jf.cloud.core.web.filter.CloudRequestContextFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 云平台启动类
 * @author chenbin
 * @date 2018-12-07 19:14
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableSwagger2
@EnableAsync
public class CloudPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudPlatformApplication.class, args);
	}
	
	/**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(cloudRequestContextFilter());
        registration.addUrlPatterns("/*");
        registration.setName("cloudRequestContextFilter");
        return registration;
    }
    
    @Bean(name = "cloudRequestContextFilter")
    public Filter cloudRequestContextFilter() {
        return new CloudRequestContextFilter();
    }
}
