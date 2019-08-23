package com.atguigu.atcrowdfunding.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.atcrowdfunding.domain.User;

/**
 * 这里需要注意,我们和shiro框架的交互完全通过Subject这个类去交互,用它完成登录,注销,获取当前的用户对象等操作
 * 
 * @RequiresAuthenthentication:表示当前Subject已经通过login进行身份验证;即 Subjec.isAuthenticated()返回
 *                                                          true
 * 
 * @RequiresUser:表示当前Subject已经身份验证或者通过记住我登录的,
 * 
 * @RequiresGuest:表示当前Subject没有身份验证或者通过记住我登录过，即是游客身份
 * 
 * @RequiresRoles(value = {"admin","user"},logical =
 *                      Logical.AND):表示当前Subject需要角色admin和user
 * 
 * @RequiresPermissions(value = {"user:delete","user:b"},logical =
 *                            Logical.OR):表示当前Subject需要权限user:delete或者user:b
 *
 */
@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		return "jsp/login";
	}

	@RequestMapping("/loginUser")
	public String loginUser(String username, String password, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(usernamePasswordToken); // 完成登录
			User user = (User) subject.getPrincipal();
			System.out.println("=======用户信息:" + user);
			session.setAttribute("user", user);
			return "jsp/index";
		} catch (Exception e) {
			return "jsp/login";// 返回登录页面
		}

	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
//        session.removeAttribute("user");
		return "jsp/login";
	}

	@RequestMapping("/home")
	public String home(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		return "jsp/home";
	}

	@RequestMapping("/404")
	public String page404(HttpSession session, HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr) throws ServletException, IOException {
		request.setAttribute("fenshu", 100);
		// 下面这种方式参数将会被附在url后面传递过去
	    attr.addAttribute( "name", "zhangsan");
	    // 下面这种方式在jsp页面中就获取不到了
	    attr.addFlashAttribute( "age", 22);
		return "jsp/404";
	}
	
	@RequestMapping("/405")
	public String page405(HttpSession session, HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr) {
		request.setAttribute("fenshu", 100);
		// 下面这种方式参数将会被附在url后面传递过去
	    attr.addAttribute( "name", "zhangsan");
	    // 下面这种方式在jsp页面中就获取不到了
	    attr.addFlashAttribute( "age", 22);
	    return "redirect:/redirect";
	}
	
	@RequestMapping("/redirect")
	public String redirect(HttpSession session, HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr) {
	    return "jsp/405";
	}

	@RequestMapping("/500")
	public String page500(HttpSession session, HttpServletRequest request, HttpServletResponse response,RedirectAttributes attr) {
		return "jsp/500";
	}

	/**
	 * ===SimpleAuthorizationInfo信息======={"roles":["customer"],"stringPermissions":["add","query"]}
	 */

	@RequiresRoles(value = { "admin" })
	@RequestMapping("/admin")
	public String admin(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		return "jsp/admin";
	}

	@RequestMapping("/guest")
	@RequiresPermissions(value = { "add", "b" }, logical = Logical.AND)
	public String guest(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		return "jsp/guest";
	}

	@RequestMapping("/guest1")
	@RequiresPermissions(value = { "add", "b" }, logical = Logical.OR)
	public String guest1(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		return "jsp/guest";
	}

	@RequestMapping("/guest2")
	@RequiresPermissions(value = { "add", "query" }, logical = Logical.AND)
	public String guest2(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		return "jsp/guest";
	}

	@RequestMapping("/guest3")
	@RequiresRoles(value = { "admin" })
	@RequiresPermissions(value = { "add", "query" }, logical = Logical.AND)
	public String guest3(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		return "jsp/guest";
	}

	@RequestMapping("/guest4")
	@RequiresRoles(value = { "customer" })
	@RequiresPermissions(value = { "add", "query" }, logical = Logical.AND)
	public String guest4(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		return "jsp/guest";
	}

}