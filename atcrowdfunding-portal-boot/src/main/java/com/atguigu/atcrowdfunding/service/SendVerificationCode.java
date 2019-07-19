package com.atguigu.atcrowdfunding.service;

public interface SendVerificationCode {
	boolean saveVerificationCode(String phone, String verificationCode);
}
