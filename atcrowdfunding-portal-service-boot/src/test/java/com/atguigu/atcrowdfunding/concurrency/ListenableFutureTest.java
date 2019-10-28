package com.atguigu.atcrowdfunding.concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class ListenableFutureTest {
	// 与java原始的future处理总时间是一样的，但是是非阻塞的，可以再第一个任务很慢的情况下，先返回后面不慢的任务的结果。
	private static ListeningExecutorService service = MoreExecutors
			.listeningDecorator(Executors.newFixedThreadPool(20));

	public static void main(String[] args) {

		List<Integer> list = Lists.newArrayList(6, 5, 4, 3, 2, 1);

		for (Integer item : list) {
			ListenableFuture future = service.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					TimeUnit.SECONDS.sleep(item);
					return item;
				}
			});

			Futures.addCallback(future, new FutureCallback<Integer>() {

				@Override
				public void onSuccess(Integer result) {
					System.out.println("------");
					System.out.println(item);
					System.out.println(result);
					System.out.println("------");
				}

				@Override
				public void onFailure(Throwable t) {
					t.printStackTrace();
				}
			});
		}

		service.shutdown();

	}
}
