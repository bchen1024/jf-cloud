package org.btsoft.jf.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 服务配置中心启动类
 * @author chenbin
 * @date 2019-04-18 20:26
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigServerApplication.class, args);
	}
}
