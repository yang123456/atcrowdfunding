package cn.yang.test.day.excercise;

//编写一个程序，实现从命令行参数输入两个字符串类型的数值，并计算输出两个数值的和。 [必做题]
import java.util.Scanner;

public class MySum {
	public static void main(String[] args) {
		System.out.println("请输入两个字符串类型的数值……");
		Scanner in = new Scanner(System.in);
		String str1 = in.next();
		String str2 = in.next();
		MySum(str1, str2);
	}

	public static void MySum(String str1, String str2) {
		int x = Integer.parseInt(str1);
		int y = Integer.parseInt(str2);
		int sum = x + y;
		System.out.println(x + "与" + y + "两个数值的和为" + sum);
	}
}
