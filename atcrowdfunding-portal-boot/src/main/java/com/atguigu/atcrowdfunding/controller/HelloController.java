package com.atguigu.atcrowdfunding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.dubbo.CityDubboConsumerService;

@Controller
@RequestMapping("/test")
public class HelloController {
	
	@Autowired
	CityDubboConsumerService cityService;
	
    @RequestMapping("/{name}")
    @ResponseBody
    public String hello(@PathVariable("name")String name) {
        return "Hello "+name;
    }
    
  
    
}
