<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<script src="http://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>
<h1>Home page</h1>



<div>
	<input type="button" value="replace1" onclick="replace1();" />
	 <input type="button" value="replace2" onclick="replace2();" />
	 <input type="button" value="replace3" onclick="replace3();" />
</div>




<script type="text/javascript">
	function replace1() {

		var stateObject = {};
		var title = "hello";
		var newurl = "/www/aaaa";
		//			history.pushState(stateObject,title,newurl)
		history.replaceState(stateObject, title, newurl)
	}
	function replace2() {
		window.location.replace("http://www.baidu.com");
	}
	function replace3() {
		$(location).attr('href', 'http://www.baidu.com');//跳转到新的地址
	}
	
	
  
	
</script>