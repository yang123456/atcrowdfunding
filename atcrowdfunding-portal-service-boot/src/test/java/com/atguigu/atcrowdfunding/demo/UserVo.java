package com.atguigu.atcrowdfunding.demo;

public class UserVo {
	private Integer id;
	private double price;
	private String name;
	private String passWd;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", price=" + price + ", name=" + name + ", passWd=" + passWd + ", sex=" + sex + "]";
	}
	
	
 
}
