package com.atguigu.atcrowdfunding.guava;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Multimap;

public class Demo6 {
	public static void main(String[] args) {
		  // given
        Multimap<String, String> multimap = ArrayListMultimap.create();

        // when
        multimap.put("Poland", "Warsaw");
        multimap.put("Poland", "Cracow");
        multimap.put("Poland", "Plock");
        multimap.put("Poland", "Gdansk");

        multimap.put("Germany", "Berlin");
        multimap.put("Germany", "Bremen");
        multimap.put("Germany", "Dortmund");
        multimap.put("Germany", "Koln");

        multimap.put("Portugal", "Lisbone");
        multimap.put("Portugal", "Porto");
        multimap.put("Portugal", "Leira");
        multimap.put("Portugal", "Funchal");
        multimap.put("Portugal", "Funchal");

		System.out.println(multimap.get("Poland").size());
		System.out.println(multimap.get("Portugal").size());
		System.out.println(multimap.get("Poland"));
		System.out.println(multimap.get("Poland").toArray()[1]);
		System.out.println(multimap.keys().size());
        // then
		
		System.out.println("===========");
		   BiMap<Integer, String> bimap = HashBiMap.create();

	        // when
	        bimap.put(1, "one");
	        bimap.put(2, "two");
	        bimap.put(10, "ten");
//	        bimap.put(11, "ten1");
	        bimap.put(10, "ten1");
//	        bimap.forcePut(1, "ten1");
//	        BiMap<String, Integer> inversedBiMap = bimap.inverse();
//	        System.out.println(inversedBiMap.get("one"));
	        System.out.println(bimap.size());
	        System.out.println(bimap);
	}
}
