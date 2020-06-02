package cn.yang.test.day;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {

		test1();
		test2();
		test3();

	}
	//精度丢失
	private static void test1() {
		double totalAmount = 0.09;
		double feeAmount = 0.02;
		double tradeAmount = totalAmount - feeAmount;

		System.out.println(tradeAmount);

	}

	//精度丢失
	private static void test2() {
		double totalAmount = 0.09;
		double feeAmount = 0.02;
		BigDecimal tradeAmount = new BigDecimal(totalAmount).subtract(new BigDecimal(feeAmount));
		System.out.println(tradeAmount);

	}

	//精度可保证
	private static void test3() {
		double totalAmount = 0.09;
		double feeAmount = 0.02;
		BigDecimal tradeAmount = new BigDecimal(String.valueOf(totalAmount)).subtract(new BigDecimal(String.valueOf(feeAmount)));
		System.out.println(tradeAmount);

	}

}
