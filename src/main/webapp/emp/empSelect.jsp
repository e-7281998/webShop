<%@page import="com.shinhan.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<EmpVO> emplist = (List<EmpVO>)request.getAttribute("empAll");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<style>
/* #container{
       
      width: 80%;
      margin: 0 auto;
  }
  */
  
  h1{
    margin-bottom: 30px;
  } 
.orange {
	background-color: orange;
}

.white {
	background-color: white;
}

#empbtn{
	display: inline-block;
}

#stylebtn{
    display: inline-block;
    float: right;
}
#stylebtn button{
	background-color: darkorange;
    color: white;
    font-weight: bold;
    padding: 10px;
    border-radius: 10px;
    border: none;
}
#stylebtn button:hover{
	background-color: orange;
}
table{
	margin-top: 30px;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
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
		<div>로그인한 사용자 : ${loginUser.manager_name}</div>
		<div id="empbtn">
			<button onclick="location.href='emp_insert.html'" type="button"
				class="btn btn-success">직원등록</button>
			<a type="button" class="btn btn-success" href="empInsert.jsp">직원등록</a>
		</div>
		
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
				<%
				for (EmpVO emp : emplist) {
				%>
				<tr>
					<td><a href="empDetail.do?empid=<%=emp.getEmployee_id()%>"><%=emp.getEmployee_id()%></a></td>
					<td><a href="empDetail.do?empid=<%=emp.getEmployee_id()%>"><%=emp.getFirst_name()%></a></td>
					<td><%=emp.getLast_name()%></td>
					<td><%=emp.getEmail()%></td>
					<td><%=emp.getSalary()%></td>
					<td><%=emp.getHire_date()%></td>
					<td><%=emp.getPhone_number()%></td>
					<td><%=emp.getJob_id()%></td>
					<td><%=emp.getManager_id()%></td>
					<td><%=emp.getCommission_pct()%></td>
					<td><%=emp.getDepartment_id()%></td>
					<td><button class="btnDel" data-del="<%=emp.getEmployee_id()%>">삭제</button></td>
<%-- 					<td><button onclic="call(<%=emp.getEmployee_id()%>)" >삭제</button></td> --%>
				</tr>
				<%
				}
				%>
			</tbody>

		</table>
	</div>
</body>
</html>