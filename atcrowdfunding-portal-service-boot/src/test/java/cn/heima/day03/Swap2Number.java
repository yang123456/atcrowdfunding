package cn.heima.day03;

/**
 * <p>Title: Swap2Number</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 10:03
 */
public class Swap2Number {
    public static void main(String[] args) {
        //第一种方法 用第三方变量 交换位置
        int a = 3,b=4,temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a="+a+",b="+b);
        //第二种 针对数值 加减法运算
        int c=7,d = 10;
        c = c+d;
        d = c-d;
        c = c-d;
        System.out.println("c="+c+",d="+d);
        //第三种方法:异或 结论:异或两次等于本身
        int e = 5, f = 8;
        e = e ^ f;
        f = e ^ f; //f = e^f==>f = (e^f)^f ==>f = e
        e = e ^ f; // e = e^f==>e = e^(e^f) ==>e = f
        System.out.println("e="+e+",f="+f);
    }
}
