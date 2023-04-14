<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul> 
		<!-- 5건의 데이터만 출력하기 -->
		<c:forEach begin="0" end="4" step="1" var="index">
			<li>${jobList[index].job_id}---${jobList[index].job_title }</li>
		</c:forEach>
	</ul>
	
</body>
</html>