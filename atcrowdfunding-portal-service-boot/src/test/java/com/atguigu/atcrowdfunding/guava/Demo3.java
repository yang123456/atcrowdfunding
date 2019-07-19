package com.atguigu.atcrowdfunding.guava;

import com.google.common.base.Objects;

public class Demo3 {
	public static void main(String[] args) {
//		guava中的对象操作封装
//		在开发中经常会需要比较两个对象是否相等，这时候我们需要考虑比较的两个对象是否为null，然后再调用equals方法来比较是否相等，google guava库的com.google.common.base.Objects类提供了一个静态方法equals可以避免我们自己做是否为空的判断，示例如下：
		Object a = null;
		Object b = new Object();
		boolean aEqualsB = Objects.equal(a, b);
		System.out.println(aEqualsB);
		
		//源码
//		Objects.equals的实现是很完美的，其实现代码如下：
//
//		public static boolean equal(@Nullable Object a, @Nullable Object b) {
//		     return a == b || (a != null && a.equals(b));
//		}
//		首先判断a b是否是同一个对象，如果是同一对象，那么直接返回相等，如果不是同一对象再判断a不为null并且a.equals(b). 这样做既考虑了性能也考虑了null空指针的问题。
	}
}
