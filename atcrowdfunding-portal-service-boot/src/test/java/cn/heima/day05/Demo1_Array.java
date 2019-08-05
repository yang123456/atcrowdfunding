package cn.heima.day05;

/**
 * <p>Title: Demo1_Array</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 10:43
 */
public class Demo1_Array {
    /*
* A:为什么要有数组(容器)
	* 为了存储同种数据类型的多个值
* B:数组概念
	* 数组是存储同一种数据类型多个元素的集合。也可以看成是一个容器。
	* 数组既可以存储基本数据类型，也可以存储引用数据类型。

* C:数组定义格式
	数据类型[] 数组名 = new 数据类型[数组的长度];
*/
    public static void main(String[] args) {
        int x = 10;
        x = 20;

        System.out.println("x = " + x);

        //数据类型[] 数组名 = new 数据类型[数组的长度];
        int[] arr = new int[5];				//可以存储五个int类型的数据

		/*
		左边:
		int:数据类型
		[]:代表的数组,几个中括号就代表几维数组
		arr:合法的标识符

		右边:
		new:创建新的实体或对象
		int:数据类型
		[]:代表的数组
		5:代表数组的长度
		*/

    }
}
