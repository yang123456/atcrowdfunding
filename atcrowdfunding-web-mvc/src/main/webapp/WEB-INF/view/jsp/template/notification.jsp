<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

	
		<!-- 通知  notification -->
<jqx-notification settings="timerNotification">
	<div>
		紧急,你只剩余 <span class="timer">30</span> 分钟左右!
	</div>
</jqx-notification>

<jqx-notification settings="timeOutNotification">
	<div>时间过期了！</div>
</jqx-notification>

<jqx-notification settings="correctNotification">
	<div>你的答案正确！</div>
</jqx-notification>

<jqx-notification settings="wrongNotification">
	<div>你的答案错误！</div>
</jqx-notification>

<jqx-notification settings="errorTimeOutNotification">
	<div>时间过期了！</div>
</jqx-notification>
<!-- 通知  notification -->



<!-- position:"top-right",zIndex:99999,browserBoundsOffset:5,notificationOffset:5,opacity:0.9,
hoverOpacity:1,autoOpen:false,animationOpenDelay:400,animationCloseDelay:800 -->

<script type="text/javascript">
JQXElements.settings['timerNotification'] = {
    position: 'top-right',
    width: 400,
    autoOpen: true,
    browserBoundsOffset:60,
    //notificationOffset:200,
    closeOnClick: false,
    autoClose: false,
    showCloseButton: false,
    template: 'time'
};

JQXElements.settings['timeOutNotification'] = {
    position: 'top-right',
    width: 300,
    autoOpen: false,
    closeOnClick: true,
    autoClose: false,
    template: 'time'
};

JQXElements.settings['correctNotification'] = {
    position: 'top-right',
    width: 300,
    autoOpen: false,
    closeOnClick: true,
    autoClose: true,
    template: 'success'
};

JQXElements.settings['wrongNotification'] = {
    position: 'top-right',
    width: 300,
    autoOpen: false,
    closeOnClick: true,
    autoClose: true,
    template: 'error'
};

JQXElements.settings['errorTimeOutNotification'] = {
    position: 'top-right',
    width: 300,
    autoOpen: false,
    closeOnClick: true,
    autoClose: true,
    template: 'error'
};
</script>
