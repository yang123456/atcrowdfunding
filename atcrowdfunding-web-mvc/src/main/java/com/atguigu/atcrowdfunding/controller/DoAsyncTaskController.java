package com.atguigu.atcrowdfunding.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.atcrowdfunding.task.AsyncTask;
import com.atguigu.atcrowdfunding.task.LogAsyncTask;


@RestController
@RequestMapping("tasks")
public class DoAsyncTaskController {
	
	@Autowired
    private AsyncTask asyncTask;
	@Autowired
	private LogAsyncTask logAsyncTask;
	
    @RequestMapping("test1")
    public String test1() throws Exception {
    	
    	long start = System.currentTimeMillis();
    	
    	Future<Boolean> a = asyncTask.doTask11();
    	Future<Boolean> b = asyncTask.doTask22();
    	Future<Boolean> c = asyncTask.doTask33();
    	
    	while (!a.isDone() || !b.isDone() || !c.isDone()) {
    		if (a.isDone() && b.isDone() && c.isDone()) {
    			break;
    		}
    	}
    	
    	long end = System.currentTimeMillis();
    	
    	String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
    	System.out.println(times);
    	
    	return times;
    }
    
    @RequestMapping("test2")
    public String test2() throws Exception {
    	
    	long start = System.currentTimeMillis();
    	
    	Future<Boolean> a = logAsyncTask.doTask11();
    	Future<Boolean> b = logAsyncTask.doTask22();
    	Future<Boolean> c = logAsyncTask.doTask33();
    	
    	while (!a.isDone() || !b.isDone() || !c.isDone()) {
    		if (a.isDone() && b.isDone() && c.isDone()) {
    			break;
    		}
    	}
    	
    	long end = System.currentTimeMillis();
    	
    	String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
    	System.out.println(times);
    	
    	return times;
    }
}
