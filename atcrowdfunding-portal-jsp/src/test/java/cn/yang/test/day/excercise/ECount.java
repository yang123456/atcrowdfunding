package cn.yang.test.day.excercise;

//编写一个程序，实现从命令行参数输入一字符串，统计该字符串中字符“e”出现的次数。（识点：String中常用的方法） [必做题]
import java.util.Scanner;

public class ECount {
	public static void main(String[] args) {
		System.out.println("请输入一个字符串");
		Scanner in = new Scanner(System.in);
		String str = in.next();
		MyeCount(str);
	}

	public static void MyeCount(String str) {
		String str2 = "";
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'e') {
				sum++;
			}
		}
		System.out.println("字符串\"" + str + "\"中有" + sum + "个e字符");
	}
}
