package cn.yang.test.day;

public class Demo2 {
	private static String name = "123";
	static {
//		System.out.println(1 / 0);
		name = "456";
	}

	public static void main(String[] args) {
		byte a =0;
		char x='1';
		char y='2';
		a |= x ^ y;
		System.out.println(a);
	}

}
