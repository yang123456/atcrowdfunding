package com.atguigu.atcrowdfunding.demo;

public class Test {
	public static void main(String[] args) {
		shuixianhua(275);
	}

	public static boolean shuixianhua(int x) {
		int i = 0, j = 0, k = 0;
		i = x / 100;
		j = (x % 100) / 10;
		k = x % 10;
		System.out.printf("i的值为%d, j的值为%d, k的值为%d",i,j,k);
		if (x == i * i * i + j * j * j + k * k * k)
			return true;
		else
			return false;
	}
}
