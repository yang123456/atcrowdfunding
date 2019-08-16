package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.shiro.User;

public interface UserService {
	User findUserByUserName(String username);
}
