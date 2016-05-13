package com.rama;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReqRedirect
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String un = request.getParameter("username");
		String p = request.getParameter("pw");

		if (p.equals("sairam")) {
			RequestDispatcher rd = request.getRequestDispatcher("servlet2");
			rd.forward(request, response);
		} else {
			out.println("Sorry UserName or Password Error!");
			RequestDispatcher rd = request.getRequestDispatcher("/hello.jsp");
			rd.include(request, response);
		}
	}

}
