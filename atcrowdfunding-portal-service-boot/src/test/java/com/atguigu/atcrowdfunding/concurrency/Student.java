package com.atguigu.atcrowdfunding.concurrency;
public class Student {
 
	private String name;
	private String sex;
	private Integer age;
	private String remark;
	
	public Student(String name,String sex,Integer age,String remark) {
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.remark=remark;
	}
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}