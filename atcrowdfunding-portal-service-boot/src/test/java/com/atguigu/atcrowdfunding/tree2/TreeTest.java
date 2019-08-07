package com.atguigu.atcrowdfunding.tree2;
 
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

 
 
public class TreeTest {
 
	/**
	 * 测试用例
	 */
	static void testCode() {
		Menu treeNode1 = new Menu("1", "广州", null);
		Menu treeNode2 = new Menu("2", "深圳", null);
 
		Menu treeNode3 = new Menu("3", "天河区", treeNode1.getId());
		Menu treeNode4 = new Menu("4", "越秀区", treeNode1.getId());
		Menu treeNode5 = new Menu("5", "黄埔区", treeNode1.getId());
		Menu treeNode6 = new Menu("6", "石牌", treeNode3.getId());
		Menu treeNode7 = new Menu("7", "百脑汇", treeNode6.getId());
 
		Menu treeNode8 = new Menu("8", "南山区", treeNode2.getId());
		Menu treeNode9 = new Menu("9", "宝安区", treeNode2.getId());
		Menu treeNode10 = new Menu("10", "科技园", treeNode8.getId());
 
		List<Menu> list = new ArrayList<Menu>();
		list.add(treeNode1);
		list.add(treeNode2);
		list.add(treeNode3);
		list.add(treeNode4);
		list.add(treeNode5);
		list.add(treeNode6);
		list.add(treeNode7);
		list.add(treeNode8);
		list.add(treeNode9);
		list.add(treeNode10);
 
		//法1 递归成树
		List<Menu> trees_ = TreeUtil.listToTree(list);
		System.out.println(JSON.toJSON(trees_));
		
 
	}
 
	public static void main(String[] args) {
		testCode();
	}
 
}
