<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 3초 후에 login.jsp로 가도록 설정(고정) -->
<!-- <meta http-equiv="refresh" content="3;auth/login.jsp"> -->
<title>Insert title here</title>
</head>
<body>
	<h1>JSP/Servlet Project~</h1>
	<!-- application, session, request 영역 연습 -->
	<p>application : ${mydata1}</p>
	<p>session : ${mydata2}</p>
	<p>request : ${mydata3}</p>
	<hr>
	<hr>
	<p>브라우저랑 가까운 곳</p>
	<p>(가까움)request > session > application (멈)=====>	${myname}
	<p>application : ${application.myname}</p>
	<p>session : ${session.myname}</p>
	<p>request : ${request.myname}</p>
	<hr>
	<p>getInitParameter : <%= application.getInitParameter("DB_userid") %></p>
	<ul>
		<!-- 이 파일이 현재 루트(webapp)에 있고, 가려는 곳도 루트에 있음 -->
		<li><a href="first">첫번째 서블릿 요청(Get)</a></li>
		<li>
			<form action="first" method="get">
				<input type="submit" value="get요청">
			</form>
		</li>
		<li>
			<form action="first" method="post">
				<input type="submit" value="post요청">
			</form>
		</li>
		<li>
			<form action="param" method="get">
				<input type="text" name="userid">
				<input type="number" name="salary">
				남자<input type="radio" name="gender" value="M">
				여자<input type="radio" name="gender" value="F">
				<hr>
				취미
				<br>
				게임<input type="checkbox" name="hobby" value="게임">
				독서<input type="checkbox" name="hobby" value="독서">
				축구<input type="checkbox" name="hobby" value="축구">
				농구<input type="checkbox" name="hobby" value="농구">
				<input type="submit" value="get요청">
				
			</form>
		</li>
	</ul>
	<a href="auth/loginCheck.do">로그인 하기 (상대경로)</a>
	<a href="<%=request.getContextPath() %>/auth/login.jsp">로그인 하기 (절대경로)</a>
	<h2>직원관리</h2>
	<a href="<%=request.getContextPath() %>/emp/emplist.do">직원조회</a>
	<a href="<%=request.getContextPath() %>/emp/empinsert.do">직원등록</a>
</body>
</html>