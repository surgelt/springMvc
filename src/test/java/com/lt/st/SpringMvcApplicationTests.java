package com.lt.st;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lt.st.modle.User;
import com.lt.st.modle.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMvcApplicationTests {

	@Bean
	public HttpInvokerProxyFactoryBean userServiceRemot() {
		HttpInvokerProxyFactoryBean p = new HttpInvokerProxyFactoryBean();
		p.setServiceUrl("http://localhost:8080/remote/user");
		p.setServiceInterface(UserService.class);
		return p;
	}

	@Autowired
	UserService userServiceRemot;

	@Test
	public void contextLoads() {
		User u = userServiceRemot.getUser();

		System.out.println("user=" + u);
	}

}
