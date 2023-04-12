<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/commonFiles.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css" type="text/css">

</head>
<body>
	<h1>JSTL 연습</h1>
	<c:set var="score" value="${param.jumsu}"></c:set>
	
	<c:set var="happy" value="1" scope="page"/>
	<c:set var="happy2" value="2" scope="request"/>
	<c:set var="happy3" value="3" scope="session"/>
	<c:set var="happy4" value="4" scope="application"/>
	
	<hr>
	<h1>점수는 ${score }</h1>
	<p>
		page : ${happy}<br/>
		request : ${happy2}<br/>
		session : ${happy3}<br/>
		application : ${happy4}
	</p>
	
	<%@ include file="../common/Header.jsp" %>
	
	<c:forEach begin="1" end="10" step="1" var="su">
		<span>${su} </span>
	</c:forEach>
	
	<hr>
	<h2>contextPath(어플리케이션에 저장되어 있음) : ${path}</h2>
</body>
</html>