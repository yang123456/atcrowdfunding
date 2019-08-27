package cn.yang.test.day;

import java.util.Arrays;

public class SortTest {
 
    public static void bubbleSort(int[] array) {
        //-1是因为最后一轮不需要排序
        for (int i = 0; i < array.length - 1; i++) {
        	System.out.println("第"+i+"轮排序开始");
            //-i是因为每一轮都能确定排序好一个数
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //交换
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("第"+i+"的排序结果为："+Arrays.toString(array));
        }
    }
    
    public static void bubbleSort1(int[] array) {
        //-1是因为最后一轮不需要排序
        for (int i = 0; i < array.length - 1; i++) {
        	System.out.println("第"+i+"轮排序开始");
            boolean isSorted = true;
            //-i是因为每一轮都能确定排序好一个数
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //交换
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //还在进行交换，表示未有序，还需要进行下一轮
                    isSorted = false;
                }
            }
            System.out.println("第"+i+"的排序结果为："+Arrays.toString(array));
            if (isSorted) {
                break;
            }
        }
    }
    
    public static void bubbleSort2(int[] array) {
        //-1是因为最后一轮不需要排序
        int sortedBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
        	System.out.println("第"+i+"轮排序开始");
            boolean isSorted = true;
            int sortedBorder1 = sortedBorder;
            for (int j = 0; j < sortedBorder1; j++) {
                if (array[j] > array[j + 1]) {
                    //交换
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //还在进行交换，表示未有序，还需要进行下一轮
                    isSorted = false;
                    //让下一轮不用比较右边有序的元素
                    sortedBorder = j;
                }
            }
            System.out.println("第"+i+"的排序结果为："+Arrays.toString(array));
            if (isSorted) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 8 ,6, 3, 9, 2, 1, 7};
 
//        bubbleSort(array);
//        bubbleSort1(array);
        bubbleSort2(array);
        System.out.println(Arrays.toString(array));
    }
}

//int[] array = new int[]{5, 8 ,6, 3, 9, 2, 1, 7};

//第0轮排序开始
//第0的排序结果为：[5, 6, 3, 8, 2, 1, 7, 9]
//第1轮排序开始
//第1的排序结果为：[5, 3, 6, 2, 1, 7, 8, 9]
//第2轮排序开始
//第2的排序结果为：[3, 5, 2, 1, 6, 7, 8, 9]
//第3轮排序开始
//第3的排序结果为：[3, 2, 1, 5, 6, 7, 8, 9]
//第4轮排序开始
//第4的排序结果为：[2, 1, 3, 5, 6, 7, 8, 9]
//第5轮排序开始
//第5的排序结果为：[1, 2, 3, 5, 6, 7, 8, 9]
//第6轮排序开始
//第6的排序结果为：[1, 2, 3, 5, 6, 7, 8, 9]


//[1, 2, 3, 5, 6, 7, 8, 9]