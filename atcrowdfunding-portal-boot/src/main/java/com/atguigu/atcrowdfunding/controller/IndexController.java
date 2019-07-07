package com.atguigu.atcrowdfunding.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.atcrowdfunding.domain.User;
import com.atguigu.atcrowdfunding.jpa.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2018/3/23.
 *
 * @author zlf
 * @since 1.0
 */
@RestController
@Slf4j
public class IndexController {
//	@Autowired
//	UserRepository userRepository;

	@GetMapping("/")
	String index() {
		return "Spring Boot - Spring Data JPA - H2 Web Console";
	}

	@GetMapping("/saveh2")
	public void saveTest() throws Exception {
//		User user = new User();
//		user.setName("郑龙飞");
//		user.setUrl("http://merryyou.cn");
//		User result = userRepository.save(user);
//		log.info(result.toString());
	}
}