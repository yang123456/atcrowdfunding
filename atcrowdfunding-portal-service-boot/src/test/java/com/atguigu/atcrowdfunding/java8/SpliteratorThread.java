package com.atguigu.atcrowdfunding.java8;

import java.util.Spliterator;
import java.util.function.Consumer;

public class SpliteratorThread<T> extends Thread {
    private Spliterator<T> mSpliterator;
    public SpliteratorThread(Spliterator<T> spliterator) {
        mSpliterator = spliterator;
    }
    
    @Override
    public void run() {
        super.run();
        if (mSpliterator != null) {
            mSpliterator.forEachRemaining(new Consumer<T>() {

                @Override
                public void accept(T t) {
                    // TODO Auto-generated method stub
                    System.out.println( Thread.currentThread().getName() + "-" + t + " ");
                }
            });
        }
    }
}
