package cn.yang.test.day;

/**
 * https://blog.csdn.net/xiaoxiangyu5/article/details/49908887
 * 
 * 总结：
 * 
 * 对象的初始化顺序:首先执行父类静态的内容，父类静态的内容执行完毕后，接着去执行子类的静态的内容，
 * 当子类的静态内容执行完毕之后，再去看父类有没有非静态代码块，如果有就执行父类的非静态代码块，父类的非静态代码块执行完毕，
 * 接着执行父类的构造方法；父类的构造方法执行完毕之后，它接着去看子类有没有非静态代码块，
 * 如果有就执行子类的非静态代码块。子类的非静态代码块执行完毕再去执行子类的构造方法。
 * 
 * 
 * 总之一句话，静态代码块内容先执行，接着执行父类非静态代码块和构造方法，然后执行子类非静态代码块和构造方法。
 *
 */
public class 代码执行顺序 {
	private static 代码执行顺序 test = new 代码执行顺序();
	public static int count1;
	public static int count2 = 0;

	private 代码执行顺序() {
		System.out.println("执行构造方法前count1=" + count1 + "    count2==" + count2);
		count1++;
		count2 = 9999;
		System.out.println("执行构造方法后count1=" + count1 + "    count2==" + count2);
	}

	public static void main(String[] args) {
		System.out.println("执行主方法count1=" + count1 + "    count2==" + count2);
	}

}