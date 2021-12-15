package service;

import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Producto;
import model.Promo;
import model.Usuario;
import dao.AtraccionDAOImpl;
import dao.UsuarioDAOImpl;
import dao.PromocionDAOImpl;

public class ComprarProducto {
	
	AtraccionDAOImpl AtraccionDAO = new AtraccionDAOImpl();
	PromocionDAOImpl promoDAO = new PromocionDAOImpl();
	UsuarioDAOImpl userDAO = new UsuarioDAOImpl();

	public Map<String, String> buy(String userId, String nombreProducto, boolean esPromo) {
		
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = userDAO.buscar(userId);
		System.out.println(esPromo);

		Producto producto2;
		if(esPromo) {
			producto2 = promoDAO.buscar(nombreProducto);
		}else {
			producto2 = AtraccionDAO.buscar(nombreProducto);
		} 

		if (user.getPresupuesto() < producto2.getCostoTotal()) {
			errors.put("user", "No tienes dinero suficiente");	
		}
	
		if (user.getTiempoDisponible() < producto2.getTimepoDeProducto()) {
					errors.put("user", "No tienes tiempo suficiente");	
		}
		if (!producto2.hayCupo()) {
					errors.put("porducto","No hay cupo suficiente");	
		}
		if (user.getItinerario().estaComprado(producto2)) {
		errors.put("user", "ya comprado");
		}
		System.out.println(errors);


		if (errors.isEmpty()) {
			user.Comprar(producto2);
			userDAO.modificar(user);
			if(producto2.esPromo()) {
			promoDAO.modificar((Promo) producto2);
			}else {
			AtraccionDAO.modificar((Atraccion) producto2);
			}
		}

		return errors;
	}
}
