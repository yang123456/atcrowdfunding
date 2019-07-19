package com.atguigu.atcrowdfunding.guava.eventBus;

import com.google.common.eventbus.EventBus;

public class ExceptionEventBusExample {
    public static void main(String[] args) {
        //在默认情况下，EventBus不会对异常信息进行处理，异常信息也不会终止EventBus的运行，只会简单的打印出异常堆栈信息。
        //在EventBus构造函数中传入SubscriberExceptionHandler来对异常信息进行处理
        //下面是通过lambda表达式来实现SubscriberExceptionHandler接口
        final EventBus eventBus = new EventBus((exception,context) -> {
            System.out.println("1> "+context.getEvent());//Exception event
            System.out.println("2> "+context.getEventBus());//defalut
            System.out.println("3> "+context.getSubscriber());//ExceptionListener
            System.out.println("4> "+context.getSubscriberMethod());//m3
        });
        eventBus.register(new ExceptionListener());
        eventBus.post("Exception event");
    }
}
//结论：在默认情况下，EventBus不会对异常信息进行处理，异常信息也不会终止EventBus的运行，
//只会简单的打印出异常堆栈信息。可以在EventBus构造函数中传入一个SubscriberExceptionHandler对象来对异常信息进行处理。
//上述代码是通过lambda表达式来实现了一个SubscriberExceptionHandler接口。


