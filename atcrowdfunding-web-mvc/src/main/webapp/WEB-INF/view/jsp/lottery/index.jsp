<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="">
<meta name="format-detection" content="telephone=no">
<meta content="target-densitydpi=device-dpi,width=640,user-scalable=no" name="viewport">
<title>jQuery大转盘抽奖领红包代码 </title>

<link rel="stylesheet" type="text/css" href="${APP_PATH}/script/lottery/css/base.css">
<link rel="stylesheet" href="${APP_PATH}/script/lottery/css/style.css">

<script type="text/javascript" src="${APP_PATH}/script/lottery/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/script/lottery/js/jquery.rotate.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/script/lottery/js/jQuery.md5.js"></script>
<script> 
jQuery(document).ready(function($) {
	$('#musicbtn').click(function() {
		var music = document.getElementById("audio");
		if (music.paused) {
			music.play();
			$("#musicbtn").css("opacity", "1");
		} else {
			music.pause();
			$("#musicbtn").css("opacity", "0.4");
		}
	});
});
</script>
<script type="text/javascript">
	var moneyVal = 30;

	$(function(){
		var $plateBtn = $('#plateBtn');
		var $result = $('#result');
		var $resultTxt = $('#resultTxt');
		var $resultBtn = $('#resultBtn');

		$plateBtn.click(function(){
			var data = [0, 1, 2, 3, 4, 5];
			data = data[Math.floor(Math.random()*data.length)];
			switch(data){
				case 1:
					moneyVal = 200;
					rotateFunc(1,150,'恭喜你中了200 <em ><a href="javascript:void(0)" onclick="showPrize()">点击领取</a></em>');
					break;
				case 200000:
					moneyVal = -1;
					rotateFunc(2,180,'恭喜你中了iphone6s <em><a href="javascript:void(0)" onclick="showPrize()">点击领取</a></em>');
					break;
				case 3:
					moneyVal = 500;
					rotateFunc(3,60,'恭喜你中了500 <em><a href="javascript:void(0)" onclick="showPrize()">点击领取</a></em>');
					break;
				case 4:
					moneyVal = -1;
					rotateFunc(4,360,'<em>好运连连--加油！！看好你哦</em>');
					break;
				case 5:
					moneyVal = 100;
					rotateFunc(5,240,'恭喜你中了100 <em><a href="javascript:void(0)" onclick="showPrize()">点击领取</a></em>');
					break;

				default:
					rotateFunc(0,300,'恭喜你中了30 <em><a href="javascript:void(0)" onclick="showPrize()">点击领取</a></em>');
			}
		});

		var rotateFunc = function(awards,angle,text){  //awards:奖项，angle:奖项对应的角度
			$plateBtn.stopRotate();
			$plateBtn.rotate({
				angle: 0,
				duration: 5000,
				animateTo: angle + 1440,  //angle是图片上各奖项对应的角度，1440是让指针固定旋转4圈
				callback: function() {
					$resultTxt.html(text);
					//$result.show();
					if (moneyVal == -1) {
						showShare();
					}
					else {
						$('#title_h').text('恭喜你获得' + moneyVal + '元红包');
						showPrize();
					}
				}
			});
		};

		$resultBtn.click(function(){
			$result.hide();
		});
	});

	function closeRule(){
		var ruleDiv = document.getElementById('rule');
		ruleDiv.style.display = 'none';
		var ruleDiv = document.getElementById('mask_rule');
		ruleDiv.style.display = 'none';
	}
	function showRule(){
		var ruleDiv = document.getElementById('rule');
		ruleDiv.style.display = 'block';
		var ruleDiv = document.getElementById('mask_rule');
		ruleDiv.style.display = 'block';
	}
	function closeWin(){
		var winDiv = document.getElementById('win');
		winDiv.style.display = 'none';
		var winDiv = document.getElementById('mask_win');
		winDiv.style.display = 'none';
	}
	function showWin(){
		var winDiv = document.getElementById('win');
		winDiv.style.display = 'block';
		var winDiv = document.getElementById('mask_win');
		winDiv.style.display = 'block';

		$('#zhongjiangmingdan').html('');
		$.ajax({
			type:'get',
			url:'http://www.rongtoujinrong.com/api/record2.php',
//                    data:{},
			dataType:'json',
			success:function(data){
				if(data.code==1)
				{
					var arr = data.data;
					for(var i=0;i<arr.length;i++){
						$('#zhongjiangmingdan').append(arr[i]+'<br/>');
					}

				}
			},
			error:function(){}
		});

	}

	function closePrize(){
		var awardsDiv = document.getElementById('awards');
		awardsDiv.style.display = 'none';
		var awardsDiv = document.getElementById('mask_awards');
		awardsDiv.style.display = 'none';
	}
	function showPrize(){
		var awardsDiv = document.getElementById('awards');
		awardsDiv.style.display = 'block';
		var awardsDiv = document.getElementById('mask_awards');
		awardsDiv.style.display = 'block';
	}

	function closeShare(){
		var shareDiv = document.getElementById('share');
		shareDiv.style.display = 'none';
		var shareDiv = document.getElementById('mask_share');
		shareDiv.style.display = 'none';
	}
	function showShare(){
		var shareDiv = document.getElementById('share');
		shareDiv.style.display = 'block';
		var shareDiv = document.getElementById('mask_share');
		shareDiv.style.display = 'block';
	}

	function lingjiang()
	{
		//alert('lingjiang');
		if($('#tel').val()=='')
		{
			alert('请输入手机号码');
			return;
		}
		var telVal = $('#tel').val();
		var tokenVal = $.md5(telVal+"rongtou");
		if(moneyVal==0)
		{
			alert('领奖金额错误');
			return;
		}
		$.post("http://www.rongtoujinrong.com/api/choujiang.php", { "mobile": telVal, "token":tokenVal, "money":moneyVal},
				function(data){
					//alert(data);
					if(data.code==0)
					{
						alert(data.message);

					}
					else
					{
						alert('领取成功');
//                                window.location.reload();
					}
				}, "json");
	}

</script>

</head>
<body class="bgGray">

<div class="wrap">
	<div class="projIntro">
		<dl class="huodong1">
			<dd><a href="javascript:void(0)" onclick="showRule()"><img src="${APP_PATH}/script/lottery/images/projIntr_n01.png" alt=""><span>活动规则</span></a> </dd>
			<dd><a href="javascript:void(0)" onclick="showWin()"><img src="${APP_PATH}/script/lottery/images/projIntr_n02.png" alt=""><span>中奖名单</span></a></dd>
			<a href="#" id="musicbtn"></a>
			<audio id="audio" autoplay="autoplay"  loop="loop">
				<source src="mp3/xyy.mp3" type="audio/mpeg">
			</audio>
		</dl>
		<dl style="background:url(${APP_PATH}/script/lottery/images/beijing.png) no-repeat;">
			<div class="zhuanpan" style="width:640px; height:700px; margin:0 auto;">
				<div class="main">
					<div class="choujiang">
						<div class="plate">
							<a id="plateBtn" href="javascript:" title="开始抽奖">开始抽奖</a>
						</div>
						<div id="result">
							<p id="resultTxt"></p>
							<a id="resultBtn" href="javascript:" title="关闭">关闭</a>
						</div>
					</div>
					<div class="content">
						<div id="mask_rule" class="mask" style="display: none" onclick="closeRule()"></div>
						<div id="rule" style="display: none; margin-top:-510px;">
							<div>
								<h2>活动规则</h2>
								<p>
									<span>1.本活动时间为2016年1月22日至2月21日；</span><br/>
									<span>2.红包金额依次为30元、100元、200元、500元、iPhone6S；</span><br/>
									<span>3.参与者有1次红包转盘摇奖机会；</span><br/>
									<span>4.用户将活动分享后，好友点击时您的账户会自动增加100元红包（礼包）并获得微信通知；</span><br/>
									<span>5.活动奖励仅限单个用户使用，同一手机号或身份证均视为同一用户，重复无效；</span><br/>
									<span>6.为保证此次活动的公平公正，凡查出有作弊或其他任何不正当行为一律取消活动资格和奖励；</span><br/>
									<span>7. 如遇问题，请联系融头金融在线客服(www.rongtoujinrong.com)或拨打全国客服热线：400-808-8585。</span><br/>
									<span>红包使用</span><br/>
									<span>1.用户中奖后需输入手机号码领取红包并在关注融头金融公众号后使用</span><br/>
									<span>2.已获得红包可进入公众号中查看</span><br/>
									<span>3.每投资1000元可使用10元红包，以此类推。</span><br/>
									<span>本次活动解释权为融头金融所有</span><br/>
								</p>
							</div>
						</div>
						<div id="mask_win" class="mask" style="display: none" onclick="closeWin()"></div>
						<div id="win" style="display: none; margin-top:-510px;">
							<div>
								<h2>中奖名单</h2>
								<p id="zhongjiangmingdan">
									<span>138*******30 获得30元红包</span>  <span>2016年1月30日11:18</span><br/>
									<span>138*******30 获得30元红包</span>  <span>2016年1月30日11:18</span><br/>
									<span>138*******30 获得30元红包</span>  <span>2016年1月30日11:18</span><br/>
									<span>138*******30 获得30元红包</span>  <span>2016年1月30日11:18</span><br/>
									<span>138*******30 获得30元红包</span>  <span>2016年1月30日11:18</span><br/>
									<span>138*******30 获得30元红包</span>  <span>2016年1月30日11:18</span><br/>
									<span>138*******30 获得30元红包</span>  <span>2016年1月30日11:18</span><br/>
									<span>138*******30 获得30元红包</span>  <span>2016年1月30日11:18</span><br/>
								</p>
							</div>
						</div>
						<div id="mask_awards" class="mask" style="display: none" onclick="closePrize()"></div>
						<div id="awards"  style="display: none; margin-top:0;">
							<div>
								<h3 id="title_h">恭喜你获得30元红包</h3>
								<input id="tel" type="text" value="请输入您的手机号码领取" onclick="this.value='';focus()">
								<a class="a_prize" href="javascript:void(0);" onclick="lingjiang();">领奖</a>
								<a class="a_share" href="http://www.rongtoujinrong.com/member/promotion/" target="_blank">分享</a>
								<p>点击领取奖品后关注融头金融公众号进入公众号后您可以在平台活动—活动红包查看您获得的红包</p>
							</div>
						</div>
						<div id="mask_share" class="mask" style="display: none" onclick="closeShare()"></div>
						<div id="share" style="display: none">
							<div>
								<h3>分享好友获得额外一次抽奖机会和20元红包哦</h3>
								<a class="a_prize" href="">再次开抢</a>
								<a class="a_share" href="http://www.rongtoujinrong.com/member/promotion/" target="_blank">分享</a> </div>
						</div>
					</div>
				</div>
			</div>
		</dl>
		<dl>
			<div class="adv" style=" width:640px;margin:0 auto; text-align:center;"><img src="${APP_PATH}/script/lottery/images/adv.png"></div>
			<div class="dibu" style=" width:640px;margin:0 auto; text-align:center;"><img src="${APP_PATH}/script/lottery/images/qiche.jpg"></div>
		</dl>
		<div class="clear"></div>
	</div>
</div>

<!-- 心型特效 -->
<script>
		$(function(){
			$("body").click(function(e){
				// 创建div父元素
				var parentDiv = $("<div></div>");
				// 设置属性
				parentDiv.css({
					"width":"20px",
					"height":"20px",
					"position":"absolute",
					"z-index":"10000"
				});
				// 创建一个div容器元素
				var conDiv = $("<div></div>");
				conDiv.css({
					"width":"100%",
					"height":"100%",
					"position":"relative"
				});
				// 将容器元素添加到父元素中
				parentDiv.append(conDiv);
				// 创建子元素
				var childDiv = conDiv.append("<div></div><div></div><div></div>");
				var divs = conDiv.children();
				// 设置颜色随机
				var color = "rgb("+parseInt(Math.random()*250+5)
							+","+parseInt(Math.random()*250+5)
							+","+parseInt(Math.random()*250+5)+")";
				// 设置子元素属性
				$(divs[0]).css({
					"width":"60%",
					"height":"60%",
					"background-color":color,
					"border-radius":"100%"
				});
				$(divs[1]).css({
					"width":"60%",
					"height":"60%",
					"background-color":color,
					"border-radius":"100%",
					"position":"absolute",
					"top":"0",
					"right":"0"
				});
				$(divs[2]).css({
					"width":"60%",
					"height":"60%",
					"background-color":color,
					"position":"absolute",
					"top":"20%",
					"left":"20%",
					"transform":"rotate(45deg)",
					"-ms-transform":"rotate(45deg)",
					"-webkit-transform":"rotate(45deg)"
				});
				// 通过事件对象获取鼠标坐标
				var x = e.pageX;
				var y = e.pageY;
				// 修改div父元素位置
				parentDiv.css({"left":x+"px","top":y+"px"});
				// 添加到body中
				$("body").append(parentDiv);
				// 2秒后消失
				parentDiv.animate({
					"width":"25px",
					"height":"25px",
					"top":(y-200)+"px",
					"opacity":0
				},2000,function(){
					parentDiv.remove();
				});
			});
		});
	</script>



</body>
</html>