package com.shinhan.frontcontrollerpattern;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import com.shinhan.model.EmpService;
import com.shinhan.vo.EmpVO;

public class EmpListController implements CommonControllerInterface{

	@Override
	public String execute(Map<String, Object> data) throws Exception{
		 EmpService service = new EmpService();
		 List<EmpVO> emplist = service.selectAll();
		 
		 //request가 유지되는 동안 저장한다.
		 HttpServletRequest request = (HttpServletRequest)data.get(("request"));
		 request.setAttribute("empAll", emplist);
		 
		 return "empSelect.jsp";
	}

}
