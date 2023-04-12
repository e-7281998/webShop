<%-- <%@page import="com.shinhan.vo.AdminVO"%>
 --%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JavaBean이용하기</h1>
	<%
		//String a = request.getParameter("email");
		//String b = request.getParameter("manager_name");
		//String c = request.getParameter("pass");
		
		//AdminVO vo = new AdminVO(a,b,c);
	%>
	<!-- AdminVO vo = new AdminVO(a,b,c); 대신 사용... 객체 만들기 
		 useBean : 객체 생성 -->
	<jsp:useBean id="vo" class="com.shinhan.vo.AdminVO"></jsp:useBean>
	
	<!-- setProperty는 setter 수행 : 'set'+"Email"과 같은 함수를 만듬
	 	 property="email"은 vo의 email변수에 값을 넣겠다는 뜻 (VO에 선언된 변수명이랑 동일해야 함)
	 	 이때 param에서 찾은 email 값을 email변수에 넣겠다.
	 	 *만약 파라미터명과 vo에 선언된 변수명이 같으면 param을 굳이 사용하지 않아도 알아서 찾아 들어감.
 	 	 *<jsp:setProperty property="*" name="vo"/> 로 사용하면
 	 	  파라미터의 값들을 알아서 찾아서 property(vo의 변수)에 넣는다.
 	 -->

	<jsp:setProperty property="email" name="vo" param="email"/>
	<jsp:setProperty property="manager_name" name="vo" param="manager_name"/>
	<jsp:setProperty property="pass" name="vo" param="pass"/>
	
	<%= vo %> 
	<br> 
	<jsp:getProperty property="email" name="vo"/>
	<jsp:getProperty property="manager_name" name="vo"/>
	<jsp:getProperty property="pass" name="vo"/>
	<hr>
	<hr>
	
	<jsp:useBean id="vo2" class="com.shinhan.vo.AdminVO"></jsp:useBean>
	<jsp:setProperty property="*" name="vo2"/>
	<%= vo2 %> <%-- <%=은 out.print를 의미하고, 여기에는 toString이 숨어있음 : out.print(vo2.toString()) --%>
	
</body>
</html>