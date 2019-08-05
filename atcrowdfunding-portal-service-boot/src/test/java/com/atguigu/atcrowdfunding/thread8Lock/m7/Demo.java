package com.atguigu.atcrowdfunding.thread8Lock.m7;
/**
 *7）将两个方法中有Thread.sleep()的方法设置为static方法，另一个方法去掉static修饰，让两个线程用两个对象调用两个方法

结果说明：

被synchronized和static修饰的方法，锁的对象是类的class对象。仅仅被synchronized修饰的方法，锁的对象是方法的调用者。
即便是用同一个对象调用两个方法，锁的对象也不是同一个，所以两个方法用的不是同一个锁，后调用的方法不需要等待先调用的方法。

 */
public class Demo {
    public static void main(String[] args) {
        Number numberOne = new Number();
        Number numberTwo = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                numberOne.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                numberTwo.getTwo();
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

    public synchronized void getTwo() {
        System.out.println("two");
    }
}