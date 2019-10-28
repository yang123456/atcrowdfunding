<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
<title>Title</title>
</head>
<body>
	<form method="post" action="${APP_PATH}/form/post">
		姓名:<input name="name"> <br> 
		年龄:<input name="age"><br> 
		<input type="submit" value="提交">
	</form>
	
	<form method="get" action="${APP_PATH}/form/get">
		姓名:<input name="name"> <br> 
		年龄:<input name="age"><br> 
		<input type="submit" value="提交">
	</form>
</body>
</html>