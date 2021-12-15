package controller.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import service.LoginService;

@WebServlet("/loguinServlet")
public class LoguinServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 4956999101167788261L;
	
	private LoginService loginService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Usuario user = loginService.login(username, password);
		
		if(user.isNull()) {
			
    		req.setAttribute("flash", "Usuario o contraseña incorrectos");
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/argentina-programa-turismo/index.jsp");
      		dispatcher.forward(req, resp);
		}else {
    		req.getSession().setAttribute("user", user);
    		resp.sendRedirect("/argentina-programa-turismo/index.jsp"); 
    		
			
		}
		

	}
	
	

	

}
