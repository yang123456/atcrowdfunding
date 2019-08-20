package com.atguigu.atcrowdfunding.controller;

import org.apache.http.annotation.Contract;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("view")
public class ViewResolverController {
	@RequestMapping("/")
	public String index() {
		return "jsp/index";
	}

	@RequestMapping("/jspindex")
	public String jspindex() {
		return "jsp/jspindex";
	}

	@RequestMapping(value = { "/thymeleafindex.htm" })
	public String index(Model model) {
		return "thymeleafindex";
	}

	@GetMapping("/testVue")
	public String testVue(Model model) {
		model.addAttribute("message", "this is index jsp page");
		return "vue/testVue";
	}
}
