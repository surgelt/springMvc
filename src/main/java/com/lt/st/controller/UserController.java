package com.lt.st.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lt.st.modle.User;


// @EnableAutoConfiguration
@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/{id}")
	public User view(@PathVariable("id") Long id) {
		long t1 = System.currentTimeMillis();
		
		User user = new User();
		user.setId(id);
		user.setName("zhang");
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		System.out.println("cost: "+(t2-t1));
		
		
		return user;
	}

	// public static void main(String[] args) {
	// SpringApplication.run(UserController.class);
	// }

}