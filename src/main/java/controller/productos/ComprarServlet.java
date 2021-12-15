package controller.productos;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import service.ComprarProducto;
import service.LoginService;
@WebServlet("/comprar.do")
public class ComprarServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -5818515849263430488L;
	private ComprarProducto comprarService;
	private LoginService loginService;
	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarService = new ComprarProducto();
		this.loginService = new LoginService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idproducto = req.getParameter("nombre");
		Boolean esPromo = Boolean.parseBoolean(req.getParameter("esPromo"));
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		System.out.println((req.getParameter("esPromo")));
		System.out.println(req.getParameter("nombre"));
		System.out.println(req.getSession().getAttribute("user"));
		Map<String, String> errors = comprarService.buy(user.getUsuario(), idproducto, esPromo);
		
		user = loginService.reload(user.getUsuario());
		req.getSession().setAttribute("user", user);
		
		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
			
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productolist.do");
		dispatcher.forward(req, resp);
	}

}
