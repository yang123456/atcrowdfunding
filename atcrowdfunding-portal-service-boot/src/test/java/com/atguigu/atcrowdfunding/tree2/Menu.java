package com.atguigu.atcrowdfunding.tree2;

import java.util.List;

public class Menu extends TreeNode<Menu> {
	String id;
	String parentId;
	String name;
	List<Menu> child;

	public Menu(String id, String name, String parentId) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	@Override
	public String getParentId() {
		return parentId;
	}

	@Override
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public List<Menu> getChild() {
		return this.child;
	}

	@Override
	public void setChild(List<Menu> child) {
		this.child = child;
	}

}
