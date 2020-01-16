package com.atguigu.atcrowdfunding.cache;

import java.util.concurrent.TimeUnit;

public class CacheMain {
	public static void main(String[] args) throws Exception {
		CodeCache codeCache = CodeCache.getInstance();
//		codeCache.setExpirationDuration(6).setExpirationTimeUnit(TimeUnit.SECONDS);
		codeCache.setRefreshDuration(1).setExpirationTimeUnit(TimeUnit.SECONDS);//1秒钟刷新一次
		codeCache.put("name", "张三");
		TimeUnit.SECONDS.sleep(5);//休息5秒
//		Object value = codeCache.getValue("name");
		Object value = codeCache.getValueOfDefault("name1", "默认值");
		System.out.println(value);
		
		
		System.out.println(false && 1>5);
		System.out.println(false && 5>1);
		System.out.println(true && 1>5);
		System.out.println(true && 5>1);
		boolean a="2".equals("1");
		System.out.println(a);
	}
}
