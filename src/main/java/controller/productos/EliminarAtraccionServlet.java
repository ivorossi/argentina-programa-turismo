package controller.productos;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductoService;

@WebServlet("/eliminarAtraccion.do")
public class EliminarAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 2642535477522636393L;
	private ProductoService productoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.productoService = new ProductoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombres = req.getParameter("nombre");
		productoService.eliminarAtraccion(nombres);
		resp.sendRedirect("/argentina-programa-turismo/admin.do");

	}
}
