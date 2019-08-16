package com.atguigu.atcrowdfunding.mapper;

import com.atguigu.atcrowdfunding.shiro.User;

public interface UserMapper {
	User findUserByUserName(String username);
}
