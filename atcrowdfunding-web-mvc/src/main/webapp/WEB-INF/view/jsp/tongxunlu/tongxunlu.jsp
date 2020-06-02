<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>jQuery首字母检索手机通讯录模板</title>
<link rel="stylesheet" href="${APP_PATH}/tongxunlu/style.css">
</head>
<body>
	<header class="fixed">
		<div class="header">通讯录</div>
	</header>
	<div id="letter"></div>
	<div class="sort_box">

		<c:forEach items="${users}" var="user">
			<div class="sort_list">
				<div class="num_logo">
					<a href="${APP_PATH}/img/img.png"><img src="${APP_PATH}/img/img.png" alt=""></a>
				</div>
				<div class="num_name">${user.username}</div>
			</div>
		</c:forEach>

	</div>

	<div class="initials">
		<ul>
			<li><img src="${APP_PATH}/img/068.png"></li>
		</ul>
	</div>



	<script type="text/javascript"
		src="${APP_PATH}/tongxunlu/jquery-1.8.3.min.js"></script>
	<script type="text/javascript"
		src="${APP_PATH}/tongxunlu/jquery.charfirst.pinyin.js"></script>
	<script type="text/javascript" src="${APP_PATH}/tongxunlu/sort.js"></script>
</body>
</html>