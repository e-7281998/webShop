package com.shinhan.controller2;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart/addCart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dopost는 body부분에 오니까 인코딩해줘야 한다. => 한글이 깨지기 때문에
		//request.setCharacterEncoding("utf-8"); //필터에서 수행하고 옴
		String product = request.getParameter("product");
		int count = Integer.parseInt(request.getParameter("count"));
		
		HttpSession session = request.getSession();	//있으면 얻고, 없으면 새로 만든다. 는 의미.
		Object obj = session.getAttribute("cart");	//Hash타입으로 안얻음... 있을수도 있고 없을수도 있으므로 일단 Object 로 얻음
		HashMap<String, Integer> cart = null;
				
		if(obj == null) {
			//장바구니에 저장한적 없으면 만들기
			cart = new HashMap<>();
			cart.put(product, count);
			session.setAttribute("cart", cart);
		}
		else {
			//장바구니에 저장한적 있으면 형변환
			cart = (HashMap<String, Integer>)obj;
			if(cart.containsKey(product)) {
				int originalCount = cart.get(product);	//몇 개 담았는지 value 가져와보기 
				cart.put(product, originalCount + count);	//아까 한거에 지금꺼 더해서 장바구니에 담기
			}else {
				cart.put(product, count);
			}
			
		} 
		
		response.sendRedirect("addCart.do"); 
	} 
}
