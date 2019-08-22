package com.atguigu.atcrowdfunding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.domain.User;
import com.atguigu.atcrowdfunding.mapper.UserMapper;
import com.atguigu.atcrowdfunding.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUserByUserName(String username) {
		return userMapper.findByUserName(username);
	}

}
