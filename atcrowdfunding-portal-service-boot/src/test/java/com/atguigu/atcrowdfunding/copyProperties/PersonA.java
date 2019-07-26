package com.atguigu.atcrowdfunding.copyProperties;

public class PersonA {
	private Integer id;
	private String name;
	private Integer age;
	private String birth;
	private String address;
	private String cls;
	
	public PersonA(Integer id, String name, Integer age, String birth, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.address = address;
	}
	public PersonA() {
		// TODO Auto-generated constructor stub
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public Integer getId() {
		return id;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PersonA [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + ", address=" + address
				+ ", cls=" + cls + "]";
	}
	
}
