package com.atguigu.atcrowdfunding.concurrency;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
 
public class ThredPoolTest {
	
	 private static ListeningExecutorService pool;
//	 private static int NUM= 100000000;
	 private static int NUM= 10000000;
	 static {
	        //通过guava创建固定容量的线程池，用完需要调用shutdown方法关闭线程池。
	        pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
	    }
 
	@Test
	public void test() throws InterruptedException, ExecutionException {
	    System.out.println("******用ListenableFuture异步操作******");
	    Instant now = Instant.now();
        Student student = new Student("元歌", "男", 12, "刺客");
        Person person = new Person();
        //将student和person相同的字段的值赋给person
        BeanCopierUtils.copyProperties(person, student);
        List<Student> studentList = new ArrayList<Student>();
        List<Person> personList = new ArrayList<Person>();
        ListenableFuture<List<Student>> studentFuture = pool.submit(() -> { 
        	  System.out.println("studentList 线程开始");
        	//这里使用了lambda表达式，
            for (int i = 0; i < NUM; i++) { 
            	//也可以直接通过匿名内部类实现callable，runnable区别，一个有返回值，一个没有返回值
            	studentList.add(student);
            }
            System.out.println("studentList 线程结束");
            return studentList;
        });
        ListenableFuture<List<Person>> personFuture = pool.submit(() -> {
        	  System.out.println("personList 线程开始");
            for (int i = 0; i < NUM; i++) {
            	personList.add(person);
            }
            System.out.println("personList 线程结束");
            return personList;
        });
        List<Student> sList = studentFuture.get();
		System.out.println("studentList获取");
		List<Person> pList = personFuture.get();
		System.out.println("personList获取");
        pool.shutdown();//用完之后关闭线程池
        Instant now1 = Instant.now();
        System.out.println(sList.size());
        System.out.println(pList.size());
        System.out.println("使用线程池耗时:"+Duration.between(now, now1).toMillis());
 
	}
 
	@Test
    public void test1() throws ExecutionException, InterruptedException {
	    System.out.println("******用普通For循环操作******");
        Instant now = Instant.now();
        Student student = new Student("司马懿", "男", 16, "刺客、法师");
        Person person = new Person();
        //将student和person相同的字段的值赋给person
        BeanCopierUtils.copyProperties(person, student);
        List<Student> studentList = new ArrayList<Student>();
        List<Person> personList = new ArrayList<Person>();
        for (int i = 0; i < NUM; i++) {
        	studentList.add(student);
        }
        for (int i = 0; i < NUM; i++) {
        	personList.add(person);
        }
        Instant now1 = Instant.now();
        System.out.println(studentList.size());
        System.out.println(personList.size());
        System.out.println("不使用线程池耗时："+Duration.between(now, now1).toMillis());
    }
 
}