package com.techburg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticateServlet extends HttpServlet {

	/**
	 * This servlet is in service when user submit the login form 
	 */
	
	private static final long serialVersionUID = 1340545037755913046L;
	private int cookie_expire_time;
	private  String authenticated_redirect;
	private  String noauthenticated_forward;
	
	@Override
	public void init() {
		//TODO Read servlet configuration for the value of expire_time
		cookie_expire_time = Integer.valueOf(getServletContext().getInitParameter("cookie_expire_time"));
		authenticated_redirect = getServletContext().getInitParameter("authenticated_redirect");
		noauthenticated_forward = getServletContext().getInitParameter("noauthenticated_forward");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		//Check submitted user name and password
		boolean isAuthenticated = false;
		String userName = request.getParameter("user");
		String password = request.getParameter("password");
		isAuthenticated = (userName .equals( "demo") && password .equals( "demo"));
		
		//If authentication succeeds, redirect to user page servlet
		if (isAuthenticated) {
			Cookie authCookie = new Cookie("user", userName);
			authCookie.setMaxAge(cookie_expire_time);
			response.addCookie(authCookie);
			response.sendRedirect(authenticated_redirect);
			//request.getRequestDispatcher(authenticated_forward).forward(request, response);
			
			//TODO: Redirect to the page user requested before forced to login
		}
		else {
			//response.sendRedirect(noauthenticated_redirect);
			request.getRequestDispatcher(noauthenticated_forward).forward(request, response);
		}
	}
}
