package com.atguigu.atcrowdfunding.domain;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Module implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -967229335042850401L;
	private Integer mid;
	private String mname;
	private Set<Role> roles;
}
