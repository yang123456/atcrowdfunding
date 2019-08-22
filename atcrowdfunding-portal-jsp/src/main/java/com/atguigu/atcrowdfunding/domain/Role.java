package com.atguigu.atcrowdfunding.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4191388277215209726L;
	private Integer rid;
	private String rname;
	private Set<User> uses = new HashSet<User>();
	private Set<Module> modules = new HashSet<Module>();
}
