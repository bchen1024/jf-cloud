package org.btsoft.jf.cloud.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * 
 * @author chenbin
 * @date 2018年6月16日 下午10:33:55
 */
@Configuration
public class JFCloudConfig {
	
	@Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
     return new MethodValidationPostProcessor();
    }

}
