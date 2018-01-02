package org.btsoft.jf.cloud.lookup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@EnableZuulProxy
public class JfCloudLookupApplication {

	public static void main(String[] args) {
		SpringApplication.run(JfCloudLookupApplication.class, args);
	}
}
