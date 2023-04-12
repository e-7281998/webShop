<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>첫번째 페이지...</h1>
	<p>화면 넘겨버리기 : jsp:forward</p>
	<%-- <jsp:forward page="b.jsp"></jsp:forward> --%>
	<p>나에게 포함시키기 : jsp:include</p>
	<jsp:include page="b.jsp"></jsp:include>
	
	<%
		RequestDispatcher rd = request.getRequestDispatcher("b.jsp");
		//rd.forward(request, response);
		rd.include(request,response);
	%>
</body>
</html>