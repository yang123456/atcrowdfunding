package com.atguigu.atcrowdfunding.demo;

public class Demo5 {
	public static void main(String[] args) {
		// >>表示带符号右移，如：int i=15; i>>2的结果是3，移出的部分将被抛弃。
		// 转为二进制的形式可能更好理解，
		// 0000 1111(15)右移2位的结果是0000 0011(3)，
		// 0001 0010(18)右移3位的结果是0000 0010(2)。
		System.out.println(15 >> 2);
		System.out.println(18 >> 3);
		System.out.println(32 >> 3);// 0010 0000 (32) ==> 0000 0100 ==> 4
		
		System.out.println("=======");
		printInfo(15);
		printInfo(18);
		printInfo(32);
	}

	/**
	 * 26 * 输出一个int的二进制数 27 * @param num 28
	 */
	private static void printInfo(int num) {
		System.out.println(Integer.toBinaryString(num));
	}
}
