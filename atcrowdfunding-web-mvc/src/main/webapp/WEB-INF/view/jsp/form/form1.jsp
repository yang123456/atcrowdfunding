<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${APP_PATH}/jquery/jquery-3.2.1.min.js"></script>
<%-- <script src="${APP_PATH}/select2/select2.min.js"></script>
<link rel="stylesheet" href="${APP_PATH}/select2/select2.css"> --%>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>

<html>
<head>
<title>Title</title>
</head>
<body>
	<form method="post" action="${APP_PATH}/form/post">
		姓名:<input name="name"> <br> 年龄:<input name="age"><br>
		<input type="submit" value="提交">
	</form>

	<form method="get" action="${APP_PATH}/form/get">
		姓名:<input name="name"> <br> 年龄:<input name="age"><br>
		<input type="submit" value="提交">
	</form>

	<div style="width: 100%" class="form-control" id="id_select2_demo1"></div>

	<select class="form-control" style="width: 100%;" id="e11"
		multiple="multiple">
	</select>
	
	
	<select class="form-control" style="width: 100%;" id="id_select2_demo4"
		multiple="multiple">
		<option value="1">OPS-COFFEE-A</option>
		<option value="3">OPS-COFFEE-C</option>
		<option value="4">OPS-COFFEE-D</option>
		<option value="5">OPS-COFFEE-E</option>
	</select>
	<hr>

	<div>
		<label style="width: 100px; font-size: 14px;">单选</label> <select
			id="sel_menu" style="width: 400px;">
			<option value=""></option>
		</select>
	</div>
	<div style="margin-top: 20px;">
		<label style="width: 100px; font-size: 14px;">多选</label> <select
			id="sel_menu2" multiple="multiple" style="width: 400px;"></select>
	</div>
	<div style="margin-top: 20px;">
		<label style="width: 100px; font-size: 14px;">多选(含选中项)</label> <select
			id="sel_menu3" multiple="multiple" style="width: 400px;"></select>
	</div>
	<button onclick=getSelectedData() style="margin-top: 20px;">多选选中值</button>


	<script type="text/javascript">
		var sdata = [ {
			id : 1,
			text : 'OPS-COFFEE-1'
		}, {
			id : 2,
			text : 'OPS-COFFEE-2'
		}, {
			id : 3,
			text : 'OPS-COFFEE-3'
		} ]

		$('#id_select2_demo1').select2({
			placeholder : '请选择',
			minimumResultsForSearch : -1,
			data : sdata
		});

		$('#id_select2_demo4').select2({
			language : "zh-CN",
			placeholder : '请选择，最多选择三个',
			minimumResultsForSearch : -1,
			allowClear : true
		});

		//下拉框数据
		var initdata = [ "Java", "JavaScript", "C++", "C#", "Python", "PHP" ];
		//选中数据
		var selectedData = [ "Java", "PHP" ];

		//初始化页面加载
		$(document).ready(function() {

			//初始化e11
			inite11();
			
			//初始化select2单选
			initSelect2WithSearch();

			//初始化select2多选（没有选中项）
			initSelect2();

			//初始化select2多选（包含选中项）
			select2WithData(selectedData);

			// 改变事件
			$("#e11").on("change", function(e) {
				console.log("change")
			});
			// select2 打开事件
			$("#e11").on("select2:open", function(e) {
				console.log("open")
			});
			// select2 关闭事件   
			$("#e11").on("select2:close", function(e) {
				console.log("close")
			});
			// 选中事件
			$("#e11").on("select2:selecting", function(e) {
				console.log("selecting")
			});
			// 移除完毕事件。配置allowClear: true后触发
			$("#e11").on("select2:removed", function(e) {
				console.log("removed")
			});
			// 加载中事件
			$("#e11").on("select2:loaded", function(e) {
				console.log("loaded")
			});
			//  获得焦点事件
			$("#e11").on("select2:focus", function(e) {
				console.log("focus")
			});
			//  失去焦点事件    
			$("#e11").on("select2:blur", function(e) {
				console.log("blur")
			});

		});

		/**
		 * 初始化inite11
		 */
		function inite11() {
			$("#e11").select2({
				tags : true,
				maximumSelectionLength : 5,
				placeholder : '请添加或选择语言',
				multiple : true,
				maximumInputLength : 10,//允许长度  
				data : initdata,
				allowClear : true
			});
		}
		
		/**
		 * 初始化select2单选，默认带搜索功能。
		 */
		function initSelect2WithSearch() {
			$("#sel_menu").select2({
				tags : true,
				placeholder : '请搜索或选择语言',
				data : initdata,
				allowClear : true
			});
		}
		/**
		 * 初始化select2多选（没有选中项）
		 */
		function initSelect2() {
			$("#sel_menu2").select2({
				tags : true,
				maximumSelectionLength : 5,
				placeholder : '请添加或选择语言',
				multiple : true,
				maximumInputLength : 10,//允许长度  
				data : initdata,
			});
		}

		/**
		 * 初始化select2多选（包含选中项）
		 */
		function select2WithData(selectedData) {
			$("#sel_menu3").select2({
				tags : true, //支持新增，默认为false
				maximumSelectionLength : 6, //最多能够选择的个数
				multiple : true, //支持多选，默认为false
				data : initdata, //下拉框绑定的数据
				allowClear : true, //支持清空，默认为false
				placeholder : '请添加或选择语言' //提示语
			}).val(selectedData).trigger('change'); //多选情况下给选中项的赋值
		}

		/**
		 * 获取多选框选中项的值
		 */
		function getSelectedData() {
			var mulSelData = $("#sel_menu3").val().join(",");//获取多选输入框选中值的方式
			alert("sel_menu3的选中项是：" + mulSelData);
		}
	</script>


</body>
</html>