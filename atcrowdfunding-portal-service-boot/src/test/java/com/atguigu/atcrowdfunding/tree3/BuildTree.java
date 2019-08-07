package com.atguigu.atcrowdfunding.tree3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所谓的树形结构就是各个元素之间具有分层关系的数据结构，常用一棵倒置的树来表示逻辑关系。
 * 所谓的根节点就是树的最顶端的节点，
 * 继续往下分为子节点，
 * 当不断细分直到不再有子节点时为叶子节点。
 * 
 * 构建tree TODO <br>
 * @author kangxu2 2017-1-7
 *
 */
public class BuildTree {

	public static <T> List<Tree<T>> build3(List<Tree<T>> nodes) {
		List<Tree<T>> permissions = new ArrayList<Tree<T>>();
		Map<String, Tree<T>> permissionMap = new HashMap<String, Tree<T>>();
		for (Tree<T> p : nodes) {
			permissionMap.put(p.getId(), p);
		}
		for (Tree<T> p : nodes) {
			Tree<T> child = p;
			if (p.getPid() == null || "".equals(p.getPid())
					|| p.getPid().equals("0")) {
				permissions.add(p);
			} else {
				Tree<T> parent = permissionMap.get(child.getPid());
				parent.getChildren().add(child);
			}
		}
		return permissions;
	}

	public static <T> List<Tree<T>> build2(List<Tree<T>> nodes) {
		List<Tree<T>> permissions = new ArrayList<Tree<T>>();
		for (Tree<T> node : nodes) {
			// 子节点
			Tree<T> child = node;
			if (node.getPid() == null || "".equals(node.getPid())
					|| node.getPid().equals("0")) {
				permissions.add(node);
			} else {
				for (Tree<T> current : nodes) {
					if (child.getPid().equals(current.getId())) {//当前节点id==子节点的父亲id
						// 父节点
						Tree<T> parent = current;
						// 组合父子节点的关系
						parent.getChildren().add(child);
						break;
					}
				}
			}
		}
		return permissions;
	}
	

	/**
	 * 
	 * TODO <br>
	 * 
	 * @author kangxu2 2017-1-7
	 *
	 * @param nodes
	 * @return
	 */
	public static <T> Tree<T> build(List<Tree<T>> nodes) {

		if (nodes == null) {
			return null;
		}
		List<Tree<T>> topNodes = new ArrayList<Tree<T>>();

		for (Tree<T> children : nodes) {
			String pid = children.getPid();// 父id
			if (pid == null || "".equals(pid) || pid.equals("0")) {
				topNodes.add(children);

				continue;
			}

			for (Tree<T> parent : nodes) {
				String id = parent.getId();// 节点id
				if (id != null && id.equals(pid)) {
					// 组合父子节点的关系
					parent.getChildren().add(children);
					children.setHasParent(true);// 是否有父节点
					parent.setHasChild(true);// 是否有子节点
					parent.setAttributes(parent.getAttributes());
					continue;
				}
			}

		}

		Tree<T> root = new Tree<T>();// 根节点
		if (topNodes.size() == 1) {
			root = topNodes.get(0);
		} else {
			root.setId("-1");
			root.setPid("");
			root.setHasParent(false);
			root.setHasChild(true);
			root.setChecked(true);
			root.setChildren(topNodes);
			root.setName("顶级节点");
		}

		return root;
	}

}
