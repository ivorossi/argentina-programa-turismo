package controller.usuario;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuarioService;
@WebServlet("/eliminarUsuario.do")
public class EliminarUsuario extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 7707628605083904683L;
	
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("nombre");
		usuarioService.eliminarUsuario(username);
		resp.sendRedirect("/argentina-programa-turismo/admin.do");

	}
}
