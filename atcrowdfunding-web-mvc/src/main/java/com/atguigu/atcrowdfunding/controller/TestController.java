package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/queryAll")
	public Object queryAll() {
		List<User> users = userService.queryAll();
		return users;
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getPathInfo());
		System.out.println(request.getPathTranslated());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getScheme());
		System.out.println(request.getServletPath());
		System.out.println(request.getParameterMap());
		System.out.println(request.getParameter("aa"));
		System.out.println(request.getParameterValues("bb"));
		
		model.addAttribute("age", 22);
		
		return "index";
	}
	
	@RequestMapping("/tongxunlu")
	public String tongxunlu(HttpServletRequest request, Model model) {
		List<User> users = userService.queryAll();
		model.addAttribute("users", users);
		return "tongxunlu/tongxunlu";
	}
	
	@RequestMapping("/redirect")
	public String redirect(HttpServletRequest request, Model model) {
		model.addAttribute("name", "zhangsan");
		return "redirect:/test/index";
	}
	
	@RequestMapping("/tab")
	public String tab(HttpServletRequest request, Model model) {
		List<User> users = userService.queryAll();
		model.addAttribute("users", users);
		return "tab/tab";
	}
	
	@ResponseBody
	@RequestMapping("/json")
	public Object json() {
		Map map = new HashMap();
		map.put("username", "zhangsan");
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/test01")
	public Object test01(String keyword) {
		Map map = new HashMap();
		map.put("username", "zhangsan");
		return map;
	}
}
