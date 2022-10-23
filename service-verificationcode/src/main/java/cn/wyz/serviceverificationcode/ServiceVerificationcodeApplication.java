package cn.wyz.serviceverificationcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangnanxiang
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceVerificationcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceVerificationcodeApplication.class, args);
	}

}
