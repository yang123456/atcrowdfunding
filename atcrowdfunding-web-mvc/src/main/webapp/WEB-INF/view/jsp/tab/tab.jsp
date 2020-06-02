<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>tab切换</title>
<link rel="stylesheet" href="${APP_PATH}/tongxunlu/style.css">

<style type="text/css">
* {
	margin: 0;
	padding: 0
}

ul {
	list-style: none;
}

.tab {
	width: 300px;
	margin: 0 auto;
}

.tab .tab_menu {
	border: 1px solid #000000;
	height: 30px;
	width: 300px;
}

.tab .tab_menu ul li {
	float: left;
	width: 99px;
	text-align: center;
	line-height: 30px;
	border-right: 1px #333333 solid;
}

.tab .tab_menu ul li:last-child {
	border-right: none;
	width: 100px;
}

.tab .tab_menu ul li.on {
	background: #999;
}

.tab .tab_box>div {
	width: 300px;
	height: 200px;
	border: #333333 solid;
	border-width: 0 1px 1px 1px;
	display: none; //
	将三个内容框架全隐藏，通过下面的: first-child属性只将第一个框架内容显示出来
}

.tab .tab_box>div:first-child {
	display: block;
}
</style>

</head>
<body>
	<!--整体构局说明，用ul完成按钮的横向布局，用div完成三个内容框架的垂直布局（类似于类表），然后将三个内容框架全隐藏，通过下面的:first-child属性只将第一个框架内容显示出来-->
	<div class="tab">
		<div class="tab_menu">
			<ul>
				<li class="on">实事</li>
				<li>政治</li>
				<li>体育</li>
			</ul>
		</div>
		
		
		<div class="tab_box">
		
		
		
			<div>
				<div id="letter"></div>
				<div class="sort_box1">
					<c:forEach items="${users}" var="user">
						<div class="sort_list">
							<div class="num_logo">
								<img src="${APP_PATH}/img/img.png" alt="">
							</div>
							<div class="num_name">${user.username}</div>
						</div>
					</c:forEach>
				</div>
			</div>
			
			<div>政治内容</div>
			
			<div>
				<div id="letter"></div>
				<div class="sort_box3">
					<c:forEach items="${users}" var="user">
						<div class="sort_list">
							<div class="num_logo">
								<img src="${APP_PATH}/img/img.png" alt="">
							</div>
							<div class="num_name">${user.username}</div>
						</div>
					</c:forEach>
				</div>
			</div>
			
		</div>
		
		<div class="initials"> <!-- 右侧索引 -->
			<ul>
				<li><img src="${APP_PATH}/img/068.png"></li>
			</ul>
		</div>
		
	</div>




	<script type="text/javascript"
		src="${APP_PATH}/tongxunlu/jquery-1.8.3.min.js"></script>
	<script type="text/javascript"
		src="${APP_PATH}/tongxunlu/jquery.charfirst.pinyin.js"></script>
	<script type="text/javascript" src="${APP_PATH}/tongxunlu/sort.js"></script>
	<script type="text/javascript">
		$(function() {
			$(".tab_menu ul li").click(function() {
				$(this).addClass("on").siblings().removeClass("on"); //切换选中的按钮高亮状态
				var index = $(this).index(); //获取被按下按钮的索引值，需要注意index是从0开始的
				$(".tab_box > div").eq(index).show().siblings().hide(); //在按钮选中时在下面显示相应的内容，同时隐藏不需要的框架内容
			});
		});
	</script>
</body>
</html>