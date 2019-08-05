package cn.heima.day10.局部内部类;
class Demo1_InnerClass {
    public static void main(String[] args) {
        Outer o = new Outer();
        o.method();
    }
}
//局部内部类
class Outer {
    public void method() {
        final int num = 10; //Demo1_InnerClass.java:13: 错误: 从内部类中访问本地变量num; 需要被声明为最终类型
        class Inner {
            public void print() {
                System.out.println(num);
            }
        }

        Inner i = new Inner();
        i.print();
    }

	/*public void run() {
		Inner i = new Inner();				//局部内部类,只能在其所在的方法中访问
		i.print();
	}*/
}