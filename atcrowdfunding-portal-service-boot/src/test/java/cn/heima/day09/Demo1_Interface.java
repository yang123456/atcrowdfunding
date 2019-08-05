package cn.heima.day09;

/**
 * <p>Title: Demo1_Interface</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 14:58
 */
public class Demo1_Interface {
    public static void main(String[] args) {
        //Inter i = new Inter();		//接口不能被实例化,因为调用抽象方法没有意义
        Inter i = new Demo1();			//父类引用指向子类对象
        i.print();
    }
}
/*
 * A:接口概述
 * 从狭义的角度讲就是指java中的interface
 * 从广义的角度讲对外提供规则的都是接口
 * B:接口特点
 * a:接口用关键字interface表示
 * interface 接口名 {}
 * b:类实现接口用implements表示
 * class 类名 implements 接口名 {}
 * c:接口不能实例化
 * 那么，接口如何实例化呢?
 * 按照多态的方式来实例化。
 * d:接口的子类
 * a:可以是抽象类。但是意义不大。
 * b:可以是具体类。要重写接口中的所有抽象方法。(推荐方案)
 * C:案例演示
 * 接口特点
 */
/*
 * 成员变量；只能是常量，并且是静态的并公共的。
 * 默认修饰符：public static final	三个关键字可以互相交换位置
 * 建议：自己手动给出。
 * 构造方法：接口没有构造方法。
 * 成员方法：只能是抽象方法。
 * 默认修饰符：public abstract
 * 建议：自己手动给出。
 */
/*
 * A:类与类,类与接口,接口与接口的关系
 * a:类与类：
 * 继承关系,只能单继承,可以多层继承。
 * b:类与接口：
 * 实现关系,可以单实现,也可以多实现。
 * 并且还可以在继承一个类的同时实现多个接口。
 * c:接口与接口：
 * 继承关系,可以单继承,也可以多继承。
 */
interface Inter {
    public abstract void print();					//接口中的方法都是抽象的
}

class Demo1 implements Inter {
    public void print() {
        System.out.println("print");
    }
}
