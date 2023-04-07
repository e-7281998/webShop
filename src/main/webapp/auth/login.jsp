<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css" type="text/css">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.4.min.js"></script>
<script>
	$(() => {
 		//page이동 없이 서버에 요청 보내고 응답받기 : ajax
		$("#emailDupCheck").on("click",() =>{
 			$.ajax({
				url:"emailDupCheck.do",
				data:{"email":$("#m_email").val()},
				success: (responseData)=>{ 
					var message = responseData ==1 ? "이미 존재하는 이메일" : "사용 가능한 이메일";
					$("#message").text(message);
					if(responseData == 1){
						$("#m_email").val("");
						$("#m_email").focus();
					} 
				},
				error:(message) => {
					alert(message);
				}
			});
		})
	});
</script>
</head>
<body>
	<p>${visitor}번째 방문자</p>

<h2>Weekly Coding Challenge #1: Sign in/up Form</h2>
<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form method="post" action="<%=request.getContextPath() %>/auth/signup.do">
      <h1>Create Account</h1>
      <div class="social-container">
        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
      </div>
      <span>or use your email for registration</span>
      <input type="text" name="manager_name" placeholder="Name" />
      <input type="email" id="m_email" name="email" placeholder="Email" />
      <span id="message">!!</span>
      <input type="button" id="emailDupCheck" value="중복체크" />
      <input type="password" name="pass" placeholder="Password" />
      <button>Sign Up</button>
    </form>
  </div>
  <div class="form-container sign-in-container">
  <!-- 주소를 호출 -->
  <!-- application/x-www-form-urlencoded : get방식을 통해 문자열이 넘어간다.? -->
<!--<form action="loginCheck.do" method="get" enctype="application/x-www-form-urlencoded"> -->
    <form action="<%=request.getContextPath() %>/auth/loginCheck.do" method="post" enctype="application/x-www-form-urlencoded">
      <h1>Sign in</h1>
      <div class="social-container">
        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
      </div>
      <span>or use your account</span>
      <input type="email" name="email" placeholder="Email" />
      <input type="password" name="pass" placeholder="Password" />
      <a href="#">Forgot your password?</a>
      <button>Sign In</button> 
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>Welcome Back!</h1>
        <p>To keep connected with us please login with your personal info</p>
        <button class="ghost" id="signIn">Sign In</button>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>Hello, Friend!</h1>
        <p>Enter your personal details and start journey with us</p>
        <button class="ghost" id="signUp">Sign Up</button>
      </div>
    </div>
  </div>
</div>
<script src='https://kit.fontawesome.com/a076d05399.js' ></script>
<script src="<%=request.getContextPath() %>/js/login.js"></script>

</body>
</html>