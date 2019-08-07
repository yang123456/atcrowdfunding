package com.atguigu.atcrowdfunding.tree3;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * tree TODO <br>
 * 
 * @author kangxu2 2017-1-7
 * 
 */
public class Tree<T> {
	/**
	 * 节点ID
	 */
	private String id;
	/**
	 * 显示节点文本
	 */
	private String name;
	/**
	 * 节点状态，open closed
	 */
	private String state = "open";
	/**
	 * 节点是否被选中 true false
	 */
	private boolean checked = false;
	/**
	 * 节点属性
	 */
	private List<Map<String, Object>> attributes;
	/**
	 * 节点的子节点
	 */
	private List<Tree<T>> children = new ArrayList<Tree<T>>();

	/**
	 * 父ID
	 */
	private String pid;
	/**
	 * 是否有父节点
	 */
	private boolean hasParent = false;
	/**
	 * 是否有子节点
	 */
	private boolean hasChild = false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<Map<String, Object>> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Map<String, Object>> attributes) {
		this.attributes = attributes;
	}

	public List<Tree<T>> getChildren() {
		return children;
	}

	public void setChildren(List<Tree<T>> children) {
		this.children = children;
	}

	public boolean isHasParent() {
		return hasParent;
	}

	public void setHasParent(boolean hasParent) {
		this.hasParent = hasParent;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public Tree(String id, String name, String state, boolean checked,
			List<Map<String, Object>> attributes, List<Tree<T>> children, boolean hasParent, boolean hasChild,
			String pid) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
		this.children = children;
		this.hasParent = hasParent;
		this.hasChild = hasChild;
		this.pid = pid;
	}

	public Tree() {
		super();
	}

	@Override
	public String toString() {

		return JSON.toJSONString(this);
	}

}
