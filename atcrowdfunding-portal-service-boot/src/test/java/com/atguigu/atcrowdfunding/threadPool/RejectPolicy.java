package com.atguigu.atcrowdfunding.threadPool;

public interface RejectPolicy {
	public void reject(Runnable task, MyThreadPoolExecutor myThreadPoolExecutor);
}
