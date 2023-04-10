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
	h1 {
		color: darkblue;
	} 
	p{
		font-size: 20px;
	}
	form{
		border-top: 2px solid darkblue;
		display: inline-block;
	
	}
	input:checked + span {
		color: blue;
		font-weight: bold;
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
	#btn {
		margin-top: 30px;
	}
</style>
</head>
<body>
	<div id="container">
		<h1>장바구니 담기</h1>
		<p> ${loginUser.manager_name } 님이 쇼핑중 입니다.</p>
		<form action="addCart.do" method="post">
			<p>
 				<input type="radio" name="product" value="김밥" checked>
				<span>김밥</span>
 				<input type="radio" name="product" value="햄버거"> 
 				<span>햄버거</span>
 				<input type="radio" name="product" value="콜라">
 				<span>콜라</span>
		    </p>
   			    <input type="number" name="count" value="1"> 
		    <div id="btn">
			    <input type="submit" value="장바구니 담기">
				<input type="button" value="장바구니 보기" onclick="location.href='cartview.do';">
				<input type="button" value="장바구니 비우기" onclick="location.href='cartremove.do';">
		    </div>
 			
 			
		</form>
	</div>
	
	
</body>
</html>