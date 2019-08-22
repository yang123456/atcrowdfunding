package com.atguigu.atcrowdfunding.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunding.domain.User;

/**
 * 这里需要注意,我们和shiro框架的交互完全通过Subject这个类去交互,用它完成登录,注销,获取当前的用户对象等操作
 * 
 * @RequiresAuthenthentication:表示当前Subject已经通过login进行身份验证;即 Subjec.isAuthenticated()返回 true
 
@RequiresUser:表示当前Subject已经身份验证或者通过记住我登录的,
 
@RequiresGuest:表示当前Subject没有身份验证或者通过记住我登录过，即是游客身份
 
@RequiresRoles(value = {"admin","user"},logical = Logical.AND):表示当前Subject需要角色admin和user
 
@RequiresPermissions(value = {"user:delete","user:b"},logical = Logical.OR):表示当前Subject需要权限user:delete或者user:b
 *
 */
@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		return "jsp/login";
	}

	@RequestMapping("/loginUser")
	public String loginUser(String username, String password, HttpSession session) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(usernamePasswordToken); // 完成登录
			User user = (User) subject.getPrincipal();
			System.out.println("=======用户信息:"+user);
			session.setAttribute("user", user);
			return "jsp/index";
		} catch (Exception e) {
			return "jsp/login";// 返回登录页面
		}

	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
//        session.removeAttribute("user");
		return "jsp/login";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		return "jsp/home";
	}
	
	@RequestMapping("/404")
	public String page404(HttpSession session) {
		return "jsp/404";
	}
	@RequestMapping("/500")
	public String page500(HttpSession session) {
		return "jsp/500";
	}
	
	@RequiresRoles(value = {"admin"})
	@RequestMapping("/admin")
	public String admin(HttpSession session) {
		return "jsp/admin";
	}
	@RequestMapping("/guest")
	@RequiresPermissions(value = {"customer:delete","user:b"},logical = Logical.AND)
	public String guest(HttpSession session) {
		return "jsp/guest";
	}
	
	
	
}