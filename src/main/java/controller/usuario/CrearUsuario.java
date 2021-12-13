package controller.usuario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import service.UsuarioService;

@WebServlet("/usuario/crear.do")
public class CrearUsuario extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -9102702480229297798L;
	
	private UsuarioService usarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usarioService = new UsuarioService();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("name");
		String apellido = req.getParameter("lastname");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		Integer presupuesto = Integer.parseInt(req.getParameter("monedas"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempoDisponible"));
		String gusto = req.getParameter("gusto");
		String code = req.getParameter("code");

		Usuario user = usarioService.create(nombre, apellido, userName, password,  presupuesto, tiempo , gusto, code);
		if (user.isValid()) {
			resp.sendRedirect("/index.jsp");
		} else {
			req.setAttribute("user", user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/registro.jsp");
			dispatcher.forward(req, resp);
		}

	}


}
