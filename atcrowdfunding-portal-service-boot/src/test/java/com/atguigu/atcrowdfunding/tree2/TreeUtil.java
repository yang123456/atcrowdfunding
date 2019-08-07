package com.atguigu.atcrowdfunding.tree2;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
 
public class TreeUtil {
 
	/**
	 * 列表转换为树
	 * 
	 * @param nodeList
	 * @return
	 */
	public static <T extends TreeNode<T>> List<T> listToTree(List<T> nodeList) {
		List<T> tree = new ArrayList<T>();
		for (T node : nodeList) {
			if (node.isTrunk()) {
				tree.add(findChildren(node, nodeList));
			}
		}
		return tree;
	}
 
	/**
	 * 递归查找子节点
	 * 
	 * @param nodeList
	 * @return
	 */
	public static <T extends TreeNode<T>> T findChildren(T node, List<T> nodeList) {
		for (T it : nodeList) {
			if (node.isParentOf(it)) {
				if (node.getChild() == null) {
					node.setChild(new ArrayList<T>());
				}
				node.getChild().add(findChildren(it, nodeList));
			}
		}
		return node;
	}
	
}
