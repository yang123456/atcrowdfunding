package cn.heima.day09;

/**
 * <p>Title: Demo4_Animal</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 14:46
 */
public class Demo4_Animal {
    public static void main(String[] args) {
        //Cat c1 = new Cat();
        //c1.eat();
        method(new Cat1());
        method(new Dog1());

        //Animal a = new Cat();			开发的是很少在创建对象的时候用父类引用指向子类对象,直接创建子类对象更方便,可以使用子类中的特有属性和行为
    }

    //Cat c = new Dog();狗是一只猫,这是错误的
	/*public static void method(Cat c) {
		c.eat();
	}

	public static void method(Dog d) {
		d.eat();
	}*/

    //如果把狗强转成猫就会出现类型转换异常,ClassCastException
    public static void method(Animal1 a) {	//当作参数的时候用多态最好,因为扩展性强
        //关键字 instanceof 判断前边的引用是否是后边的数据类型
        if (a instanceof Cat1) {
            Cat1 c = (Cat1)a;
            c.eat();
            c.catchMouse();
        }else if (a instanceof Dog1) {
            Dog1 d = (Dog1)a;
            d.eat();
            d.lookHome();
        }else {
            a.eat();
        }
    }
}
/*
 * A:多态的好处
 * a:提高了代码的维护性(继承保证)
 * b:提高了代码的扩展性(由多态保证)
 * B:案例演示
 * 多态的好处
 * 可以当作形式参数,可以接收任意子类对象
 * C:多态的弊端
 * 不能使用子类的特有属性和行为。
 */

class Animal1 {
    public void eat() {
        System.out.println("动物吃饭");
    }
}

class Cat1 extends Animal1 {
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void catchMouse() {
        System.out.println("抓老鼠");
    }
}

class Dog1 extends Animal1 {
    public void eat() {
        System.out.println("狗吃肉");
    }

    public void lookHome() {
        System.out.println("看家");
    }
}
