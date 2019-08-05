package com.atguigu.atcrowdfunding.guava.proxy;
//3.2 AbstractInvocationHandler
//       有时候你可能想动态代理能够更直观的支持equals()，hashCode()和toString()。AbstractInvocationHandler能帮我们做到三件事：
//
//一个代理实例equal另外一个代理实例，只要他们有同样的接口类型和equal的invocation handlers。
//一个代理实例的toString()会被代理到invocation handler的toString()，这样更容易自定义toString()。
//AbstractInvocationHandler确保传递给handleInvocation(Object, Method, Object[]))的参数数组永远不会空，从而减少了空指针异常的机会。
//如果对上面讲的几点不是很明白的话，强烈建议大家看下AbstractInvocationHandler的源码部分。

import java.lang.reflect.Method;
import static com.google.common.base.Preconditions.*;

import com.google.common.reflect.AbstractInvocationHandler;
import com.google.common.reflect.Reflection;

public class GuavaAbstractInvocationHandlerImpl<T> extends AbstractInvocationHandler {
    /**
     * 目标对象对应的接口(因为一个对象可以实现多个接口，我们不知道是那个接口，所以传递进来)
     */
    private Class<T> targetInterface;
    /**
     * 目标对象
     */
    private T targetObject;


    public GuavaAbstractInvocationHandlerImpl(Class<T> targetInterface, T targetObject) {
        /*参数判断*/
        // targetInterfaced一定要是一个接口
        checkArgument(targetInterface.isInterface(), "%s 不是一个接口类", targetInterface);
        // targetObject一定是targetInterface接口的实现类。
        boolean valid = false;
        Class<?>[] targetInterfaceList = targetObject.getClass().getInterfaces();
        if (targetInterfaceList != null && targetInterfaceList.length > 0) {
            for (Class<?> item : targetInterfaceList) {
                if (targetInterface.getName().equals(item.getName())) {
                    valid = true;
                    break;
                }
            }
        }
        checkArgument(valid, "%s 必须实现 %s", targetObject.getClass().getName(), targetInterface.getName());
        this.targetInterface = targetInterface;
        this.targetObject = targetObject;
    }

    /**
     * 获取都代理对象
     */
    public T getProxy() {
        // guava里面Reflection帮助类提供的 Reflection.newProxy() 实现
        return Reflection.newProxy(targetInterface, this);
    }

    @Override
    protected Object handleInvocation(Object proxy, Method method, Object[] args) throws Throwable {
        // 打印参数信息列表
        for (Object arg : args) {
            System.out.println(arg);
        }
        Object ret;
        try {
            /*原对象方法调用前处理日志信息*/
            System.out.println("方法开始执行-->>");
            //调用目标方法
            ret = method.invoke(targetObject, args);
            /*原对象方法调用后处理日志信息*/
            System.out.println("方法执行成功-->>");
        } catch (Exception e) {
            // 执行方法过程中出现异常
            e.printStackTrace();
            System.out.println("方法执行失败-->>");
            throw e;
        }
        return ret;
    }
}
