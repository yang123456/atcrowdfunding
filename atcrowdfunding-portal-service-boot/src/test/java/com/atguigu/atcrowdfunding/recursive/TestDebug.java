package com.atguigu.atcrowdfunding.recursive;

import java.util.HashMap;
import java.util.Map;

public class TestDebug {
	public static void main(String[] args) {
		method1();
//		method2();
//		method3();
//		method4();
//		method5();
		Map map=new HashMap();
		map.put(null, "1");
		Object object = map.get(null);
		System.out.println(object);
	}

	private static void method5() {
		System.out.println("=====method5======");
		
	}

	private static void method4() {
		System.out.println("=====method4======");

	}

	private static void method3() {
		System.out.println("=====method3======");

	}

	private static void method2() {
		System.out.println("=====method2======");

	}

	private static void method1() {
		System.out.println("=====method1======");
		method2();
		method3();
		method4();
		method5();
	}
}
