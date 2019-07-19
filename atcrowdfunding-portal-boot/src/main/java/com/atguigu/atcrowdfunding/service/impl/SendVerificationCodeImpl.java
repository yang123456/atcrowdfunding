package com.atguigu.atcrowdfunding.service.impl;

import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.cache.CodeCache;
import com.atguigu.atcrowdfunding.service.SendVerificationCode;
@Service
public class SendVerificationCodeImpl implements SendVerificationCode{
	/**
	 * 保存验证码进缓存 备注：验证码的缓存是设置了过期时间的（1min），
	 * 若“该手机号首次进入”或“该手机号对应的缓存已经过期”，此时调用“cache.get(key)”方法会抛出异常，
	 * 此时需要保存手机号，验证码进缓存，返回true；
	 * 若不抛出异常，则说明该缓存正处于有效期，用户在1min内重复请求发送验证码，无需保存进缓存，返回false
	 * 
	 * @param phone            手机号
	 * @param verificationCode 验证码
	 * @return 是否成功保存手机号、验证码进缓存
	 */
	@Override
	public boolean saveVerificationCode(String phone, String verificationCode) {
		CodeCache codeCache = CodeCache.getInstance();
		try {
			codeCache.getValue(phone);
			// 若不报异常，说明已存在该缓存，且未过期，说明在1min内重复请求了
			return false;
		} catch (Exception e) {
			// 当缓存过期或没有时，取值会报异常，说明此时可将验证码存入缓存
			codeCache.put(phone, verificationCode);
			return true;
		}
	}

	
}
