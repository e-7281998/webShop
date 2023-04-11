<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 오류 정보 </h1>
	<p><%=exception %>
	<!-- 출력 -->
	<p><%=exception.getMessage() %> 
	<!-- 실행 -->
	<p><%exception.printStackTrace(); %>
</body>
</html>