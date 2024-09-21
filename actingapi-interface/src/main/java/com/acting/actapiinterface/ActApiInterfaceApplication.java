package com.acting.actapiinterface;

import com.acting.actapiclientsdk.ActApiClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//@ComponentScan不会自动创建带有@ConfigurationProperties注解的类的bean
@EnableConfigurationProperties(ActApiClientConfig.class)
@SpringBootApplication
public class ActApiInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActApiInterfaceApplication.class, args);
	}

}
