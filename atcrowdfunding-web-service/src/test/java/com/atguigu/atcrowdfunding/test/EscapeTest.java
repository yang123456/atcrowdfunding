package com.atguigu.atcrowdfunding.test;

import org.apache.commons.lang3.StringEscapeUtils;

public class EscapeTest {
	public static void main(String[] args) {
		String str = StringEscapeUtils.unescapeHtml4("&lt;p&gt;【产品名称】艾酷维多种'维生'素锌软糖&lt;/p&gt;");
		System.out.println(str);
		String str2 = StringEscapeUtils.escapeHtml4("<p>【产品名称】艾酷维多'种维'生素锌软糖</p>");
		System.out.println(str2);
	}
}
