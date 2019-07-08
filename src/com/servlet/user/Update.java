package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.bean.User;
import com.dao.UserDao;

/**
 * Servlet implementation class Update
 */
@WebServlet(name = "update", urlPatterns = { "/update" })
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i = 0;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		System.out.println(userID);
		User user = new User(userID, password, phone, email);
		i = UserDao.update(user);
		System.out.println(i);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(i == 1){
			HttpSession session = request.getSession();
			session.invalidate();
			out.print("<script>alert('恭喜您，更新成功！请点击右上角登陆！'); window.location.href='index.html'</script>");
		}else {
			out.print("<script>alert('对不起，由于系统同一时间点用的人数太多，导致您更新信息失败！为您带来不便，我们深表歉意！谢谢您的支持，我们一直在努力...'); window.location.href='userInfomation.jsp'</script>");
		}
	}

}
