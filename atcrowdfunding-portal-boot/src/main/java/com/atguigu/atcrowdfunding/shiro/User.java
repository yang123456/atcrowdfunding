package com.atguigu.atcrowdfunding.shiro;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
@Data
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8637731266470284095L;
	private Integer id;
	private String username;
	private String password;
	private Set<Role> roles = new HashSet<Role>();
}
