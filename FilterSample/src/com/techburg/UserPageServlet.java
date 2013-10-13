package com.techburg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserPageServlet extends HttpServlet {

	/**
	 *This servlet is in service if user successfully authenticated.
	 * It renders values to the jsp page which will be displayed  to user  
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		//TODO Apply session to retrieve user info such as name
		
		HttpSession session = request.getSession();
		String myName = (String) session.getAttribute("myname");
		
		request.setAttribute("myname", myName);
		request.getRequestDispatcher("/jsp/mypage.jsp").forward(request, response);
	}

}
