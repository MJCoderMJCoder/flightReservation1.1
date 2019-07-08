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
 * Servlet implementation class Query
 */
@WebServlet(name = "query", urlPatterns = { "/query" })
public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		User user = UserDao.query(userID);
		response.setContentType("text/html; charset=utf-8");
		if(user != null){
			PrintWriter out = response.getWriter();
			out.print("no"); //该身份证号已注册,不可以再注册
			System.out.println("no");
		}else {
			PrintWriter out = response.getWriter();
			out.print("yes"); //改身份证号未注册，可以注册
			System.out.println("yes");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
