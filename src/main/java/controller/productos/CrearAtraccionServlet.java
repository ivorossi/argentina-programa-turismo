package controller.productos;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import service.ProductoService;

@WebServlet("/crearAtraccion.do")
public class CrearAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 2396116774696721954L;
	
	private ProductoService productoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.productoService = new ProductoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adm/crearEditarAtraccion.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		int costoToltal = Integer.parseInt(req.getParameter("costoTotal"));
		double duracion = Double.parseDouble(req.getParameter("tiempoDeProducto"));
		int cupo = Integer.parseInt(req.getParameter("cupo"));
		String tipo = req.getParameter("tipoDeProducto");
		String descipcion = req.getParameter("descripcion");
		String url = req.getParameter("url");

		

		Atraccion atraccion = productoService.crearAtraccion(nombre, costoToltal, duracion, cupo, tipo, descipcion, url);
		if (atraccion.isValid()) {
			resp.sendRedirect("/argentina-programa-turismo/admin.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adm/crearEditarAtraccion.jsp");
			dispatcher.forward(req, resp);
		}

	}


}
