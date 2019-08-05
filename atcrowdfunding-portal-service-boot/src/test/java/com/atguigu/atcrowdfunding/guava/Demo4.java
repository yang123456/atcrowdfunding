package com.atguigu.atcrowdfunding.guava;


import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class Demo4 {
		@Test
	    public void shouldPartition() throws Exception {

	        // given
	        List<Integer> numbersList = Lists.newArrayList(1, 2, 3, 0, -12, 22, 430, -1024);

	        // when
	        Iterable<List<Integer>> spartitionedLists = Iterables.partition(numbersList, 5);
	        System.out.println(spartitionedLists);
	        // then
//	        assertThat(Iterables.size(partitionedLists)).isEqualTo(2);
	        Iterator<List<Integer>> iterator = spartitionedLists.iterator();
	        while (iterator.hasNext()) {
	        	System.out.println(iterator.next());
			}
//	        assertThat(iterator.next().size()).isEqualTo(5);
//	        assertThat(iterator.next().size()).isEqualTo(3);
	        
	    }	
}
