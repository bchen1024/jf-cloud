package org.btsoft.jf.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心启动类
 * @desc 
 * @author chenbin
 * @date 2018-11-27 22:10
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaServerApplication.class, args);
	}
}
