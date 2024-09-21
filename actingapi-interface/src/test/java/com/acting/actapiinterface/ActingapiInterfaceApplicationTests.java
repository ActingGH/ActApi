package com.acting.actapiinterface;

import com.acting.actapiclientsdk.client.ActApiClient;
import com.acting.actapiclientsdk.model.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActingapiInterfaceApplicationTests {

	@Resource
	private  ActApiClient actApiClient;



	@Test
	void contextLoads() {
		String res=actApiClient.getNameByGet("acting");
		User user=new User();
		user.setUsername("acting");
		String res2=actApiClient.getUserNameByPost(user);
		System.out.println(res);
		System.out.println(res2);

	}

}
