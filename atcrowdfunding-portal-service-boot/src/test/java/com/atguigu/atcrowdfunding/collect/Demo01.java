package com.atguigu.atcrowdfunding.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo01 {
	public static void main(String[] args) {
//		1.数组转化为List：
		String[] strArray = new String[] { "Tom", "Bob", "Jane" };

		List strList = Arrays.asList(strArray);

//		2.数组转Set
		String[] strArray1 = new String[] { "Tom", "Bob", "Jane", "Bob" };

		Set<String> staffsSet = new HashSet<>(Arrays.asList(strArray1));

		staffsSet.add("Mary"); // ok

		staffsSet.remove("Tom"); // ok
		System.out.println(staffsSet);
//		3.List转Set
		String[] staffs = new String[] { "Tom", "Bob", "Jane" };

		List staffsList = Arrays.asList(staffs);

		Set result = new HashSet(staffsList);

//		4.set转List
		String[] staffs1 = new String[] { "Tom", "Bob", "Jane" };

		Set<String> staffsSet1 = new HashSet<>(Arrays.asList(staffs));

		List<String> result1 = new ArrayList<>(staffsSet);
	}
}
