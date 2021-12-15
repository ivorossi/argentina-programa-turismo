package controller.productos;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import model.Usuario;
import service.ProductoService;

@WebServlet("/productolist.do")
public class ListarProductos extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -110539696085164696L;

	private ProductoService productoService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.productoService = new ProductoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		
		List<Producto> productos = productoService.getProductos(user);
		req.setAttribute("productos", productos);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productos.jsp");
		dispatcher.forward(req, resp);

	}
}
