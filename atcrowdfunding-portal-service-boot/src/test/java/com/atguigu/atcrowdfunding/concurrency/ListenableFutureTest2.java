package com.atguigu.atcrowdfunding.concurrency;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Queue;
import java.util.concurrent.*;
/**
 * ListenableFuture根据结果，主动中断流程 -Java
 *	https://www.orchome.com/1180
 */
public class ListenableFutureTest2 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executor);
		final Queue<ListenableFuture<Boolean>> currentMiningTasks = new ConcurrentLinkedQueue<>();
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A(true)));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));
		currentMiningTasks.add(listeningExecutorService.submit(new A()));

		// 一定要调用这个方法，isTerminated()永远不为true
		listeningExecutorService.shutdown();
		executor.shutdown();

		for (final ListenableFuture<Boolean> task : currentMiningTasks) {
			try {
				System.out.println("结果..." + task.get());
				if (task.get()) { // 如果是true，则取消其他任务
					for (final ListenableFuture<Boolean> t : currentMiningTasks) {
						if (t != null && !t.isCancelled()) {
							t.cancel(true);
						}
					}
				}
			} catch (InterruptedException | CancellationException e) {
			} catch (Exception e) {
			}
		}

		while (true) {
			if (listeningExecutorService.isTerminated() && executor.isTerminated()) {
				System.out.println("listeningExecutorService executor结束");
				break;
			}
		}

		System.out.println("结束......");
	}

	static class A implements Callable {
		Boolean flag = false;

		public A() {
		}

		public A(Boolean flag) {
			this.flag = flag;
		}

		@Override
		public Object call() throws Exception {
			Thread.sleep(1000);
			return flag;
		}
	}
}
