package com.atguigu.atcrowdfunding.recursive;

/**
 * 
 * 计算1+2+。。。+1000的和
 */
public class Test1 {
	int sum = 0;
	int i = 1;

	public void sum() {
		sum += i;
		i++;
		if (i <= 1000) {
			sum();// 递归就是调用自身
		}
	}

	public static void main(String[] args) {
		Test1 s = new Test1();
		s.sum();
		System.out.println("计算结果是" + s.sum);
	}
}
