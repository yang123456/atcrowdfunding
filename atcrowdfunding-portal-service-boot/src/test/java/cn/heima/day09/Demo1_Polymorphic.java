package cn.heima.day09;

/**
 * <p>Title: Demo1_Polymorphic</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 14:42
 */
public class Demo1_Polymorphic {
    /*
     * A:多态(polymorphic)概述
     * 事物存在的多种形态
     * B:多态前提
     * a:要有继承关系。
     * b:要有方法重写。
     * c:要有父类引用指向子类对象。
     * C:案例演示
     * 代码体现多态
     *
     *
     */
    /*
成员变量
编译看左边(父类),运行看左边(父类)
成员方法
编译看左边(父类)，运行看右边(子类)。动态绑定
静态方法
编译看左边(父类)，运行看左边(父类)。
(静态和类相关，算不上重写，所以，访问还是左边的)
只有非静态的成员方法,编译看左边,运行看右边

父类引用指向子类对象就是向上转型
*/
    public static void main(String[] args) {
        Cat c = new Cat();
        c.eat();

        Animal a = new Cat();				//父类引用指向子类对象
        a.eat();
    }
}
class Animal {
    public void eat() {
        System.out.println("动物吃饭");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("猫吃鱼");
    }
}