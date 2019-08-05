package cn.heima.day03;

/**
 * <p>Title: Demo</p>
 * <p>Description: 逻辑题</p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 10:15
 */
public class Demo {
    public static void main(String[] args) {
        //第一题
        demo1();
        //第二题
        demo2();
        //第三题
        demo3();
        //第四题
        demo4();
        //第五题
        demo5();
        //第六题
        demo6();
    }

    private static void demo6() {
        int x = 2,y=3;

        switch(x)
        {
            default:
                y++; //4
            case 3:
                y++; //5
                break;
            case 4:
                y++;
        }
        System.out.println("y="+y);
    }

    private static void demo5() {
        boolean b = true;

        if(b=false) //true == false;  //b
            System.out.println("a");
        else if(b)
            System.out.println("b");
        else if(!b)
            System.out.println("c");
        else
            System.out.println("d");
    }

    private static void demo4() {
        int x = 1,y = 1;

        if(x++==1 || ++y==1) //true
        {
            x =7;
        }
        System.out.println("x="+x+",y="+y); //x = 7,y = 1
    }

    private static void demo3() {
        int x = 1,y = 1;

        if(x++==1 | ++y==1) //true  | false  x = 7 y = 2;
        {
            x =7;
        }
        System.out.println("x="+x+",y="+y); //x= 7,y = 2
    }

    private static void demo2() {
        int x = 1,y = 1;

        if(x++==2 && ++y==2) //x = 2; y = 1
        {
            x =7;
        }
        System.out.println("x="+x+",y="+y);
    }

    private static void demo1() {
        int x = 1,y = 1;

        if(x++==2 & ++y==2) //false & true
        {
            x =7;
        }
        System.out.println("x="+x+",y="+y);   // x = 2,y = 2
    }
}
