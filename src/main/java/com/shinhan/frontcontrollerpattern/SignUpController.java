package com.shinhan.frontcontrollerpattern;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

public class SignUpController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception { 
 		HttpServletRequest request = (HttpServletRequest)data.get("request");
		
//		String mname = request.getParameter("manager_name");
//		//get방식은 patameter가 넘어올 때 url에 encoding되어 들어온다. 
//		//post방식은 parameter가 넘어올 때 요청문서의 body에 들어온다. 한글이 깨짐
//		String email = request.getParameter("email");
//		String pass = request.getParameter("pass");
		
 		AdminService service = new AdminService();
		int result = service.registerAdmin(doHandle(request));
		 
		return "redirect:loginCheck.do";
	}
	private AdminVO doHandle(HttpServletRequest request)	throws ServletException, IOException {
 		AdminVO vo = new AdminVO();
		String encoding = "utf-8";
			
		String currentPath = request.getServletContext().getRealPath("uploads");
		System.out.println(currentPath);
			
		File currentDirPath = new File(currentPath);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {
					//input type이 file이 아닌 것
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					String colName = fileItem.getFieldName();
					String calValue = fileItem.getString(encoding);
					if(colName.equals("manager_name")) vo.setManager_name(calValue);
					if(colName.equals("email")) vo.setEmail(calValue);
					if(colName.equals("pass")) vo.setPass(calValue);
				} else {
					System.out.println("getFieldName" + fileItem.getFieldName());
					System.out.println("getName:" + fileItem.getName());
					System.out.println("getSize:" + fileItem.getSize() + "bytes");

					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx + 1);
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
						
						//이미지 이름이 DB에 저장되어야 한다.
						vo.setPic(fileName);
					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("adminvo :" + vo);
		return vo;
}


}
