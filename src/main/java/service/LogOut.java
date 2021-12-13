package service;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/logOutServlet")
public class LogOut extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8546646598883979143L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.getSession().removeAttribute("user");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		    dispatcher.forward(req, resp);
		
	
    }

}
