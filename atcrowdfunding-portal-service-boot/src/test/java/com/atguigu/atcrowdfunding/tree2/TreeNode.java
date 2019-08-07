package com.atguigu.atcrowdfunding.tree2;
 
import java.util.List;

import com.google.common.base.Objects;
 
 
/**
 * 树节点
 * 
 * @author gaofu
 *
 * @param <T>
 */
public abstract class TreeNode<T extends TreeNode<T>> {
 
	/**
	 * 判断是否是主枝干
	 * 
	 * @return
	 */
	public boolean isTrunk() {
		return getParentId() == null;
	}
 
	/**
	 * 判断本节点是否是node的父节点
	 * 
	 * @param node
	 * @return
	 */
	public boolean isParentOf(T node) {
		if (node != null) {
			return Objects.equal(node.getParentId(), this.getId());
		}
		return false;
	}
 
	/**
	 * 判断本节点是否是node的孩子节点
	 * 
	 * @param node
	 * @return
	 */
	public boolean isChildOf(T node) {
		if (node == null) {
			if (this.getParentId() == null) {
				return true;
			}
		} else {
			return Objects.equal(node.getId(), this.getParentId());
		}
		return false;
	}
 
	public abstract String getParentId();
 
	public abstract void setParentId(String parentId);
 
	public abstract String getId();
 
	public abstract void setId(String id);
 
	public abstract List<T> getChild();
 
	public abstract void setChild(List<T> child);
 
}
