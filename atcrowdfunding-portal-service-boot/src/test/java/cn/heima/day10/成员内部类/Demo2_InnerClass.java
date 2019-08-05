package cn.heima.day10.成员内部类;
class Demo2_InnerClass {
    public static void main(String[] args) {
        //Outer.Inner oi = new Outer().new Inner();
        //oi.method();

        Outer1 o = new Outer1();
        o.print();
    }
}

class Outer1 {
    static  int num = 10;
    static class Inner {
        public void method() {
            System.out.println(num);
        }
    }

    public void print() {
        Inner i = new Inner();
        i.method();
    }
}