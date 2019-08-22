<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

Index Page!



我是通过锚记链接测试是否生效的

<a href="http://localhost:8080/funding/test/index?aa">点我到a</a>
 <a href="http://localhost:8080/funding/test/index?bb">点我到b</a>

<div id="aa">aa</div>
 <div id="aa">bb</div>






<script>
 var timer=null; 
 var lasturl=window.location.href;
 function isHashChanged(){
    var cururl=window.location.href;
    //去掉定时器的方法  
   console.info("isHashChanged变化了");
    window.clearInterval(timer);   
    if(lasturl ==cururl ){
       return false;
   }
  return true;
 }
 function hashChangeFire(){
     console.info("hashChangeFire变化了");
 }
 //url变化监听器
if( ('onhashchange' in window) && ((typeof document.documentMode==='undefined') || document.documentMode==8)) {
     // 浏览器支持onhashchange事件
     alert("支持onhashchange");
    window.onhashchange = hashChangeFire;  // TODO，对应新的hash执行的操作函数
} else {
     // 不支持则用定时器检测的办法
  timer=setInterval(function() {
         // 检测hash值或其中某一段是否更改的函数， 在低版本的iE浏览器中通过window.location.hash取出的指和其它的浏览器不同，要注意
        var ischanged = isHashChanged();
        console.info("定时器");
         if(ischanged) {
             hashChangeFire();  // TODO，对应新的hash执行的操作函数
        }
     }, 150);
 }
 </script>