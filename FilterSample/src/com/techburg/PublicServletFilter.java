package com.techburg;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PublicServletFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/public.jsp");
			requestDispatcher.forward(request, response);
			
			/*HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect("/sapp1/jsp/public.jsp");*/
		}
		catch(Exception e) {
			e.printStackTrace(response.getWriter());
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
