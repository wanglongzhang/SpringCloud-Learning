package com.didispace;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableSwagger2Doc
@EnableDiscoveryClient
@SpringBootApplication
public class SwaggerServiceDemoApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(SwaggerServiceDemoApplication.class).web(true).run(args);
	}
}
