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
import model.Atraccion;
import model.Promo;
import service.ProductoService;
@WebServlet("/editarPromocion.do")

public class EditarPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -3350569043424248802L;
	private ProductoService productoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.productoService = new ProductoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Promo promocion = productoService.buscarPromo(nombre);
		req.setAttribute("promocion", promocion);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adm/editarPromocion.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPromo = Integer.parseInt(req.getParameter("idProducto"));
		String nombre = req.getParameter("nombre");
		String tipoDeProducto = req.getParameter("tipoDeProducto");
		String tipoDePromo = req.getParameter("tipoDePromo");
		String descuento = req.getParameter("descuento");
		String []ids = req.getParameterValues("idAtraccion");
		String descipcion = req.getParameter("descripcion");
		String url = req.getParameter("url");
		List<Atraccion> atracciones = productoService.atraccionesPorTipo(tipoDeProducto);
		if(ids == null) {
			req.setAttribute("idPromo", idPromo);
			req.setAttribute("atracciones", atracciones);
			req.setAttribute("tipoDePromo", tipoDePromo);
			req.setAttribute("tipoDeProducto", tipoDeProducto);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adm/editarPromocion2.jsp");
			dispatcher.forward(req, resp);
		}else {
			Promo promocion = productoService.modificarPromo(idPromo, nombre, tipoDeProducto, tipoDePromo, descuento, ids, descipcion, url);
			if(promocion.isValid()) {
				resp.sendRedirect("/argentina-programa-turismo/admin.do");

			}else {
				req.setAttribute("promocion", promocion);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adm/editarPromocion2.jsp");
				dispatcher.forward(req, resp);
			}

			
		}

	

		}

}
