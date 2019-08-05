package cn.heima.day05;

/**
 * <p>Title: Demo3_Array</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 10:47
 */
public class Demo3_Array {
    /*
* A:栈(掌握)
	* 存储局部变量
	局部变量:定义在方法声明上和方法中的变量
* B:堆(掌握)
	* 存储new出来的数组或对象
* C:方法区
	* 面向对象部分讲解
* D:本地方法区
	* 和系统相关
* E:寄存器
	* 给CPU使用
*/
    public static void main(String[] args) {
        int[] arr = new int[3];						//动态初始化,创建3块连续的空间
        System.out.println(arr);
        arr[0] = 10;
        arr[1] = 20;

        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
}
