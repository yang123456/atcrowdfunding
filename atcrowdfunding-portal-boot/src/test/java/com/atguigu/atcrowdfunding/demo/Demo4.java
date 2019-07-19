package com.atguigu.atcrowdfunding.demo;

import com.atguigu.atcrowdfunding.proxy.cglibProxy.BookFacadeCglib;
import com.atguigu.atcrowdfunding.proxy.cglibProxy.BookFacadeImpl1;

public class Demo4 {
	public static void main(String[] args) {
		BookFacadeImpl1 bookFacade = new BookFacadeImpl1();
		BookFacadeCglib cglib = new BookFacadeCglib();
		BookFacadeImpl1 bookCglib = (BookFacadeImpl1) cglib.getInstance(bookFacade);
		bookCglib.addBook();
	}
}
