<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 头部和左边菜单 -->
<jsp:include page="/WEB-INF/view/jsp/common/init.jsp" />
<!-- 头部和左边菜单 -->

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>Editor.md examples</title>
    <link rel="stylesheet" href="${APP_PATH}/editor/css/editormd.preview.min.css" />
    <link rel="stylesheet" href="${APP_PATH}/editor/css/editormd.css"/>
</head>
<body>
<!-- 因为我们使用了dark主题，所以在容器div上加上dark的主题类，实现我们自定义的代码样式 -->
<div class="content editormd-preview-theme" id="content">${editor.content!''}</div>
<!-- <script src="${APP_PATH}/editor/jquery.min.js"></script> -->
<script src="${APP_PATH}/editor/lib/marked.min.js"></script>
<script src="${APP_PATH}/editor/lib/prettify.min.js"></script>
<script src="${APP_PATH}/editor/editormd.min.js"></script>
<script type="text/javascript">
    editormd.markdownToHTML("content");
</script>
</body>
</html>