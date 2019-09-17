package cn.yang.test.day.excercise;

import java.util.Arrays;

//生成十个0~100之间的随机数，放到数组中，然后排序输出。（知识点：Math类取整,获得随机数等） [必做题]
//注*对于数组排序有冒泡排序和数组排序方法两种，任选其一即可
public class MyScort {
	public static void main(String[] args) {
		MyScort();
	}

	public static void MyScort() {

//      定义一个长度为10的数组用来存储随机数
		int[] arr = new int[10];

//      依次为数组存入是个随机数
		for (int i = 0; i < 10; i++) {
			arr[i] = (int) Math.round(Math.random() * 100);
		}

//      方法一—……冒泡排序，对数组的元素进行排序
		for (int j = 1; j <= arr.length; j++) {
			for (int i = 0; i < arr.length - j; i++) {
				int m = 0;
				if (arr[i] > arr[i + 1]) {
					m = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = m;
				}
			}
		}

//      方法二……数组方法排序
		Arrays.sort(arr);

//      遍历输出数组
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
