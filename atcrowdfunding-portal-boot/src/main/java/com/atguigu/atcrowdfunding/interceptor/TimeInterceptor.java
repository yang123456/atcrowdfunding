package com.atguigu.atcrowdfunding.interceptor;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 时间拦截器
 * @author Administrator
 *
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
	/** *进入被拦截的方法体之前执行  
	 * @return 返回结果为false：不执行postHandle和afterCompletion
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("******TimeInterceptor |preHandle| ");
		// 将开始时间添加到requestWebConfig
		request.setAttribute("start", new Date().getTime());
		HandlerMethod object = (HandlerMethod) handler; // 被过滤的方法
		Method method = object.getMethod(); // 被过滤的对象
		Object bean = object.getBean();
		System.out.println("***methodName***"+method.getName());
		System.out.println("***被代理的类***"+bean.getClass());
		return true;
	}

	/** *进入被拦截的方法体之后执行（一旦方法体中有异常，不执行） */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 获取开始时间
		long start = (long) request.getAttribute("start");
		System.out.println("******TimeInterceptor |postHandle| start"); //
		// 将开始时间从request移去
		request.removeAttribute("start");
		System.out.println("******TimeInterceptor耗时：" + (new Date().getTime() - start));
		System.out.println("******TimeInterceptor|postHandle| end");
	}

	/**
	 * 进入被拦截的方法体之后执行（始终进入）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("******TimeInterceptor |afterCompletion|");
	}
}