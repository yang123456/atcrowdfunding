package cn.heima.day10.静态内部类;
class Test1_InnerClass {
    public static void main(String[] args) {
        Outer2.Inner oi = new Outer2().new Inner();
        oi.show();
    }
}
//要求：使用已知的变量，在控制台输出30，20，10。
//内部类之所以能获取到外部类的成员,是因为他能获取到外部类的引用外部类名.this
class Outer2 {
    public int num = 10;
    class Inner {
        public int num = 20;
        public void show() {
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            //System.out.println(new Outer().num); //使用对象来访问成员变量
            System.out.println(Outer2.this.num);
        }
    }
}