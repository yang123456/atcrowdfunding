package com.atguigu.atcrowdfunding.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 二、禁止浏览器缓存所有动态页面 有3 个HTTP 响应头字段都可以禁止浏览器缓存当前页面，它们在 Servlet 中的示例代码如下：
 * •response.setDateHeader("Expires",-1);
 * •response.setHeader("Cache-Control","no-cache");
 * •response.setHeader("Pragma","no-cache");
 * 
 * 并不是所有的浏览器都能完全支持上面的三个响应头，因此最好是同时使用上面的三个响应头。 •Expires数据头：值为GMT时间值，为-1指浏览器不要缓存页面
 * •Cache-Control响应头有两个常用值： •no-cache指浏览器不要缓存当前页面。 •max-age:xxx指浏览器缓存页面xxx秒。
 *
 * 
 */
public class NoCacheFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 把ServletRequest强转成HttpServletRequest
		HttpServletRequest request = (HttpServletRequest) req;
		// 把ServletResponse强转成HttpServletResponse
		HttpServletResponse response = (HttpServletResponse) resp;
		// 禁止浏览器缓存所有动态页面
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void destroy() {

	}
}
