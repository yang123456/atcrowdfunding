package cn.yang.test.day;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.atguigu.Test;

public class Demo3 {

	public static void main(String[] args) {
		Map map=null;
//		Map map=new HashMap();
//		map.put("aa", "123");
//		map.put("bb", "123");
//		map.remove("bb");
		System.out.println(CollectionUtils.isEmpty(map));
		Object object = map.get("bb");
		System.out.println(object);
		System.out.println(map);
		
//		System.out.println(test(1));
		long begin = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
//			if(i==999) {
//				System.out.println(i);
//			}
		}
		long end = System.nanoTime();
		System.out.println("time:"+(end-begin));
	}

	private static int test(Integer a) {
		try {
			return a/0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
}
