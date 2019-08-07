package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.dao.ExtUserDao;
import com.atguigu.atcrowdfunding.extAnnotation.ExtResource;
import com.atguigu.atcrowdfunding.extAnnotation.ExtService;
import com.atguigu.atcrowdfunding.service.ExtUserService;

@ExtService(name = "abc")
public class ExtUserServiceImpl implements ExtUserService {
	
	@Override
	public String sayHello(String name) {
		return "hello "+name;
	}

	
}
