package com.atguigu.atcrowdfunding.demo;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

public class Test {
	public static void main(String[] args) {
//		shuixianhua(275);
		String jsonString = JSON.toJSONString("");
		System.out.println(jsonString);
		
		int [] i = {1};
		String string = ArrayUtils.toString(i);
		System.out.println(string );
		
		String join = StringUtils.join(Arrays.asList("2","3"), ",");
		System.out.println("josn-->"+join);


		System.out.println(ArrayUtils.contains(i, 1) &&  !ArrayUtils.contains(i, 2));
		System.out.println(ArrayUtils.contains(i, 1) );
		System.out.println(ArrayUtils.contains(i, 1) && ArrayUtils.contains(i, 2));
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
