option explicit
on error resume next
dim interval,delayTime,WshShell,i
dim context,Time
interval = inputbox("请输入提醒的时间间隔(单位/分钟):","输入:",30)
if interval="" or IsNull(interval) then
 interval=30
end if
delayTime=interval*60000

set WshShell = WScript.CreateObject("WScript.Shell")
context = vbnewline &"你已连续工作"&interval&"分钟"& vbnewline & "休息一下,动动胳膊,伸伸腿..." & vbnewline & vbnewline
'提醒次数12
for i = 1 to 12
 WScript.Sleep(delayTime)
 Time=Hour(now)&":"&Minute(now)&":"&Second(now)
 if i<=2 then
  context ="现在时间:" &Time &" ,你已连续工作"&interval*i&"分钟." &vbnewline & vbnewline & "休息一下,动动胳膊,伸伸腿......" & vbnewline & vbnewline
  call PopupShowStr(context)
 elseif i<=5 and i>=3 then
  context ="现在时间:" &Time &" ,你已连续工作"&interval*i&"分钟." &vbnewline & vbnewline & "喝杯水,眼睛休息下咯......" & vbnewline & vbnewline
  call PopupShowStr(context)
 elseif i<=8 and i>=6 then
  context ="现在时间:" &Time &" ,你已连续工作"&interval*i&"分钟." &vbnewline & vbnewline & "是不是觉得肩膀酸痛,眼睛干涩？是,还不休息下......" & vbnewline & vbnewline
  call PopupShowStr(context)
 elseif i<=12 and i>=9 then
  context ="现在时间:" &Time &" ,你已连续工作"&interval*i&"分钟." &vbnewline & vbnewline & "哎,健康是自己的,你看着办吧......" & vbnewline & vbnewline
  call PopupShowStr(context)
 end if
next

'定义一个弹出框显示文本内容的函数
Function PopupShowStr(string)
 Dim WshShell
 Set WshShell = WScript.CreateObject("WScript.Shell")
 '将文本内容显示在弹出框中
 call WshShell.Popup(string,0,"定时提醒:")
End Function