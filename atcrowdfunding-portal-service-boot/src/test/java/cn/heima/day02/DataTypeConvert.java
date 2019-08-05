package cn.heima.day02;

/**
 * <p>Title: DataTypeConvert</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 9:12
 */
public class DataTypeConvert {
    //基本数据类型，和引用数据类型；
    //基本数据类型分为：
    //byte
    //short
    //int
    //long
    //bolean
    //fort
    //double
    //char
    //数据类型转换：
    //	隐式转换：小的数据类型转换大的数据类型，
    //	强制转换：
    public static void main(String[] args) {
        //第一题：
        byte b1=3,b2=4,b;
        //b=b1+b2;//出错因为在JAVA虚拟机中默认是int类型转换，虚拟机不知道b1  ，b2 中的数值到底是多少，所有会抛出可能损失精度的错误;
        //虚拟机会把  b1,b2  转换成 int类型在进行运算，两个int类型的数值相加结果任然是int类型，int类型 不能赋值给 byte类型
        b=3+4;
        //第二题：
        //byte  by = 130;// byte 的数值范围是 126~-127  130已经超出byte取值范围
       //Error:(32, 20) java: 不兼容的类型: 从int转换到byte可能会有损失
        //第三题:
        byte b3 = 10;
        b3++;//这句  java虚拟机会做一个自动转换动作  相当于  b=(byte)(b+1)所以不会报错
        //b = b + 1;//这句java虚拟机会把，b转换成int类型 相当于  int b + int 类型的1 然后赋值给Byte类型 int是4个字节  byte是1个字节 所有会抛出损失精度

    }
}
