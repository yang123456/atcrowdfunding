package com.atguigu.atcrowdfunding.task;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
/**
 * //开启异步调用方法
	@EnableAsync  加上这个注解，才能开启@Async
 * @author Administrator
 *
 */
@Component
//@EnableAsync
public class AsyncTask {
	
	@Async
    public Future<Boolean> doTask11() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"任务1耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }
    
	@Async
    public Future<Boolean> doTask22() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"任务2耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }
    
	@Async
    public Future<Boolean> doTask33() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(600);
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"任务3耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true); 
    }
}
