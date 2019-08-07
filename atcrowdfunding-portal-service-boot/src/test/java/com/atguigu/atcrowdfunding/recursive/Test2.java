package com.atguigu.atcrowdfunding.recursive;

/**
 * 下面我们用递归实现斐波那契数列
 * ：0、1、1、2、3、5、8、13、21、……在数学上，斐波纳契数列以如下被以递归的方法定义：F（0）=0，F（1）=1，F（n）=F(n-1)+F(n-2)（n≥2，n∈N*）
 * 求第n个数
 */

public class Test2 {
	public static int sum(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return sum(n - 1) + sum(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(Test2.sum(8));// 因为他的方法是静态的，可以直接调用
	}
}
