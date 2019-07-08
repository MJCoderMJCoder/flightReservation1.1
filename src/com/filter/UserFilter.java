package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(filterName = "userFilter", urlPatterns = { "/userFilter" })
public class UserFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UserFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String path = req.getServletPath();
//		System.out.println(path);
		if (user != null || path.contains("css") || path.contains("javascript")
				|| path.contains("image") || path.contains("index")
				|| path.contains("login") || path.contains("query")
				|| path.contains("register")) {

			chain.doFilter(request, response);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('登录后方可预订机票');window.location.href='../index.html'</script>");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
