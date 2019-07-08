package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet(name = "register", urlPatterns = { "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		User user = new User(userID, password, phone, email);
		int i = UserDao.register(user);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(i == 1){
			out.print("<script>alert('恭喜您，注册成功！请点击右上角登陆！'); window.location.href='index.html'</script>");
		}else {
			out.print("<script>alert('对不起，由于系统同一时间点用的人数太多，导致您注册失败！为您带来不便，我们深表歉意！谢谢您的支持，我们一直在努力...'); window.location.href='index.html'</script>");
		}
	}

}
