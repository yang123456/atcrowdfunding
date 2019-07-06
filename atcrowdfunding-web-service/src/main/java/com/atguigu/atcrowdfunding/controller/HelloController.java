package com.atguigu.atcrowdfunding.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.User;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	String home() {
		return "Hello ,spring boot!";
	}

	@RequestMapping("/showAllUser")
	public String showAllUser(HttpServletRequest request, Model model) {
		// volicaty放入集合
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("BB");
		list.add("CC");
		model.addAttribute("userList", list);
		// 放入单个数据
		model.addAttribute("user", "测试数据");
		return "showAllUser";
	}

	@RequestMapping("/direct")
	public String directive(HttpServletRequest request, Model model) {
		return "directive";
	}
}
