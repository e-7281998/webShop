<%@page import="com.shinhan.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file = "../common/commonFiles.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/select.css" type="text/css">

<script>
	$(() => {
		$(".btnDel").on("click",function(){
			//get방식임.
			location.href="empDelete.do?empid="+$(this).attr("data-del");
		})
	});
</script>
<script>
   $(function(){
	  
	   $("thead tr th").click(function(e){
		   var trNum = $(this).closest("th").prevAll().length;
		   var a = $("tbody tr").each(function(index, item){
			   var col = $(item).find("td:nth-child(" + (trNum+1) + ")");
			   console.log(col);
			   //기존 선택을 clear
			   $(item).find("td").css("background-color", "white");
			   //신규 선택의 색깔 바꾸기
			   $(col).css("background-color", "lightyellow");
			   
		   });
		   
	   });
	   //내가 시작
	   
	   //짝수 행 선택
	   $("#stylebtn > button:first").click(function(e){
		   $("tbody tr:even").css("color","red");
	   });
	   //홀수 행 선택
	    $("#stylebtn > button:nth-child(2)").click(function(e){
		   $("tbody tr:odd").css("color","blue");
	   }); 
	   
	    /* $ ("#btn1") .click (function () (

	    		$("tr:nth-child (2n) ").css ("background-color", "lightgray");

	    		$("tr:nth-child (2n+1) ") .css ("background-color", "white");

	    		]):

	    		//body > div > table > tbody > tr:nth-child (1) > td:nth-child (2)

	    		$ ("#btn2") .click (function () (

	    		$("tr > td:nth-child (2): contains ('S')") .css ("color", "red");

	    		) i

	    		$ ("#btn3") .click (function () {

	    		$("tr td:contains ('S') ").css ("color", "red");

	    		]): */
	   

		   
		   
	   //이름이 S로 시작하는 직원

	   //찾고자하는 value 브라우저에서 클릭 > 우클릭 > copy > copySelector
	   //하면 다음과 같이 해당 값의 경로를 얻을 수 있음. 공통점 찾아서 선택
	   //body > div > table > tbody > tr:nth-child(1) > td:nth-child(2)
	   //body > div > table > tbody > tr:nth-child(2) > td:nth-child(2)
	   $("#stylebtn > button:nth-child(3)").click(function(){
			var start = prompt("찾고자하는 직원의 이름을 입력하세요",'Steven');
			
			var f = start.charAt(0).toUpperCase();
			var s = start.slice(1).toLowerCase(); 
			start = f+s;
			
		   //$("tbody > tr > td:nth-child(2):contains('S')"); //이름이 S로 시작하는 직원 찾기
		   $("tbody > tr > td:nth-child(2)").parent().css({"backgroundColor":"transparent", "fontWeight":"400"});
		   $("tbody > tr > td:nth-child(2):contains('"+start+"')").parent().css({"backgroundColor":"lightyellow", "fontWeight":"bold"});
	   });
	   
   		$("select").change(function(){
   			var jobid = $(this).val();
   			//init();
   			$("tr td").css("color","black");
   			$("tr td:contains('" + jobid + "')").css("color", "red");
 		});
   		
   		var str = "";
   		var arr = ["IT_PROG", "AD_PRES", "AD_VP", "ST_MAN"];
   		$.each(arr, function(index, item){
   			console.log(`${item}`)
   			str += `<option>${item}</option>`;
   		});
   		
   		$("#jobs").html(str);
	   
   });
  </script>
 
</head>
<body>
	<div class="container mt-3">
		<h1>직원목록</h1>
		<!-- include 디렉티브는 소스를 합쳐서 컴파일 한다. -->
		<%-- include 지시자 <%@ include file="../common/Header.jsp" %>  --%>
		<%@ include file="../common/Header.jsp" %>
		<p>
			jsp는 합쳐서 컴파일 됨... header에서 작성한 company...
			<br><%=company %>
		</p>
		<!-- include action tag이용 : 컴파일하고 합침 -->
		<%-- <jsp:include page="../common/Header.jsp"></jsp:include>  --%>
		
		<div id="empbtn">
			<button onclick="location.href='emp_insert.html'" type="button"
				class="btn btn-success">직원등록</button>
			<a type="button" class="btn btn-success" href="empinsert.do">직원등록</a>
			
		</div>
		<form method="post" action="${path}/emp/empinsert.do">
				<input type="submit" value="직원등록-폼">
		</form>
		<div id="stylebtn">
			<button>짝수 행 선택</button>
			<button>홀수 행 선택</button>
			<button>직원 이름으로 찾기</button>
		</div>
		<select>
			<option>AD_PRES</option>
			<option>AD_VP</option>
			<option>IT_PROG</option>
			<option>FI_MGR</option>
			<option>FI_ACCOUNT</option>
			<option>PU_MAN</option>
			<option>ST_MAN</option>
			<option>ST_CLERK</option>
			<option>SA_REP</option>
			<option>SH_CLERK</option>
			<option>AD_ASST</option>
			<option>MK_MAN</option>
		</select>
		<select id="jobs">
		</select>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>직원번호</th>
					<th>이름</th>
					<th>성</th>
					<th>이메일</th>
					<th>급여</th>
					<th>입사일</th>
					<th>전화번호</th>
					<th>직책</th>
					<th>메니져</th>
					<th>커미션</th>
					<th>부서</th>
					<th>부서</th>
				</tr>
			</thead>
			<tbody>
				<!--  for(EmpVO emp:empAll -->
				<c:forEach items="${empAll}" var="emp"> 
				<tr>
					<td><a href="empDetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
					<td><a href="empDetail.do?empid=${emp.employee_id}">${emp.first_name}</a></td>
					<td>${emp.last_name} </td>
					<td>${emp.email} </td>
					<td>${emp.salary} </td>
					<td>${emp.hire_date} </td>
					<td>${emp.phone_number} </td>
					<td>${emp.job_id} </td>
					<td>${emp.manager_id} </td>
					<td>${emp.commission_pct} </td>
					<td>${emp.department_id} </td>
					<td><button class="btnDel" data-del="${emp.employee_id}">삭제</button></td>
 				</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>
</body>
</html>