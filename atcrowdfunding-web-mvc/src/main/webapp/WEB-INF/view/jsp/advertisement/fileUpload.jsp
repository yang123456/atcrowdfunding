<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


     <!-- 头部和左边菜单 -->
		<jsp:include page="/WEB-INF/view/jsp/common/init.jsp" />
	<!-- 头部和左边菜单 -->

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"  role="form">
			<div class="panel panel-default">
			    <div class="panel-heading">
				   <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			    </div>
			    <div class="panel-body">
					<form action="advertisement/onefile" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
						    <label for="name">标题</label>
						    <input type="text" class="form-control" id="name" placeholder="请输入标题">
						    <label for="url">跳转的url</label>
						    <input type="text" class="form-control" id="url" placeholder="请输入地址">
						 </div>
					 	<div class="form-group">
						 	 <label for="name">广告封面</label>
				            <div class="file-loading"><input id="uploadImg" type="file"></div>
				            <br>
				  			<textarea id="description" rows=3" class="form-control" placeholder="给上传的文件填写一段描述..."></textarea>
			  			</div>
			  			<label for="name">前台展示: </label>
			  			<label class="radio-inline">
        					<input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1" checked> 展示
    					</label>
					    <label class="radio-inline">
					        <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="option2"> 隐藏
					    </label> 
					    
					    <div>
					        <span>20 - 3 × 4 =</span>
					        <jqx-input></jqx-input>
					    </div>
					    <jqx-button id="submitAnswer">提交答案</jqx-button>
					    
					    

					    
					</form>
				</div> 

		  </div>
	</div>





<script type="text/javascript">
$("#uploadImg").fileinput({
    theme: 'fas',
    uploadUrl: '#'
}).on('filepreupload', function(event, data, previewId, index) {
    alert('The description entered is:\n\n' + ($('#description').val() || ' NULL'));
});


window.onload = function() {
    var myNotifications = document.querySelectorAll('jqx-notification');
    var myButton = document.querySelector('jqx-button');
    var myInput = document.querySelector('jqx-input');

    myNotifications[0].addEventListener('close', function() {
        if (myInput.val() != 8) {
            myNotifications[1].open();
        }
    });

    myButton.addEventListener('click', function() {
        if (seconds > 1) {
            if (myInput.val() == 8) {
                myNotifications[2].open();
                clearInterval(interval);
                myNotifications[0].closeLast();
            } else {
                myNotifications[3].open();
            }
        } else {
            myNotifications[4].open();
        }
    });

    var seconds = 30;
    var interval = setInterval( function() {
        if (seconds > 1) {
            seconds--;
            document.querySelectorAll('.timer')[1].innerHTML = seconds;
    
        } else {
            clearInterval(interval);
            myNotifications[0].closeLast();
        }
    }, 1000);
};


</script>


