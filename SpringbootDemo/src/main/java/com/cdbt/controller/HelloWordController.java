package com.cdbt.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdbt.domain.User;

/**
 * spring-boot domo controller
 * 
 * @author Administrator
 *
 */
@RestController
public class HelloWordController {

	@RequestMapping("hello")
	public User hello() {
		User user = new User();
		user.setId(1);
		user.setName("hello");
		user.setCreateTime(new Date());
		return user;
	}

}