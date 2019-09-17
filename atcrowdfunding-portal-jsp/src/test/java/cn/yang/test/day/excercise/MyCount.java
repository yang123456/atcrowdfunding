package cn.yang.test.day.excercise;

import java.util.Scanner;

//分别在控制台输入字符串和子字符串，并计算字符串中子字符串出现的次数。 [选做题]
public class MyCount {
	public static void main(String[] args) {
		MyCount();
	}

	public static void MyCount() {
		System.out.println("请输入一个字符串");
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println("请输入需要统计的子字符串");
		String str1 = in.next();

		String str2 = "";
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == str1.charAt(0)) {
				for (int j = i; j < str1.length(); j++) {
					str2 = str2 + str.charAt(j);
				}
				sum++;
				i = i + str2.length() - 1;
			}
		}
		System.out.println("字符串\"" + str + "\"中有" + sum + "个\"" + str1 + "\"");
	}
}
