package org.btsoft.jf.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class JfCloudZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(JfCloudZuulApplication.class, args);
	}
}
