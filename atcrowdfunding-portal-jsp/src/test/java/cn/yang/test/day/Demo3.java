package cn.yang.test.day;

import com.atguigu.Test;

public class Demo3 {

	public static void main(String[] args) {
		System.out.println(test(1));
	}

	private static int test(Integer a) {
		try {
			return a/0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
}
