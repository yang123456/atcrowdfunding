package com.atguigu.atcrowdfunding.guava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.atguigu.atcrowdfunding.domain.User;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class Test01 {
	public static void main(String[] args) {
		ArrayList<User> personList = Lists.newArrayList();
		personList.add(new User(1, "zhangsan", 12));
		personList.add(new User(1, "zhangsan", 13));
		personList.add(new User(1, "zhangsan", 142));
		personList.add(new User(1, "lsi", 12));
		Collection<User> filter = Collections2.filter(personList, new Predicate<User>() {
			@Override
			public boolean apply(User input) {
				if(input.getAge() == 12) {
					System.out.println("======1==");
					return true;
				}
				System.out.println("======2==");
				return false;
			}
		});
		System.out.println(personList);
		ArrayList<User> newArrayList = Lists.newArrayList(filter);
		System.out.println(newArrayList);
//		ArrayList<User> aa = Lists.newArrayList();
//		for (User u:aa ) {
//			System.out.println(u);
//		}
//		
//		if(!"0".equals("1") && 1<0) {
//			System.out.println("dddd");
//		}
		
	}
}
