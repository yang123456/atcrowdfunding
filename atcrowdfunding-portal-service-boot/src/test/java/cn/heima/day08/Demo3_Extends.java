package cn.heima.day08;

/**
 * <p>Title: Demo3_Extends</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 14:17
 */
public class Demo3_Extends {
    public static void main(String[] args) {
        Sons s = new Sons();
        s.print();
    }
}
/*
* A:案例演示
	* a:不同名的变量
	* b:同名的变量
		子父类出现同名的变量只是在讲课中举例子有,在开发中是不会出现这种情况的
		子类继承父类就是为了使用父类的成员,那么如果定义了同名的成员变量没有意义了
*/

class Fathers {
    int num1 = 10;
    int num2 = 30;
}

class Sons extends Fathers {
    int num2 = 20;

    public void print() {
        System.out.println(this.num1);				//this既可以调用本类的,也可以调用父类的(本类没有的情况下)
        System.out.println(this.num2);				//就近原则,子类有就不用父类的了
        System.out.println(super.num2);
    }
}