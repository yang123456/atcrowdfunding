package com.atguigu.atcrowdfunding.java8;

import java.util.Arrays;
import java.util.Spliterator;
/**
 * 总结
分割遍历的主要目的是为了实现并行遍历
分割遍历是在原数组的基础上进行遍历，遍历的过程中不会对原数组的元素进行修改
分割的规则是从待遍历的范围的中间位置进行分割
执行tryAdvance之后待遍历的位置后移一位
 *
 */
public class Client {
    public static void main(String [] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        Spliterator<Integer> spliterator0 = Arrays.spliterator(arr);
        Spliterator<Integer> spliterator1 = spliterator0.trySplit();
        Spliterator<Integer> spliterator2 = spliterator1.trySplit();
        Thread t0 = new SpliteratorThread<>(spliterator0);
        t0.setName("t0");
        
        Thread t1 = new SpliteratorThread<>(spliterator1);
        t1.setName("t1");
        
        Thread t2 = new SpliteratorThread<>(spliterator2);
        t2.setName("t2");
        
        t0.start();
        t1.start();
        t2.start();
    }
}