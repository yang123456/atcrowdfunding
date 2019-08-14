package com.atguigu.atcrowdfunding.recursive;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.atguigu.atcrowdfunding.tree2.Menu;
import com.atguigu.atcrowdfunding.tree2.TreeUtil;
import com.google.common.collect.Lists;

/**
 * 递归打印
 */

public class Test4 {

	static {
	
	}

	public static void main(String[] args) throws InterruptedException {
		Node node1=new Node(1, "上海", 0);
		Node node2=new Node(2, "河南", 0);
		Node node3=new Node(3, "湖北", 0);
		
		Node node4=new Node(4, "浦东", node1.getId());
		Node node5=new Node(5, "徐汇", node1.getId());
		Node node6=new Node(6, "静安", node1.getId());
		
		Node node7=new Node(7, "周口", node2.getId());
		Node node8=new Node(8, "驻马店", node2.getId());
		Node node9=new Node(9, "洛阳", node2.getId());
//		Node node19=new Node(10, "南阳", node2.getId());
		
		Node node10=new Node(10, "武汉", node3.getId());
		Node node11=new Node(11, "鄂州",node3.getId());
		Node node12=new Node(12, "黄冈", node3.getId());
		
		Node node13=new Node(13, "蕲春", node10.getId());
		
		
		List<Node> allNode =Lists.newArrayList();
		allNode.add(node1);
		allNode.add(node2);
		allNode.add(node3);
		allNode.add(node4);
		allNode.add(node5);
		allNode.add(node6);
		allNode.add(node7);
		allNode.add(node8);
		allNode.add(node9);
//		allNode.add(node19);
		allNode.add(node10);
		allNode.add(node11);
		allNode.add(node12);
		allNode.add(node13);
		System.out.println(JSON.toJSONString(allNode));
		
		doubleFor(allNode);
		
		//1.根据id拿到节点，和父亲id
		
		//2.根据父亲id，拿到节点，把该节点作为（1）的儿子
		
	}

	/**
	 * 双层for循环
	 */
	private static void doubleFor(List<Node> allNode) {
		//生成树
		ArrayList<Node> nodes =Lists.newArrayList();
		for (Node node:allNode) {
			Node child=node;
			if(node.getPid()==0) {
				nodes.add(node);
			}else {
				for(Node innode:allNode) {
					if(child.getPid()==innode.getId()) {
						Node parent=innode;
						parent.getChildList().add(child);
						break;
					}
				}
			}
		}
		System.out.println(JSON.toJSONString(nodes));
	}
}

class Node{
	
	private int id;
	private String name;
	private int pid;
	private List<Node> childList=new ArrayList<Node>();
	
	public Node(int id, String name, int pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public List<Node> getChildList() {
		return childList;
	}
	public void setChildList(List<Node> childList) {
		this.childList = childList;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + ", pid=" + pid + ", childList=" + childList + "]";
	}
	
	
	
}
