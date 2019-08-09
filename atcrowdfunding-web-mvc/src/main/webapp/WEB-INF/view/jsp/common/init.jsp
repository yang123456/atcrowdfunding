<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/main.css">
<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/main.css">
<link rel="stylesheet" href="${APP_PATH}/ztree/zTreeStyle.css">


<!-- bootstrap 4.x is supported. You can also use the bootstrap css 3.3.x versions -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<link href="${APP_PATH}/bootstrap-fileinput/5.0.5/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
<!-- if using RTL (Right-To-Left) orientation, load the RTL CSS file after fileinput.css by uncommenting below -->
<!-- link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.0.5/css/fileinput-rtl.min.css" media="all" rel="stylesheet" type="text/css" /-->
<script src="${APP_PATH}/jquery/jquery-3.2.1.min.js"></script>
<!-- piexif.min.js is needed for auto orienting image files OR when restoring exif data in resized images and when you 
    wish to resize images before upload. This must be loaded before fileinput.min.js -->
<script src="${APP_PATH}/bootstrap-fileinput/5.0.5/js/plugins/piexif.min.js" type="text/javascript"></script>
<!-- sortable.min.js is only needed if you wish to sort / rearrange files in initial preview. 
    This must be loaded before fileinput.min.js -->
<script src="${APP_PATH}/bootstrap-fileinput/5.0.5/js/plugins/sortable.min.js" type="text/javascript"></script>
<!-- purify.min.js is only needed if you wish to purify HTML content in your preview for 
    HTML files. This must be loaded before fileinput.min.js -->
<script src="${APP_PATH}/bootstrap-fileinput/5.0.5/js/plugins/purify.min.js" type="text/javascript"></script>
<!-- popper.min.js below is needed if you use bootstrap 4.x. You can also use the bootstrap js 
   3.3.x versions without popper.min.js. -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> -->
<!-- bootstrap.min.js below is needed if you wish to zoom and preview file content in a detail modal
    dialog. bootstrap 4.x is supported. You can also use the bootstrap js 3.3.x versions. -->
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<!-- the main fileinput plugin file -->
<script src="${APP_PATH}/bootstrap-fileinput/5.0.5/js/fileinput.min.js"></script>
<!-- optionally if you need a theme like font awesome theme you can include it as mentioned below -->
<script src="${APP_PATH}/bootstrap-fileinput/5.0.5/themes/fa/theme.js"></script>
<!-- optionally if you need translation for your language then include  locale file as mentioned below -->
<script src="${APP_PATH}/bootstrap-fileinput/5.0.5/js/locales/LANG.js"></script>


<!-- notification -->
<link rel="stylesheet" href="${APP_PATH}/jqwidgets/styles/jqx.base.css" type="text/css" />
<link rel="stylesheet" href="${APP_PATH}/styles/demos.css" type="text/css" />
<%-- <script type="text/javascript" src="${APP_PATH}/scripts/jquery-1.11.1.min.js"></script> --%>
<script type="text/javascript" src="${APP_PATH}/jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="${APP_PATH}/jqwidgets/jqxnotification.js"></script>
<script type="text/javascript" src="${APP_PATH}/jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript" src="${APP_PATH}/scripts/webcomponents-lite.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="${APP_PATH}/jqwidgets/jqxcore.elements.js"></script>
<script type="text/javascript" src="${APP_PATH}/jqwidgets/jqxnotification.js"></script>
<script type="text/javascript" src="${APP_PATH}/jqwidgets/jqxinput.js"></script>
<script type="text/javascript" src="${APP_PATH}/jqwidgets/jqxbuttons.js"></script>
 <script type="text/javascript" src="${APP_PATH}/scripts/demos.js"></script>

<style>
.tree li {
	list-style-type: none;
	cursor: pointer;
}

table tbody tr:nth-child(odd) {
	background: #F4F4F4;
}

table tbody td:nth-child(even) {
	color: #C00;
}
</style>
</head>

<body>

	<!-- 头部 -->
	<%@include file="/WEB-INF/view/jsp/common/header.jsp"%>
	

	<!-- 左边菜单 -->
	<%@include file="/WEB-INF/view/jsp/common/leftMenu.jsp"%>
	
	
	
	<%@include file="/WEB-INF/view/jsp/template/notification.jsp"%>  
	
	



</body>
</html>
