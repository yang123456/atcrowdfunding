package com.atguigu.atcrowdfunding.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.atguigu.atcrowdfunding.interceptor.TimeInterceptor;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {     
		registry.addInterceptor(new TimeInterceptor()).addPathPatterns("/time/**");
	}
}