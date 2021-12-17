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
@WebServlet("/crearUsuario.do")
public class CreaUsuario2 extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1078616828846983705L;
	private UsuarioService usarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usarioService = new UsuarioService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adm/crearUsuario.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("name");
		String apellido = req.getParameter("lastname");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		Integer presupuesto = Integer.parseInt(req.getParameter("monedas"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempoDisponible"));
		String gusto = req.getParameter("gusto");
		String adm = req.getParameter("adm");

		Usuario usuario = usarioService.create(nombre, apellido, userName, password,  presupuesto, tiempo , gusto, adm);
		if (usuario.isValid()) {
			resp.sendRedirect("/argentina-programa-turismo/admin.do");
		} else {
			req.setAttribute("usuario", usuario);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adm/crearUsuario.jsp");
			dispatcher.forward(req, resp);
		} 

	}

}
