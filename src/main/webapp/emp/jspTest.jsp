<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%!
 // 선언문 : 멤버 변수, 멤버 메서드... class의 독립적으로 만들어진다.
 String myName = "공유변수";
 public int sum(int a, int b){
	 return a+b;
 }
 %>
 <%
 	//자바... _jspService() 메서드 안으로 들어간다.
 	int age=20;
 
 %>
 <%-- JSP 주석이다. ?질문: JSP -> .java로 바뀌면 주석이 있을까? --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 -->
	<h1>JSP의 ScriptLet 연습</h1>
	<p>멤버 변수 호출 : <%=myName %></p>
	<p>service 내의 변수 호출 : <%=age %></p>
	<p>멤버 메서드를 호출: <%=sum(10,20) %></p>
	<%
		for(int i=1; i<=10; i++){%>
			<span><%= i %></span>
		<%}
	%>
	<hr>
	<%
	for(int i=1; i<=10; i++){
		out.print("<span>"+i+" </span>");
	}
	%>
	
</body>
</html>