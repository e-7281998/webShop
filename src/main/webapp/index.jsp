<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP/Servlet Project~</h1>
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
</body>
</html>