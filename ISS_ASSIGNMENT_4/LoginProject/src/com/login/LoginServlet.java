package com.login;

import com.login.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		
		UserDao dao = new UserDao();
		String message = dao.verify(username, password);
		if(message.equals("true")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("welcome.jsp");
		} else {
			request.setAttribute("message", message);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
