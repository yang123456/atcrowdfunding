package cn.heima.day07;

/**
 * <p>Title: Demo1_Constructor</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 11:11
 */
public class Demo1_Constructor {
    public static void main(String[] args) {
        Person p = new Person();				//在一创建对象的时候,系统就帮我调用了构造方法
        //p.Person();							//构造方法不能用对象调用
        p.show();

        Person p2 = new Person();				//再次创建对象

        p2.show();
    }
}
