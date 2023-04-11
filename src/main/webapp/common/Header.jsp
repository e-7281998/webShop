<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <div>
	<span>로그인한 사용자 : ${loginUser.manager_name}</span>
	<img src="../images/kkoong2.jpg" width="30px" height="30px">
	<!-- sessionScope. 세션에서 읽어라 -->
	<p>
		<span>세션에서 로그인 사용자 읽기(EL) : ${sessionScope.loginUser}</span>
		<br/>
		<span>세션에서 로그인 사용자 읽기(ScripitLet) : <%=session.getAttribute("loginUser") %></span>
	</p>
	
    	<input type="button" value="로그아웃" id="btnLogout">
</div> 
		
<button id="btnLogin">로그아웃</button>
		
