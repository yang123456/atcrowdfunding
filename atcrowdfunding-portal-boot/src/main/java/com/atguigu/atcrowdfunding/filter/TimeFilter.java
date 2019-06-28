package com.atguigu.atcrowdfunding.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 *计时过滤器
 */
@Component
public class TimeFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("------TimeFilter |init|");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("------TimeFilter |doFilter start|");
		// 开始时间
		long start = new Date().getTime();
		// 过滤的实际业务
		chain.doFilter(request,response);
		// 结束时间 
		long end = new Date().getTime();
		System.out.println("------过滤用时：" + (end - start));
		System.out.println("------TimeFilter |doFilter end|");
	}

	@Override
	public void destroy() {
		System.out.println("------TimeFilter |destroy|");
	}



}