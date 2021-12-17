package controller.usuario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import service.UsuarioService;
@WebServlet("/itinerario.do")
public class Itinerario extends HttpServlet {

	private static final long serialVersionUID = 6854293191294340807L;
	
private UsuarioService usuarioservice;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioservice = new UsuarioService();
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("username");
		Usuario usuario = usuarioservice.buscar(nombre);
		req.setAttribute("usuario", usuario);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/usuario/itinerario.jsp");
		dispatcher.forward(req, resp);
	}

}
