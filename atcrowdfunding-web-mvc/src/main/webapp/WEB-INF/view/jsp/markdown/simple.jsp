<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 头部和左边菜单 -->
<jsp:include page="/WEB-INF/view/jsp/common/init.jsp" />
<!-- 头部和左边菜单 -->

<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8" />
<title>Editor.md examples</title>
<link rel="stylesheet" href="${APP_PATH}/editor/css/style.css" />
<link rel="stylesheet" href="${APP_PATH}/editor/css/editormd.css" />
<link rel="shortcut icon"
	href="https://pandao.github.io/editor.md/favicon.ico"
	type="image/x-icon" />
<%-- <script src="${APP_PATH}/jquery.min.js"></script>  --%>
<script src="${APP_PATH}/editor/editormd.min.js"></script>
</head>
<body>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

		<div id="layout">
			<div id="test-editormd">
				<textarea style="display: none;" id="textContent" name="textContent"></textarea>
				<!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
				<textarea id="text" class="editormd-html-textarea" name="text"></textarea>
			</div>
		</div>
		<div>
			<button onclick="saveHtml()">保存</button>
		</div>
	</div>
	<script type="text/javascript">
		var testEditor;

		$(function() {
			testEditor = editormd("test-editormd", {
				width : "90%",
				height : 640,
				syncScrolling : "single",
				path : "${APP_PATH}/editor/lib/",
				imageUpload : true,
				imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
				imageUploadURL : "${APP_PATH}/file",
				//这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
				saveHTMLToTextarea : true
			// previewTheme : "dark"
			});
		});

		function saveHtml() {
			// console.log($("#text").text());
			console.log($("#textContent").text());
			$.ajax({
				url : "${APP_PATH}/editorWeb",
				type : "post",
				async : true,
				data : {
					"content" : $("#text").text(),
					"textContent" : $("#textContent").text()
				},
				dataType : "json",
				success : function(data) {
					alert(data.msg);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus); // paser error;
				}
			});
		}
	</script>
</body>
</html>