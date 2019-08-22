<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<h1>admin page</h1>

<shiro:guest>
    游客访问 <a href = "login.jsp"></a>
</shiro:guest>
 
 <br/>
 
<p>user 标签：用户已经通过认证\记住我 登录后显示响应的内容</p>
<shiro:user>
    欢迎[<shiro:principal/>]登录 <a href = "logout">退出</a>
</shiro:user>

<br/>

