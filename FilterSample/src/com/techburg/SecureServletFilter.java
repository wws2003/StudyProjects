package com.techburg;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SecureServletFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		try {
			boolean isAuthenticated = false;
			
			Cookie[] cookies = ((HttpServletRequest)request).getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName() .equals("user")) {
						isAuthenticated = true;
						break;
					}
				}
			}
			
			if(isAuthenticated)
				filterChain.doFilter(request, response);
			else {
				//The path to the jsp file should never be displayed to user -> use forward instead of sendRedirect
				String path = "/jsp/login.jsp";
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
				requestDispatcher.forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace(response.getWriter());
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
