<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.vo.AdminVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	pre {
		width: 45%;
		display: inline-block;
		padding: 10px;
		box-sizing: border-box;
		border: 2px solid #ccc;
	}
</style>
</head>
<body>
	<!--
		scope : 어느 범위에서 사용가능한가?
		scope은 기본이 "page" : 해당 페이지에서만 사용 가능(여기서만 가능)
		request를 하면 forward로 전달 가능. 다른 페이지에서 값 사용 가능
		
		*useBean이라는 Action Tag에서 사용하는 기술임 (EL아님..)
		Action Tag : jsp로 시작하는 tag(JSP가 기본적으로 제공하는 tag)
		- scope : page(default), request, session, application
	-->
	<jsp:useBean id="vo1" class="com.shinhan.vo.AdminVO" scope="request"></jsp:useBean>
	
	<h1>EL : Expression Language</h1>
	<!-- 
		EL이 내장하는 객체 scope: pageScope, requestScope, sessionScope, applicationScope
	 -->
	<jsp:setProperty property="email" name="vo1" value="smtown@atium.com" />
	
	<jsp:useBean id="alist" class="java.util.ArrayList"></jsp:useBean>
	
<%-- 	<jsp:forward page="forwardTest.jsp"></jsp:forward> --%>
	<h2>contextPath(어플리케이션에 저장되어 있음) : ${path}</h2>
	
	<pre>
		<p>pre태그 : 엔터가 그대로 노출됨.</p>
		1. 숫자, 연산자 : ${100+200}
		2. 문자 : ${"RingDingDong"}
		3. empty : ${empty "RinDingDong"} : 비어있는지 확인
		
		3. empty : ${empty ""} : true
		3. empty : ${empty vo1} : false
		3. empty : ${empty alist} : true
		3. empty : ${empty null} : true
		
		4. 비교 : ${100>200}
		5. 숫자 + 문자(숫자형만 가능) : ${"100"+10}
		6. eq : ${"hello" == "hello" }
		6. eq : ${"hello" eq "hello" } : "hello" eq "hello"
		7. 나머지 : ${100%3}
		7. 나머지 : ${100 mod 3} : 100 mod 3
		8. 논리연산자 : ${(100==100) && not(100 != 100)}		
		9. 내장객체 param : ${param.param1 }
		9. 내장객체 param : ${param.param2 }
		<%
			//9번을 자바코드로 하면 다음과 같음... 불편... EL로 쓰자.
			String p1 = request.getParameter("param1");
			String p2 = request.getParameter("param2");
		%>
		10. 자바코드 : <%=p1 %>
		11. application / session / request 영역에 저장
		<%
			//setAttribute(변수명, 값)
			application.setAttribute("score1","100");
			session.setAttribute("score2","200");
			request.setAttribute("score3","300");
			application.setAttribute("scopeTest","application");
			session.setAttribute("scopeTest","session");
			request.setAttribute("scopeTest","request");
		%>
		12. application / session / request 영역에서 읽기
		=====> (좁은영역) request > session > application (넓은영역)
		<!-- 영역을 따로 지정안해줘도...범위가 좁은 순서순으로 값을 찾아옴 -->
		${score1}
		${score2}
		${score3}

		=====> 동일한 이름일 경우 먼저 찾은 값 데려옴 : 좁은 영역에서부터 찾음
		${scopeTest}
		
		=====> 영역 지정해서 값 데려오기 ::: 영역.이름
		pageScope.scopeTest : ${pageScope.scopeTest}
		requestScope.scopeTest : ${requestScope.scopeTest}
		sessionScope.scopeTest : ${sessionScope.scopeTest}
		applicationScope.scopeTest : ${applicationScope.scopeTest}
	</pre>
	<pre>
		13. pageContext 이용해서 내장객체의 기능을 이용하기:
		- Expression 문법 : <%= request.getContextPath()%> : /webShop
		- EL문법 : ${pageContext.request.contextPath} : /webShop
		14. 객체의 속성 사용하기:
		<%
			AdminVO adminVO = new AdminVO("ltm@smtown.com", "ltm", "1234");
			request.setAttribute("admin", adminVO);
		%>
		<%=request.getAttribute("admin") %>
		${admin }
		${admin.email}	<%-- getEmail하지 않고, .eamil만 해도 get이 됨 --%>
		
		15. Collection Test
		<%
			//이 부분은 서블릿으로 처리한다. 
			List<AdminVO> adminList = new ArrayList<>();
			adminList.add(new AdminVO("cmh@smtown.com", "cmh", "1234"));
			adminList.add(new AdminVO("kjh@smtown.com", "kjh", "5678"));
			request.setAttribute("adminList", adminList);
			
			HashMap<String, Object> map1 = new HashMap<>();
			map1.put("바나나", 3);	
			map1.put("orange", 4);	
			map1.put("수박", 2);	
			map1.put("admins", adminList);	
			request.setAttribute("fruits", map1);
			 
		%>
		${adminList[0].email }
		${adminList[0].manager_name }
		${adminList[0].pass }
		
		${adminList[1].email }
		${adminList[1].manager_name }
		${adminList[1].pass }
		
		<hr>
		- map의 key값이 한글인 경우 ===> fruits["바나나"] 
		- map의 key값이 영문인 경우 ===> fruits.orange
		${fruits["바나나"] }
		${fruits.orange }
		${fruits["수박"] }
		
		${fruits.admins}
		${fruits.admins[0].email}
		
		html 내장 emtity : &lt;, &amp; &
		
	</pre>
</body>
</html>