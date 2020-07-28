package com.sirius.vpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //开启服务发现
@SpringBootApplication
public class VpnGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(VpnGatewayApplication.class, args);
	}

}





