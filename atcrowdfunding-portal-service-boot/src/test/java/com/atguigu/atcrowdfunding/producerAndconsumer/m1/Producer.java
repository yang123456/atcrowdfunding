package com.atguigu.atcrowdfunding.producerAndconsumer.m1;
/**
 * 生产者
 * @author Administrator
 *
 */
public class Producer implements Runnable{
    private Storage storage;

    public Producer(){}

    public Producer(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                storage.produce();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
