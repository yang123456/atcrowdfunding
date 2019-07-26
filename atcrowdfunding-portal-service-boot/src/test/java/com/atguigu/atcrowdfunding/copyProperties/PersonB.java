package com.atguigu.atcrowdfunding.copyProperties;

public class PersonB {
	private Integer id;
	private String name;
	private String address1;
	private String lsc;
	
	public PersonB(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address1 = address;
	}
	public PersonB() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PersonB [id=" + id + ", name=" + name + ", address=" + address1 + ", lsc=" + lsc + "]";
	}
	public String getLsc() {
		return lsc;
	}
	public void setLsc(String lsc) {
		this.lsc = lsc;
	}
	
}
