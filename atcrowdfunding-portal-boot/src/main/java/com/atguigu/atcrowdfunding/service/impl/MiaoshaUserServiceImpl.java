//package com.atguigu.atcrowdfunding.service.impl;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.atguigu.atcrowdfunding.domain.MiaoshaUser;
//import com.atguigu.atcrowdfunding.service.MiaoshaUserService;
//import com.atguigu.atcrowdfunding.service.RedisService;
//
//public class MiaoshaUserServiceImpl implements MiaoshaUserService {
//
//	@Autowired
//	RedisService redisService;
//
//	public MiaoshaUser getByToken(HttpServletResponse response, String token) {
//		if (StringUtils.isEmpty(token)) {
//			return null;
//		}
//		MiaoshaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
//		// 延长有效期
//		if (user != null) {
//			addCookie(response, token, user);
//		}
//		return user;
//	}
//	
//	private void addCookie(HttpServletResponse response, String token, MiaoshaUser user) {
//		   redisService.set(MiaoshaUserKey.token, token, user);
//		   Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
//		   cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
//		   cookie.setPath("/");
//		   response.addCookie(cookie);
//		}
//}
