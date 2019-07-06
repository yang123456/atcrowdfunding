package com.atguigu.atcrowdfunding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.dubbo.CityDubboConsumerService;

@Controller
public class TestController {
	
	@Autowired
	CityDubboConsumerService cityService;
	
    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        return "Hello ,spring boot!";
    }
    
    @RequestMapping("/dubbo")
    @ResponseBody
    public String dubbo() {
    	cityService.printCity();
        return "Hello ,spring dubbo!";
    }
    
    @RequestMapping("/time/{name}")
    @ResponseBody
    public String time(@PathVariable("name") String name) {
        return "time "+name;
    }
    
}
