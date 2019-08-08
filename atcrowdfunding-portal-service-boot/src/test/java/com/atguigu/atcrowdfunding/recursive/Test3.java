package com.atguigu.atcrowdfunding.recursive;

import java.util.concurrent.TimeUnit;

import com.jayway.jsonpath.internal.function.numeric.Sum;

/**
 * 递归打印
 */

public class Test3 {
	public static void print(int n) throws InterruptedException {
//		TimeUnit.SECONDS.sleep(1);
		if(n==-1) {
			return;
		}
		System.out.println(n);
		n--;
		print(n); 
	}
	
	//1+2+3+-+100
	public static int sum(int n) {
		if(n==0) {
			return 0;
		}
//		100
//		100+(100-1)
//		100+(100-1)+(100-1)
		return n+sum(n-1); 
	}

	public static void main(String[] args) throws InterruptedException {
//		Test3.print(8);
		System.out.println(sum(5));
	}
}
