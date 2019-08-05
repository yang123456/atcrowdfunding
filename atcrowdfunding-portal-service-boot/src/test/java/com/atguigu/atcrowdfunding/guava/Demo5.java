package com.atguigu.atcrowdfunding.guava;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.atguigu.atcrowdfunding.domain.User;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Demo5 {
	public static void main(String[] args) {
		List<User> userList = Lists.newArrayList(
				new User(1, "aa", 11), 
				new User(2, "bb", 12),
				new User(3, "cc", 13)
		);
		List<User> userList2 = Lists.newArrayList(
				new User(1, "aa", 11), 
				new User(2, "bb", 12),
				new User(3, "cc", 13)
		);
		//集合转map
		ImmutableMap<Integer, User> map = Maps.uniqueIndex(userList, new Function<User,Integer>() {
			@Override
			public Integer apply(User input) {
				return input.getId();
			}
		});
		System.out.println(map);
		HashMap<Object, Object> map2 = Maps.newHashMap();
		for (User user:userList) {
			map2.put(user.getId(), user.getName());
		}
		System.out.println(map2);
		
//		3. Strings的padStart和padEnd方法来补全字符串
		int minLength = 4;
		String padEndResult = Strings.padEnd("123", minLength, '0');
		System.out.println("padEndResult is " + padEndResult);

		String padStartResult = Strings.padStart("1", 2, '0');
		System.out.println("padStartResult is " + padStartResult);
	}
}
