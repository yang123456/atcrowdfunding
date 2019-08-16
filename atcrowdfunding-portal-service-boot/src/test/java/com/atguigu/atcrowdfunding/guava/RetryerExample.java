//package com.atguigu.atcrowdfunding.guava;
//
//import java.io.IOException;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.TimeUnit;
//
//import com.google.common.base.Predicates;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class RetryerExample {
// 
//    public static void main(String[] args) throws Exception {
//        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
//                .retryIfResult(Predicates.<Boolean>isNull())    // 设置自定义段元重试源
//                .retryIfExceptionOfType(Exception.class)        // 设置异常重试源
//                .retryIfRuntimeException()                      // 设置异常重试源
//                .withStopStrategy(StopStrategies.stopAfterAttempt(5))   // 设置重试次数    设置重试超时时间？？？？
//                .withWaitStrategy(WaitStrategies.fixedWait(5L, TimeUnit.SECONDS)) // 设置每次重试间隔
//                .build();
// 
//        Callable<Boolean> task = new Callable<Boolean>() {
//            int i = 0;
//            @Override
//            public Boolean call() throws Exception {
//                i++;
//                log.info("第{}次执行！", i);
//                if (i<3) {
//                    log.info("模拟执行失败");
//                    throw new IOException("异常");
//                }
//                return true;
//            }
//        };
// 
//        try {
//            retryer.call(task);
//        } catch (ExecutionException e) {
//            log.error("error", e);
//        } catch (RetryException e) {
//            log.error("error", e);
//        }
//        
//        Boolean result = task.call();
//        log.info("成功输出结果：{}", result);
//    }
//    
//}
