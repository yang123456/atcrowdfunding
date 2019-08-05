package cn.heima.day05;

/**
 * <p>Title: Demo4_Array</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 10:48
 */
public class Demo4_Array {
    /*
     * A:静态初始化的格式：
     * 格式：数据类型[] 数组名 = new 数据类型[]{元素1,元素2,…};
     * 简化格式：
     * 数据类型[] 数组名 = {元素1,元素2,…};
     * B:案例演示
     * 对数组的解释
     * 输出数组名称和数组元素
     * C:画图演示
     * 一个数组
     */
    public static void main(String[] args) {
        //数据类型[] 数组名 = new 数据类型[]{元素1,元素2,…};
        //int[] arr = new int[5]{11,22,33,44,55};	//不允许动静结合
        int[] arr2 = {11,22,33,44,55};			//静态初始化的简写形式

        //int[] arr;								//声明数组引用
        //arr = new int[]{11,22,33,44,55};

        //int[] arr2;
        //arr2 = {11,22,33,44,55};				//简写形式声明和赋值在同一行

        System.out.println(arr2);
        System.out.println(arr2[4]);
    }
}
