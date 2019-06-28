package com.atguigu.atcrowdfunding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.atcrowdfunding.jpa.entity.User;
import com.atguigu.atcrowdfunding.service.UserService;

@RestController //声明为一个Restful的Controller
public class UserController {
    @Autowired //自动连接到UserService Bean
    private UserService userService;
    
    @Autowired
    com.atguigu.atcrowdfunding.jpa.service.UserService service;
    /**
     * jpa
     * @param id
     * @return
     */
    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        
        return service.getUser(id);
    }
    
    @RequestMapping(value = "/show")
    public String show() {
        return userService.show();
    }

    @RequestMapping(value = "/showDao")
    public Object showDao(int age) {
        return userService.showDao(age);
    }

    @RequestMapping(value="/insert")
    public String insert(String name, int age) {
        return userService.insert(name, age);
    }
}