<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{
		display: inline-block;
		width: 43%;
		margin: auto;
		padding: 10px;
	}
</style>
</head>
<body>
<div>

	<h1>JSTL 연습</h1>
	<p>myName : ${myName }</p>
	<hr>
	<p>myName (request) : ${requestScope.myName }</p>
	<p>myName (session) : ${sessionScope.myName }</p>
	<p>myName (application) : ${applicationScope.myName }</p>
	<hr>
	<ul>
		<!--
			int count=0
			request.setAttribute("coint",0)과 같음
		 -->
		<c:set var="count" value="0"></c:set>
 
		<!-- 
			for(AdminVO admin:adminList){}와 같음
		 -->
		<c:forEach items="${admins}" var="admin" varStatus="status">
			<c:set var="count" value="${count+1}"></c:set> 
			<li style="color:${status.first?'red':'blue'}">${status.first} : ${status.last}  <br> ${count} : forEach내장 ${status.index} : ${status.count} : ${admin}---${admin.manager_name }</li>
		</c:forEach>
	</ul>
	<hr>
	<h2>score 평가</h2>
	<c:if test="${score>= 90}">
		<p>합격입니다.</p>
		</c:if>
	<c:if test="${score< 90} ">
		<p>불합격입니다.</p>
	</c:if>
	<hr>
	
	<!-- 
		switch문과 같음
	 -->
	<c:choose>
		<c:when test="${score>= 90}">
			<p>A학점</p>
		</c:when>
		<c:when test="${score >= 80} ">
			<p>A학점</p>
		</c:when>
		<c:otherwise>
			<p>A학점</p>
		</c:otherwise>
	</c:choose>
	
	<hr>
	<c:out value="오늘은 <<목욜>>!"/>
	오늘은 <<목욜>>>~ 
</div>
<div>
	<h2>숫자, 날짜 format</h2>
	<c:set value="100000000" var="price"/>
	1. price : ${price}<br/>
	2. price : <fmt:formatNumber value="${price}" groupingUsed="true" type="currency"/>
	<br/>
	3. 오늘 : ${today}<br>
	<fmt:formatDate value="${today}" pattern="yyyy-MM-dd hh:mm:ss"/><br>
	<fmt:formatDate value="${today}" dateStyle="full" /><br>
	<fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="short"/>
	
	<h2>JSTL에서 문자열 함수 사용하기</h2>
	<p>myName : ${myName}</p>
	<p>myName : ${fn:substring(myName, 0, 3) }
	<p>myName : ${fn:length(myName) }
	</div>
</body>
</html>