<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<style>
.jqx-notification-container .jqx-notification{
	
}
</style>	
	
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





<script type="text/javascript">
JQXElements.settings['timerNotification'] = {
    position: 'top-right',
    width: 300,
    autoOpen: true,
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
