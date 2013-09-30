package com.techburg;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ReloadingServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reloadUrl = "/manager/html/reload?path=/servlet-examples";
		RequestDispatcher dispatcher = request.getRequestDispatcher(reloadUrl);
		dispatcher.include(request, response);
	}

}
