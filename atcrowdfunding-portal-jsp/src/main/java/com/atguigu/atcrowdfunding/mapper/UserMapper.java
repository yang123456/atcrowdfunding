package com.atguigu.atcrowdfunding.mapper;

import com.atguigu.atcrowdfunding.domain.User;

public interface UserMapper {
	User findByUserName(String username);
}
