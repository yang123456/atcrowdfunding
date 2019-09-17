package cn.yang.test.day;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> queue = new PriorityQueue<String>();
//		queue.add("1");
//		queue.add("2");
//		queue.add("3");
//		queue.add("4");
		//初始化队列 
        for (int i = 0; i < 5; i++) { 
        	queue.offer(i+""); 
        } 
		// 集合方式遍历，元素不会被移除
		for (String x : queue) {
			System.out.println(x);
		}
		System.out.println("-------2-----");
		// 队列方式遍历，元素逐个被移除
		while (queue.peek() != null) {
			System.out.println(queue.poll());
		}
	}
}
