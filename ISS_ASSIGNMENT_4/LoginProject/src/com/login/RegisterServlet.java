package com.login;
import com.login.dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		UserDao dao = new UserDao();
		String message = dao.registerEmployee(username, password);
		request.setAttribute("message", message);
		if(message == "Registration successful") {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
		}
	}

}
