package controller.admin;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promo;
import model.Usuario;
import service.ProductoService;
import service.UsuarioService;
@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -3184427119772050728L;
	
	private ProductoService productoService;
	private UsuarioService userService;
	@Override
	public void init() throws ServletException {
		super.init();
		this.productoService = new ProductoService();
		this.userService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	//	Usuario user = (Usuario) req.getSession().getAttribute("user");
		
		List<Usuario> usuarios = userService.getUsers();
		List<Promo> promos = productoService.getPromos();
		List<Atraccion> atracciones = productoService.getAtracciones();
		req.setAttribute("promos", promos);
		req.setAttribute("atracciones", atracciones);
		req.setAttribute("usuarios", usuarios);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
		dispatcher.forward(req, resp);

	}

}
