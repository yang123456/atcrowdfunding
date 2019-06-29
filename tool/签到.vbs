Option Explicit
dim context,Time
Dim sysTime,sysHour,sysMinute,sysSecond,userTime,userHour,userMinute,userSecond

Dim WshShell,objExplorer

userTime="18:00:00"
'这里设置时间(时:分:秒).特别提醒:分钟和秒钟如果只有个位的话,那就一定要在十位上补零.如8点5分3秒就写成(8:05:03),记住哟~
userTime=Split(userTime,":")
userHour=userTime(0)
userMinute=userTime(1)
userSecond=userTime(2)


context = "别忘了" & chr(10) & "(1:银联:签到,签退,记日志)" & chr(10) & "(2:新致:日报,周报)"


Do While True
	sysTime=Split(Split(Now()," ")(1),":")
	sysHour=sysTime(0)
	sysMinute=sysTime(1)
	sysSecond=sysTime(2)
	'小时相同  分钟小于系统时间
	If sysHour=userHour And sysMinute>userMinute Then
		PopupShowStr(context)
		OpenExplorer(context)
	End If
	
Loop



'定义一个弹出框显示文本内容的函数
Function PopupShowStr(string)
 Set WshShell = WScript.CreateObject("WScript.Shell")
 '将文本内容显示在弹出框中
 call WshShell.Popup(string,0,"定时提醒标题.........(银联:签到,签退,记日志).........(新致:日报，周报)................:")
End Function

'定义一个弹出框显示文本内容的函数
Function OpenExplorer(string)
	Set WshShell=WScript.CreateObject("WScript.Shell")
	Set objExplorer = CreateObject("InternetExplorer.Application")'建立IE对象
	objExplorer.Navigate "https://www.baidu.com/"'设置IE对象默认指向的页面
	objExplorer.Visible = 1'设置IE对象是否可视
End Function