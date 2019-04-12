package org.btsoft.jf.cloud.core.configuration;

import org.btsoft.jf.cloud.core.web.interceptor.RestTemplateTokenInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author chenbin
 * @date 2018年6月16日 下午10:33:55
 */
@Configuration
@ComponentScan({"org.btsoft.jf.cloud.core"})
public class JFCloudAutoConfiguration {
	
	@Bean
	@LoadBalanced
    public RestTemplate restTemplate() {
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.getInterceptors().add(new RestTemplateTokenInterceptor());
        return restTemplate;
    }

}
