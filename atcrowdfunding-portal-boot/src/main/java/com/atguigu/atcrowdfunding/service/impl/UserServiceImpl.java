package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.mapper.UserMapper;
import com.atguigu.atcrowdfunding.service.UserService;
import com.atguigu.atcrowdfunding.shiro.User;

public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	
	@Override
	public User findUserByUserName(String username) {
		return userMapper.findUserByUserName(username);
	}

}
