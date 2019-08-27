package cn.yang.test.day;

public class 简单的桶排序 {
	public static void main(String[] args) {
		
		int [] score= {5,3,5,2,8};
		
		int [] bucket=new int[10];
		
		bucket[5]=2;
		bucket[3]=1;
		bucket[2]=1;
		bucket[8]=1;
		
		for (int i = 0; i < bucket.length; i++) {//遍历每一个桶
			if(bucket[i]!=0) {
				for (int j = 0; j < bucket[i]; j++) {//打印桶的编号，桶内有几个元素，打印机次
					System.out.println(i);
				}
			}
			
		}
		
	}
}
