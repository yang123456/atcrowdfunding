package cn.heima.day09;

/**
 * <p>Title: Demo1_Abstract</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 14:52
 */
public class Demo1_Abstract {
    public static void main(String[] args) {
        //Animal a = new Animal();			//错误: Animal是抽象的; 无法实例化
        Animal2 a = new Cat2();				//父类引用指向子类对象
        a.eat();
    }
}
/*
 * B:抽象类特点
 * a:抽象类和抽象方法必须用abstract关键字修饰
 * abstract class 类名 {}
 * public abstract void eat();
 * b:抽象类不一定有抽象方法，有抽象方法的类一定是抽象类或者是接口
 * c:抽象类不能实例化那么，抽象类如何实例化呢?
 * 按照多态的方式，由具体的子类实例化。其实这也是多态的一种，抽象类多态。
 * d:抽象类的子类
 * 要么是抽象类
 * 要么重写抽象类中的所有抽象方法
 */
/*
 * A:抽象类的成员特点
 * a:成员变量：既可以是变量，也可以是常量。abstract是否可以修饰成员变量?不能修饰成员变量
 * b:构造方法：有。
 * 用于子类访问父类数据的初始化。
 * c:成员方法：既可以是抽象的，也可以是非抽象的。
 * B:案例演示
 * 抽象类的成员特点
 * C:抽象类的成员方法特性：
 * a:抽象方法 强制要求子类做的事情。
 * b:非抽象方法 子类继承的事情，提高代码复用性。
 */
abstract class Animal2 {						//抽象类
    public abstract void eat();				//抽象方法

    public Animal2() {
        System.out.println("父类空参构造");
    }
}

class Cat2 extends Animal2 {
    public Cat2() {
        super();
    }
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
