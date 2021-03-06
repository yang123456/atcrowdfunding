package com.atguigu.atcrowdfunding.desensitized.entity;

import com.atguigu.atcrowdfunding.desensitized.annotation.Desensitized;
import com.atguigu.atcrowdfunding.desensitized.enums.SensitiveTypeEnum;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-07-06 00:10:42
 */
public class UserServiceImpl implements UserService {
    @Desensitized(type = SensitiveTypeEnum.PASSWORD)
    private String userServiceName;

    public UserServiceImpl() {
    }

    public UserServiceImpl(String userServiceName) {
        this.userServiceName = userServiceName;
    }

    public String getUserServiceName() {
        return userServiceName;
    }

    public UserServiceImpl setUserServiceName(String userServiceName) {
        this.userServiceName = userServiceName;
        return this;
    }
}
