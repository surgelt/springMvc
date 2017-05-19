package com.lt.st.modle.service;

import org.springframework.stereotype.Component;

import com.lt.st.modle.User;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public User getUser() {
		User user = new User();
		user.setId(234l);
		user.setName("remote");
		// TODO Auto-generated method stub
		return user;
	}

}
