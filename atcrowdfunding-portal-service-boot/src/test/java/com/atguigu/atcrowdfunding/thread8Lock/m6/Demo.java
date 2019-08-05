package com.atguigu.atcrowdfunding.thread8Lock.m6;
/**
 *6）将两个方法均设置为static方法，并且让两个线程用同一个对象调用两个方法

结果说明：

被synchronized和static修饰的方法，锁的对象是类的class对象。因为两个同步方法都被static修饰了，所以两个方法用的是同一个锁，后调用的方法需要等待先调用的方法。
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
    public static synchronized void getOne() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }
}