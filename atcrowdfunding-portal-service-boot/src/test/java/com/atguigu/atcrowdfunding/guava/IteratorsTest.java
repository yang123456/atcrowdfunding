package com.atguigu.atcrowdfunding.guava;

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

public class IteratorsTest {
	public static void main(String[] args) {
//		1. 判断迭代器中的元素是否都满足某个条件 all 方法
		List<String> list = Lists.newArrayList("Apple", "Pear", "Peach", "Banana");
		Predicate<String> condition = new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return ((String) input).startsWith("P");
			}
		};
		boolean allIsStartsWithP = Iterators.all(list.iterator(), condition);
		System.out.println("all result == " + allIsStartsWithP);

//		all方法的第一个参数是Iterator，第二个参数是Predicate<String>的实现，这个方法的意义是不需要我们自己去写while循环了，他的内部实现中帮我们做了循环，把循环体中的条件判断抽象出来了。

//		2. 通过any判断迭代器中是否有一个满足条件的记录，any方法的参数和all方法一样，就不再具体举例了
		boolean anyIsStartsWithP = Iterators.any(list.iterator(), condition);
		System.out.println("all result == " + anyIsStartsWithP);

//		3. get方法获得迭代器中的第x个元素
		String secondElement = Iterators.get(list.iterator(), 1);
		System.out.println(secondElement);

//		4. filter方法过滤符合条件的项
		Iterator<String> startPElements = Iterators.filter(list.iterator(), new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return input.startsWith("P");
			}
		});
		while (startPElements.hasNext()) {
			String next = startPElements.next();
			System.out.println(next);
		}

//		5. find方法返回符合条件的第一个元素
		String length5Element = Iterators.find(list.iterator(), new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return input.length() == 5;
			}
		});
		System.out.println(length5Element);

//		6. transform方法，对迭代器元素做转换
		Iterator<Integer> countIterator = Iterators.transform(list.iterator(), new Function<String, Integer>() {
			@Override
			public Integer apply(String input) {
				return input.length();
			}
		});
		while (countIterator.hasNext()) {
			Integer next = countIterator.next();
			System.out.println(next);
		}
//		上面的案例中我们将字符串转换成了其长度，transform方法输出的是另外一个Iterator。
	}
}
