package com.atguigu.atcrowdfunding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.atcrowdfunding.jpa.entity.User;
import com.atguigu.atcrowdfunding.service.UserService;

@RestController //声明为一个Restful的Controller
public class UserController {
    @Autowired //自动连接到UserService Bean
    private UserService userService;
    
    @Autowired
    com.atguigu.atcrowdfunding.jpa.service.UserService service;
    
    @Autowired
    com.atguigu.atcrowdfunding.page.service.UserService pageUserService;
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
    
    /**
             *  获取用户分页列表
           *    处理 "/users" 的 GET 请求，用来获取用户分页列表
           *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     *
     *    Pageable 支持的分页参数如下
     *    page - 当前页 从 0 开始
     *    size - 每页大小 默认值在 application.properties 配置
     */
    @RequestMapping(value = "page/getAll",method = RequestMethod.GET)
    public Page<User> getUserPage(Pageable pageable) {
        return pageUserService.findByPage(pageable);
    }

    /**
            *  创建用户
            *    处理 "/users" 的 POST 请求，用来获取用户列表
            *    通过 @RequestBody 绑定实体类参数
     */
    @RequestMapping(value = "page/create", method = RequestMethod.POST)
    public User postUser(@RequestBody User user) {
        return pageUserService.insertByUser(user);
    }

    
    
    
}