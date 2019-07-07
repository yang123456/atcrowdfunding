package com.atguigu.atcrowdfunding.aspect;
import java.lang.reflect.Field;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.stereotype.Component;
/**
 * 计时所用的aop
 */
@Aspect
@Component
public class TimeAspect {
	@Around("execution(* com.atguigu.atcrowdfunding.controller.*.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("========TimeAspect |aspect start|");
		long start = new Date().getTime();

		// 获取methodInvoke
		Field proxy = pjp.getClass().getDeclaredField("methodInvocation");
		proxy.setAccessible(true);
		ReflectiveMethodInvocation methodInvoke = (ReflectiveMethodInvocation) proxy.get(pjp);

		// 获取增强的类
		String controller = methodInvoke.getMethod().getDeclaringClass().getName();
		// 获取增强的方法名
		String method = methodInvoke.getMethod().getName();
		// 获取增强方法的参数
		Object[] args = methodInvoke.getArguments();
//        Object[] args = pjp.getArgs();

		System.out.println("========增强的类:" + controller);
		System.out.println("========增强的方法:" + method);
		for (Object arg : args) {
			System.out.println("========增强的方法的参数:" + arg);
		}

		Object object = pjp.proceed();
		System.out.println("========TimeAspect aspect 耗时:" + (new Date().getTime() - start));

		System.out.println("========TimeAspect |aspect end|");

		return object;
	}
}
