<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

  <!-- 头部和左边菜单 -->
		<jsp:include page="/WEB-INF/view/jsp/common/init.jsp" />
	<!-- 头部和左边菜单 -->

    
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
			      <button class="btn btn-success" onclick="doAssign()">分配许可</button>
                  <ul id="permissionTree" class="ztree"></ul>
			  </div>
			</div>
        </div>
      </div>
    </div>

    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
	<script src="${APP_PATH}/ztree/jquery.ztree.all-3.5.min.js"></script>
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
			    
			    var setting = {
		    		check : {
		    		    enable : true 
		    		},
		    		async: {
		    			enable: true,
		    			url:"${APP_PATH}/permission/loadAssignData?roleid=${param.id}",
		    			autoParam:["id", "name=n", "level=lv"]
		    		},
					view: {
						selectedMulti: false,
						addDiyDom: function(treeId, treeNode){
							var icoObj = $("#" + treeNode.tId + "_ico"); // tId = permissionTree_1, $("#permissionTree_1_ico")
							if ( treeNode.icon ) {
								icoObj.removeClass("button ico_docu ico_open").addClass(treeNode.icon).css("background","");
							}
                            
						}
					}
			    };
			   
			    $.fn.zTree.init($("#permissionTree"), setting);
            });
            function doAssign() {
            	var treeObj = $.fn.zTree.getZTreeObj("permissionTree");
            	var nodes = treeObj.getCheckedNodes(true);
            	if ( nodes.length == 0 ) {
                    layer.msg("请选择需要分配的许可信息", {time:2000, icon:5, shift:6}, function(){
                    	
                    });
            	} else {
            		var d = "roleid=${param.id}";
            		$.each(nodes, function(i, node){
            			d += "&permissionids="+node.id
            		});
            		$.ajax({
            			type : "POST",
            			url  : "${APP_PATH}/role/doAssign",
            			data : d,
            			success : function (result) {
            				if ( result ) {
                                layer.msg("分配许可信息成功", {time:2000, icon:6}, function(){
                                	
                                });
            				} else {
                                layer.msg("分配许可信息失败", {time:2000, icon:5, shift:6}, function(){
                                	
                                });
            				}
            			}
            		});
            	}
            }
        </script>


