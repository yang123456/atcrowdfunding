package com.atguigu.atcrowdfunding.guava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.atguigu.atcrowdfunding.domain.User;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;

public class Demo7 {
	public static void main(String[] args) {
		ArrayList<User> personList = Lists.newArrayList();
		personList.add(new User(1, "zhangsan", 12));
		personList.add(new User(1, "zhangsan", 13));
		personList.add(new User(1, "zhangsan", 142));
		personList.add(new User(1, "lsi", 12));
//		　同时可以转换一个集合为另外一个集合：
		System.out.println("======transform======");
		List<String> transform = Lists.transform(personList, new Function<User, String>() {
			@Override
			public String apply(User input) {
				return input.getName();
			}
		});
		
		Preconditions.checkArgument(StringUtils.isBlank("1"), "kong");

	}
}
