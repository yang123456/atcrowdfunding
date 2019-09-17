package cn.yang.test.day;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.add("1");
		stack.add("2");
		stack.add("3");
		stack.add("4");

		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.get(i));
		}
		System.out.println("------0-----");
		// 集合遍历方式
		for (String x : stack) {
			System.out.println(x);
		}
		System.out.println("------1-----");
		// 栈弹出遍历方式
//        while (s.peek()!=null) {     //不健壮的判断方式，容易抛异常，正确写法是下面的 
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
		System.out.println("------2-----");
		// 错误的遍历方式
//        for (Integer x : s) { 
//                System.out.println(s.pop()); 
//        } 
	}
}
