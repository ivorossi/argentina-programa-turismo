package controller.productos;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductoService;

@WebServlet("/eliminarPromocion.do")
public class EliminarPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1307069480273823393L;
	private ProductoService productoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.productoService = new ProductoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		productoService.eliminarPromocion(nombre);
		resp.sendRedirect("/argentina-programa-turismo/admin.do");

	}

}
