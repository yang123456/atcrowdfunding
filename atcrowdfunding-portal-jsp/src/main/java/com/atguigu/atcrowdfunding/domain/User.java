package com.atguigu.atcrowdfunding.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8637731266470284095L;
	private Integer uid;
	private String username;
	private String password;
	private Set<Role> roles = new HashSet<Role>();
}
