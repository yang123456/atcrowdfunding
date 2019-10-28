package com.atguigu.atcrowdfunding.guava;

import com.google.common.base.CaseFormat;

/**
 * CaseFormat features
 */
public class CaseFormatTest {

	public static void main(String args[]) {
		CaseFormatTest tester = new CaseFormatTest();
		tester.testCaseFormat();
	}

	private void testCaseFormat() {
		System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
		System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
		System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
		System.out.println("----------");
		System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testdata"));
		System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, "TestData"));

		System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "TestData"));
		System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "testData"));

		System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "TestData"));

		System.out.println(true && false);// false
		System.out.println(false && true);// false
	}
}
