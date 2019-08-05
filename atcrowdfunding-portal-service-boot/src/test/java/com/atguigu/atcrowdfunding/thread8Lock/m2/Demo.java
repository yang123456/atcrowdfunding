package com.atguigu.atcrowdfunding.thread8Lock.m2;
/**
 * 
 * 2）新增Thread.sleep()给某个方法
 *结果说明：

被synchronized修饰的方法，锁的对象是方法的调用者。
因为两个方法的调用者是同一个，所以两个方法用的是同一个锁，先调用方法的先执行，
第二个方法只有在第一个方法执行完释放锁之后才能执行。
 */
public class Demo {
    public static void main(String[] args) {
        Number number = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getTwo();
            }
        }).start();
    }
}

class Number {
    public synchronized void getOne() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public synchronized void getTwo() {
        System.out.println("two");
    }
}