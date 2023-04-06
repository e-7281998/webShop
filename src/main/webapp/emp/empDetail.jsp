<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 상세보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
#container {
	width: 400px;
	border: 1px solid #333;
	margin: 0 auto;
	padding: 20px;
	text-align: center;
}


input[name="email"],
input[name="salary"],
input[name="department_id"],
input[name="manager_id"],
input[name="hire_date"],
input[name="job_id"]{
	background: lightgreen;
}
</style>
</head>
<body>
	<div id="container">
		<h1>직원 상세보기</h1> 
		<form method="post" action="<%=request.getContextPath()%>/emp/empDetail.do" class="mb-3">
			<table>
				<tr class="form-floating">
					<td><label for="employee_id">직원번호</label></td>
					<td>
						<span>${emp.employee_id}</span>
						<input class="form-control" type="hidden"
						name="employee_id" id="employee_id"  
						value="${emp.employee_id}" ></td>
				</tr>
				<tr>
					<td>firstName</td>
					<td><input type="text" name="first_name" maxlength="20"
						value="${emp.first_name}" ></td>
				</tr>
				<tr>
					<td>LastName</td>
					<td><input type="text" name="last_name" required="required"
						value="${emp.last_name}"  ></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" required="required"
						value="${emp.email}"></td>
				</tr>
				<tr>
					<td>phone</td>
					<td><input type="tel" name="phone_number"
						 pattern="010-[0-9]{4}-[0-9]{4}"
						value="${emp.phone_number}"  ></td>
				</tr>
				<tr>
					<td>salary</td>
					<td><input type="number" name="salary" value="${emp.salary}"></td>
				</tr>
				<tr>
					<td>부서</td>
					<td><input type="number" name="department_id" value="60"
						value="${emp.department_id}"></td>
				</tr>
				<tr>
					<td>메니저</td>
					<td><input type="number" name="manager_id" value="100"
						value="${emp.manager_id}"></td>
				</tr>
				<tr>
					<td>커미션</td>
					<td><input type="text" name="commission_pct" 
						value="${emp.commission_pct}" ></td>
				</tr>
				<tr>
					<td>입사일</td>
					<td><input type="date" name="hire_date" required="required"
						value="${emp.hire_date}"></td>
				</tr>
				<tr>
					<td>직급</td>
					<td><input type="text" name="job_id" required="required"
						value="${emp.job_id}" ></td>
				</tr>
				<tr style="text-align: center;">
					<td colspan="2"><input type="submit" value="직원수정"></td>
				</tr>
			</table>
	</div>

	<script>
		function call() {
			//DOM(Document Object Model)
			document.getElementById("here").innerHTML = new Date();
			document.getElementById("employee_id").value = 888;
		}
	</script>
</body>
</html>
