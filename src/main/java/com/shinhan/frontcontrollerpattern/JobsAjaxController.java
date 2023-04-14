package com.shinhan.frontcontrollerpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.shinhan.model.CompanyService;
import com.shinhan.vo.JobVO;

public class JobsAjaxController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		//모든 job 조회하기
		CompanyService service = new CompanyService();
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		List<JobVO> joblist = service.jobSelectAll();
		request.setAttribute("jobList", joblist);
		//javascript로 작성된 ajax 부분에 전달하는 방법1 --- JSP만들어서 보낸다. (HTML 디자인)
		//return "jobView.jsp";
		//javascript로 작성된 ajax 부분에 전달하는 방법2 --- JSON 만들어서 보낸다. (JS로 디자인)
		JSONArray arr = new JSONArray();
		
		for(JobVO job:joblist) {
			JSONObject obj = new JSONObject();
			obj.put("job_id", job.getJob_id());
			obj.put("job_title", job.getJob_title());
			arr.add(obj);	//[{},{},{}]
		}
		//{"jobList":[{"job_id":"IT"},{}]}와 같은 문자열로 만들기
		JSONObject jobsObj = new JSONObject();
		jobsObj.put("jobList", arr);
		
		return "responseBody:"+jobsObj.toString();
	}

}
