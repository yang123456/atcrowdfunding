package com.atguigu.atcrowdfunding.guava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.atguigu.atcrowdfunding.domain.User;
import com.google.common.base.Function;
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

public class Demo01 {
	public static void main(String[] args) {
		// 集合创建：
		Map<String, Map<String, String>> map = Maps.newHashMap();
		List<List<Map<String, String>>> list = Lists.newArrayList();
//		集合初始化：
		Set<String> set = Sets.newHashSet("one", "two", "three");
		List<String> list1 = Lists.newArrayList("one", "two", "three");
		// Immutable Collections: 不可变的集合，还在使用 Collections.unmodifiableXXX() ？ Immutable
		// Collections 这才是真正的不可修改的集合
		ImmutableSet<String> immutableSet = ImmutableSet.of("RED", "GREEN");
//		 从构造的方式来说，ImmutableSet 集合还提供了 Builder 模式来构造一个集合 :
		Builder<String> builder = ImmutableSet.builder();
		ImmutableSet<String> immutableSet1 = builder.add("RED").addAll(set).build();
		System.out.println(immutableSet1);
		System.out.println("======Multimap======");
//		MultiMap：一种key可以重复的map，子类有ListMultimap和SetMultimap，对应的通过key分别得到list和set
		Multimap<String, User> customersByType = ArrayListMultimap.create();
		customersByType.put("abc", new User(1, "zhangsan", 12));
		customersByType.put("abc", new User(1, "lisi", 12));
		List<User> collection = (List<User>) customersByType.get("abc");
		System.out.println(customersByType.get("abc"));
		System.out.println(customersByType.size());
		System.out.println("======Multiset======");
//		Multiset：把重复的元素放入集合，并且可以统计重复元素的个数
		Multiset<Integer> multiSet = HashMultiset.create();
		multiSet.add(10);
		multiSet.add(30);
		multiSet.add(30);
		multiSet.add(40);
		System.out.println(multiSet.count(30)); // 2
		System.out.println(multiSet.size()); // 4
		System.out.println("======Table======");
//		Table：相当于有两个key的map。
		Table<Integer, Integer, User> personTable = HashBasedTable.create();
		personTable.put(1, 20, new User(1, "zhangsan", 12));
		personTable.put(2, 10, new User(1, "zhangsan", 12));
		personTable.put(0, 30, new User(1, "zhangsan", 12));
		// 得到行集合
		Map<Integer, User> rowMap = personTable.row(0);
		int maxAge = Collections.max(rowMap.keySet());
		System.out.println("Table的打印:"+personTable);
		System.out.println("Table的取值:"+personTable.get(1, 20));
		System.out.println(maxAge);
		System.out.println(rowMap);
		System.out.println(rowMap.keySet());
		System.out.println(maxAge);
		System.out.println("======BiMap======");
		// BiMap：java.util.Map 只能保证 key 的不重复，BiMap 保证 value
		// 也不重复，提供inverse()方法，可以通过key得到value，也可以通过value得到key
		// 双向map
		BiMap<Integer, String> biMap = HashBiMap.create();
		biMap.put(1, "hello");
		biMap.put(2, "my");
		int value = biMap.inverse().get("my");
		System.out.println("BiMap的取值:"+value);
		System.out.println("======ClassToInstanceMap======");
		// ClassToInstanceMap：有的时候，你的map的key并不是一种类型，他们是很多类型，你想通过映射他们得到这种类型，guava提供了ClassToInstanceMap满足了这个目的，除了继承自Map接口，
//		ClassToInstaceMap提供了方法 T getInstance(Class<T>) 和 T putInstance(Class<T>, T),消除了强制类型转换。
		ClassToInstanceMap<User> classToInstanceMap = MutableClassToInstanceMap.create();
		classToInstanceMap.putInstance(User.class, new User(1, "zhangsan", 12));
		User user = classToInstanceMap.getInstance(User.class);
		System.out.println(user);
//		Predicate：谓词是一个简单的接口，只有一个方法返回布尔值，但是他是一个很令人惊讶的集合方法，
//		当你结合collections2.filter方法使用，这个筛选方法返回原来的集合中满足这个谓词接口的元素。比如要按性别筛选：　　　　
		System.out.println("======Predicate======");
		ArrayList<User> personList = Lists.newArrayList();
		personList.add(new User(1, "zhangsan", 12));
		personList.add(new User(1, "zhangsan", 13));
		personList.add(new User(1, "zhangsan", 142));
		personList.add(new User(1, "lsi", 12));
		Collection<User> filter = Collections2.filter(personList, new Predicate<User>() {
			@Override
			public boolean apply(User input) {
				return input.getAge() == 12;
			}
		});
		System.out.println(filter);
//		　同时可以转换一个集合为另外一个集合：
		System.out.println("======transform======");
		List<String> transform = Lists.transform(personList, new Function<User, String>() {
			@Override
			public String apply(User input) {
				return input.getName();
			}
		});
		System.out.println(transform);
		// Ordering: 非常灵活的排序类，大家知道用 Comparator 作为比较器来对集合排序，
//		但是对于多关键字排序 Ordering class 可以简化很多的代码
		System.out.println("======Ordering======");
		ArrayList<Integer> numbers = Lists.newArrayList(30, 20, 60, 80, 10);
		Ordering.natural().sortedCopy(numbers); // 10,20,30,60,80
		System.out.println(Ordering.natural().sortedCopy(numbers));
		Ordering.natural().reverse().sortedCopy(numbers); // 80,60,30,20,10
		Ordering.natural().min(numbers); // 10
		Ordering.natural().max(numbers); // 80
		ArrayList<Integer> numbers1 = Lists.newArrayList(30, 20, 60, 80, null, 10);
		Ordering.natural().nullsLast().sortedCopy(numbers1); // 10, 20,30,60,80,null
		Ordering.natural().nullsFirst().sortedCopy(numbers1); // null,10,20,30,60,80
		System.out.println(Ordering.natural().nullsFirst().sortedCopy(numbers1));

		List<User> userList = Lists.newArrayList(
				new User(1, "aa", 11), 
				new User(2, "bb", 12),
				new User(3, "cc", 13)
		);

		Ordering<User> byAge = new Ordering<User>() {
			@Override
			public int compare(User left, User right) {
				return right.getAge() - left.getAge();
			}
		};
		for (User p : byAge.immutableSortedCopy(userList)) {
			System.out.println(p);
		}
		
		
		
}}
