package cn.heima.day08;

/**
 * <p>Title: Demo_duotai</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 14:02
 */
public class Demo_duotai {
        public static void main(String[] args) {
            //如果没有方法重写,这样就失去多态的意义
            Father f = new Son();
            //编译看左边,运行看右边
            f.show();

            Son s = new Son();
            s.show();
        }
    }

    class Father
    {
        public void show(){
            System.out.println("父类的show方法");
        }
    }
    class Son extends Father
    {
        //子类实际上是有,这个方法是从父类里面继承过来的
    }

