package com.atguigu.atcrowdfunding.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.CollectionUtils;


public class Demo41 {

	public static void main(String[] args) {
	
		String [] arr= {"1","2"};
		System.out.println(arr);
		System.out.println(ArrayUtils.contains(arr, "1") && ArrayUtils.contains(arr, "2"));
		
	}
	
}
