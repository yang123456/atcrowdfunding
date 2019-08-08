package com.atguigu.atcrowdfunding.desensitized.entity;

import java.io.Serializable;

import com.atguigu.atcrowdfunding.desensitized.annotation.Desensitized;
import com.atguigu.atcrowdfunding.desensitized.enums.SensitiveTypeEnum;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Package
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-06-22 14:54:21
 */
public class UserPackage implements Serializable{
    private static final long serialVersionUID = -3387516993124229938L;

    private BaseUserInfo baseUserInfo;
    private boolean flag;
    @Desensitized(type = SensitiveTypeEnum.CHINESE_NAME)
    private String userPackageName;

    public BaseUserInfo getBaseUserInfo() {
        return baseUserInfo;
    }

    public UserPackage setBaseUserInfo(BaseUserInfo baseUserInfo) {
        this.baseUserInfo = baseUserInfo;
        return this;
    }

    public boolean isFlag() {
        return flag;
    }

    public UserPackage setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserPackageName() {
        return userPackageName;
    }

    public UserPackage setUserPackageName(String userPackageName) {
        this.userPackageName = userPackageName;
        return this;
    }
}
