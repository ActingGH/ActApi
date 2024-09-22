package com.acting.actapigateway;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class ActapiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActapiGatewayApplication.class, args);
    }

}
