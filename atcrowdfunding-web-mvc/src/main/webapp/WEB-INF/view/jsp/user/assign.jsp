<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

     <!-- 头部和左边菜单 -->
		<jsp:include page="/WEB-INF/view/jsp/common/init.jsp" />
	<!-- 头部和左边菜单 -->
	
	
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ol class="breadcrumb">
				  <li><a href="#">首页</a></li>
				  <li><a href="#">数据列表</a></li>
				  <li class="active">分配角色</li>
				</ol>
			<div class="panel panel-default">
			  <div class="panel-body">
				<form id="roleForm" role="form" class="form-inline">
				  <input type="hidden" name="userid" value="${user.id}">
				  <div class="form-group">
					<label for="exampleInputPassword1">未分配角色列表</label><br>
					<select id="leftList" name="unassignroleids" class="form-control" multiple size="10" style="width:200px;overflow-y:auto;">
                        <c:forEach items="${unassignRoles}" var="role">
                        <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                    </select>
				  </div>
				  <div class="form-group">
                        <ul>
                            <li id="left2RightBtn" class="btn btn-default glyphicon glyphicon-chevron-right"></li>
                            <br>
                            <li id="right2LeftBtn" class="btn btn-default glyphicon glyphicon-chevron-left" style="margin-top:20px;"></li>
                        </ul>
				  </div>
				  <div class="form-group" style="margin-left:40px;">
					<label for="exampleInputPassword1">已分配角色列表</label><br>
					<select id="rightList" name="assignroleids" class="form-control" multiple size="10" style="width:200px;overflow-y:auto;">
                        <c:forEach items="${assingedRoles}" var="role">
                        <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                    </select>
				  </div>
				</form>
			  </div>
			</div>
        </div>
      </div>
    </div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			<h4 class="modal-title" id="myModalLabel">帮助</h4>
		  </div>
		  <div class="modal-body">
			<div class="bs-callout bs-callout-info">
				<h4>测试标题1</h4>
				<p>测试内容1，测试内容1，测试内容1，测试内容1，测试内容1，测试内容1</p>
			  </div>
			<div class="bs-callout bs-callout-info">
				<h4>测试标题2</h4>
				<p>测试内容2，测试内容2，测试内容2，测试内容2，测试内容2，测试内容2</p>
			  </div>
		  </div>
		  <!--
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="button" class="btn btn-primary">Save changes</button>
		  </div>
		  -->
		</div>
	  </div>
	</div>
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			    
			    $("#left2RightBtn").click(function(){
			    	var opts = $("#leftList :selected");
			    	if ( opts.length == 0 ) {
                        layer.msg("请选择需要分配的角色数据", {time:2000, icon:5, shift:6}, function(){
                        	
                        });
			    	} else {
			    		
			    		$.ajax({
			    			type : "POST",
			    			url  : "${APP_PATH}/user/doAssign",
			    			data : $("#roleForm").serialize(),
			    			success : function(result) {
			    				if ( result.success ) {
			    					$("#rightList").append(opts);
			                        layer.msg("分配角色数据成功", {time:2000, icon:6}, function(){
			                        });
			    				} else {
			                        layer.msg("分配角色数据失败", {time:2000, icon:5, shift:6}, function(){
			                        });
			    				}
			    			}
			    		});
			    	}
			    });
			    $("#right2LeftBtn").click(function(){
			    	var opts = $("#rightList :selected");
			    	if ( opts.length == 0 ) {
                        layer.msg("请选择需要取消分配的角色数据", {time:2000, icon:5, shift:6}, function(){
                        	
                        });
			    	} else {
			    		$.ajax({
			    			type : "POST",
			    			url  : "${APP_PATH}/user/dounAssign",
			    			data : $("#roleForm").serialize(),
			    			success : function(result) {
			    				if ( result.success ) {
			    					$("#leftList").append(opts);
			                        layer.msg("取消分配角色数据成功", {time:2000, icon:6}, function(){
			                        });
			    				} else {
			                        layer.msg("取消分配角色数据失败", {time:2000, icon:5, shift:6}, function(){
			                        });
			    				}
			    			}
			    		});
			    		
			    	}
			    });
            });
        </script>

