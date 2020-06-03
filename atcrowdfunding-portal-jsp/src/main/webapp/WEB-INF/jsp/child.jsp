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
<title>iframe child</title>


</head>

<body>
	iframe child  接受:<span id="recevie"></span>
	<script type="text/javascript">
		window.addEventListener('message', function(e) {
			console.log('foo say: ' + e.data);
			alert(e.data);
			document.getElementById("recevie").html=e.data;
			e.source.postMessage('get', '*');
		}, false)
	</script>

</body>
</html>