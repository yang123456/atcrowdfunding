package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.domain.User;

public interface UserService {
	User findUserByUserName(String username);
}
