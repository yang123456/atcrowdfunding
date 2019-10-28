package com.atguigu.atcrowdfunding.cache;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

/**
 * @author 潘畅
 * @date 2018/6/8 17:17
 */
public class CodeCache extends BaseGuavaCache<String, Object> {

	private static CodeCache codeCache;

	/**
	 * 单例模式
	 */
	public static CodeCache getInstance() {
		if (codeCache == null) {
			synchronized (CodeCache.class) {
				if (codeCache == null) {
					codeCache = new CodeCache();
				}
			}
		}
		return codeCache;
	}

	/**
	 * 在这里初始化必要参数（比如过期时间，定期刷新时间，缓存最大条数等）
	 */
	private CodeCache() {
		this.setExpirationDuration(1).setExpirationTimeUnit(TimeUnit.MINUTES)//1分钟过期
				.setRefreshDuration(-1) // 不刷新缓存
				.setMaxSize(1000);
	}

	@Override
	public void loadValueWhenStarted() {
		System.out.println("======CodeCache========loadValueWhenStarted=====");
	}

	/**
	 * 缓存中不存在或者过期会调用
	 */
	@Override
	protected Object getValueWhenExpired(String key) throws Exception {
		System.out.println("======CodeCache========getValueWhenExpired=====");
		/**
		 * 缓存没找到，取数据库或者其他地方找
		 */
		Object data = getData(key);
		return data;
	}

	/**
	 * 查询数据库
	 */
	public Object getData(String key) {
		ArrayList<Object> list = Lists.newArrayList();
		list.add("1");
		list.add(100);
		list.add("zhan");
		return list;
	}

}
