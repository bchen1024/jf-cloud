package org.btsoft.jf.cloud.zuul;

import org.btsoft.jf.cloud.zuul.filter.AuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 
 * @author chenbin
 *
 */
@SpringBootApplication
@EnableZuulProxy
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CloudZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudZuulApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
    public RestTemplate restTemplate() {
		RestTemplate restTemplate=new RestTemplate();
        return restTemplate;
    }
	
	@Bean
	public AuthorizationFilter authorizationFilter(){
		return new AuthorizationFilter();
	}

	/**
	 * 实现网关跨域功能
	 * @return
	 * @autor chenbin
	 * @date 2019-05-07 20:20
	 */
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin(CorsConfiguration.ALL);
		config.addAllowedHeader(CorsConfiguration.ALL);
		config.addAllowedMethod(CorsConfiguration.ALL);
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
