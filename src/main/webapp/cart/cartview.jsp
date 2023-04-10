<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container{
		
			text-align: center;
		}
	h1{
		color: darkblue;
		padding-bottom: 30px;
		border-bottom: 2px solid darkblue;
		display: inline-block;
	}
	input[type="button"], input[type="submit"]{
		background-color: lightgreen;
		font-size: 17px;
		padding: 5px 10px;
		font-weight: blod;
		border-radius: 8px;
		border-color: transparent; 
		transition: all 0.3s ease-in-out;
	}
	input[type="button"]:hover, input[type="submit"]:hover{
		background-color: green;
		color: white;
		cursor: pointer;
	}
	p{
		font-size: 20px;
	}
</style>
</head>
<body>
<div id="container">
	<h1> 장바구니 </h1>
	<h2>${loginUser.manager_name } 님의 장바구니 현황입니다.</h2>
	 <%
			//session은 내장으로 있음.
		 Object obj = session.getAttribute("cart");
		  
		 if(obj != null) {
			 HashMap<String, Integer>cart = (HashMap<String, Integer>)obj;
			 for(String key : cart.keySet()) {
				out.println("<p>🔸" + key + " - " + cart.get(key) +"개 </p>");
			 }
		 }else
			out.println("<p>-</p>");

	%>
	<input type="button" value="계속 쇼핑하기" onclick="location.href='addCart.do';">
	
	
	<%-- <%
			 Object obj = session.getAttribute("cart");
			  
			 if(obj != null) {
				 HashMap<String, Integer>cart = (HashMap<String, Integer>)obj;
				 for(String key : cart.keySet()) {%> 
					<h1><%=key %> ------> <%=cart.get(key) %></h1>
				 <%}
			 }
	 %> --%>

</div>


</body>
</html>