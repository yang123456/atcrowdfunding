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
<title>iframe parent</title>


</head>

<body>


	<iframe id="ifr" src="http://localhost:8084/view/child"></iframe>

	<input type="button" onclick="send()" value="发送"> iframe parent

	<script>
		function send() {

			var f = document.getElementById("ifr");
			//给框架网页发送消息，然后收到之后，会传送过来。
			f.contentWindow.postMessage("谢霆锋", "*");
		}

		window.addEventListener('message', function(e) {
			console.log('bar say: ' + e.data);
		}, false);
	</script>

</body>
</html>