package com.atguigu.atcrowdfunding.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SensitiveWordsFilter
 * @Auther: Mollen
 * @CreateTime: 2018-10-09 21:04:35
 * @Description: 敏感词过滤
 */
@WebFilter("/testServlet")
public class SensitiveWordsFilter implements Filter {
	// 1.创建敏感词汇集合
	private List<String> list = new ArrayList<>();

	// 2.加载敏感词汇文件
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		try {
			// ServletContext是servlet全局对象
			ServletContext servletContext = filterConfig.getServletContext();
			String path = servletContext.getRealPath("/WEB-INF/classes/敏感词.txt");
			BufferedReader br = new BufferedReader(new FileReader(path));

			String line = null;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			br.close();

			System.out.println(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3.创建代理对象，增强getParameter方法
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		ServletRequest proxy_request = (ServletRequest) Proxy.newProxyInstance(
				servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// 判断是否是getParameter方法
						if (method.getName().equals("getParameter")) {
							// 增强返回值，获取返回值
							String value = (String) method.invoke(servletRequest, args);
							if (value != null) {
								for (String str : list) {
									if (value.contains(str)) {
										value = value.replaceAll(str, "***");
									}
								}
							}
							return value;
						}
						return method.invoke(servletRequest, args);
					}
				});
		// 过滤器放行
		filterChain.doFilter(proxy_request, servletResponse);
	}

	@Override
	public void destroy() {
	}
}