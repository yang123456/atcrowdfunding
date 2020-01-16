package com.atguigu.atcrowdfunding.test;

public class StringTest {
	public static void main(String[] args) {
//		String str="12312aaa456";
//		String replace = str.replace("aaa", "bbb");
//		System.out.println(replace);
//		Integer a=new Integer(1);
//		Integer b=new Integer(1);
//		Man man1=new Man(a);
//		Man man2=new Man(b);
//		System.out.println(man1.age==man2.age);

		int j = 1;
		try {
			j = 3 / 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("==========");
		}
	}

}

class Man {

	Integer age;

	public Man(Integer age) {
		this.age = age;
	}

}