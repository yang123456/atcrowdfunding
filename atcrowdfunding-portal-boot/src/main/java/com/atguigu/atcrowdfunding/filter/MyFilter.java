package com.atguigu.atcrowdfunding.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("访问了MyFilter的init方法");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("访问了MyFilter的doFilter方法");
		filterChain.doFilter(servletRequest, servletResponse);

	}

	@Override
	public void destroy() {
		System.out.println("访问了MyFilter的destroy方法");
	}

}
