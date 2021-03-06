<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>下载文件显示页面</title>
</head>

<body>
	<!-- 遍历Map集合 -->
	<c:forEach var="me" items="${fileNameMap}">
		<c:url value="/advertisement/downFile" var="downurl">
			<c:param name="filename" value="${me.key}"></c:param>
		</c:url>  
        ${me.value}<a href="${downurl}">下载</a>
		<br />
	</c:forEach>
<c:choose>
       <c:when test="${not empty fileList }">
       <!--索引-->
       <c:set var="index" value='1'></c:set>
       <c:forEach items="${fileList }" var="file">
           <!-- filename:文件的名字，不带UUID -->
           <c:set var="filename" value='${fn:substring(file.name,fn:indexOf(file.name,"_")+1,fn:length(file.name)) }'/>
           <!-- filefullname:文件的名字，带UUID -->
           <c:set var="filefullname" value='${fn:split(file.path,"\\\\")[fn:length(fn:split(file.path,"\\\\"))-1] }'></c:set>
           <!-- rootdir:文件的目录 -->
           <c:set var="rootdir" value='${pageContext.request.contextPath}/upload/'></c:set>
           <div onclick="return check()">
               <img alt='${filename }' src='${rootdir.concat(filefullname) }'><!-- 文件的全路径 -->
               <a href="${pageContext.request.contextPath}/teacher/fileDownload?path=${file.path}">下载</a>
           </div>
           <!-- 每行显示5张图片 -->
           <c:if test="${index%5==0 }">
               <br>
           </c:if>
           <!--索引+1-->
           <c:set var="index" value='${index+1 }'></c:set>
        </c:forEach>
    </c:when>
    <c:otherwise>
        暂无数据
    </c:otherwise>
</c:choose>

</body>
</html>
