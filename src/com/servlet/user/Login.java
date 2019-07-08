package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		User user = UserDao.query(userID);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (user != null) {
			String password = request.getParameter("password");
			if (password.equals(user.getPassword())) {
				out.print("yesPW"); // 密码正确
			} else {
				out.print("noPW"); // 密码错误
			}
		} else {
			out.print("noID"); // 该身份证号未注册，不可以登录
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		User user = UserDao.query(userID);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		response.sendRedirect("jsp/dateCity.jsp");
	}

}
