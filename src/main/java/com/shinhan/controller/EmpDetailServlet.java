package com.shinhan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.EmpService;
import com.shinhan.util.DateUtil;
import com.shinhan.vo.EmpVO;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet("/emp/empDetail.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상세보기 하고싶음... a태그로 왔으니 get방식
		EmpService service = new  EmpService();
		int empid = Integer.parseInt(request.getParameter("empid"));
		EmpVO emp = service.selectById(empid);
		
		request.setAttribute("emp", emp);
		
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpVO emp = makeEmp(request);
		EmpService service = new  EmpService();
		String message = service.empUpdate(emp);
		response.sendRedirect("emplist.do"); 
	}
	
	private EmpVO makeEmp(HttpServletRequest request) throws UnsupportedEncodingException {
		//입력된 파라메터를 읽어서 DV에 저장하기 위해 옴.
		//request.setCharacterEncoding("utf-8");	//필터에서 수행하고 옴
		String first_name =request.getParameter("first_name");
		String last_name =request.getParameter("last_name");
		String email =request.getParameter("email");
		String phone_number =request.getParameter("phone_number");
		Double salary =Double.parseDouble( request.getParameter("salary"));
		int department_id =Integer.parseInt(request.getParameter("department_id"));
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		String commission_pct = request.getParameter("commission_pct");
		Date hire_date = DateUtil.convertToDate(request.getParameter("hire_date"));
		String job_id =request.getParameter("job_id");
		int employee_id =Integer.parseInt(request.getParameter("employee_id"));
		

		
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(Double.parseDouble(commission_pct));
		emp.setDepartment_id(department_id);
		emp.setEmployee_id(employee_id);
		emp.setEmail(email);
		emp.setFirst_name(first_name);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setLast_name(last_name);
		emp.setManager_id(manager_id);
		emp.setPhone_number(phone_number);
		emp.setSalary(salary); 
		
		return emp;
	}

}
