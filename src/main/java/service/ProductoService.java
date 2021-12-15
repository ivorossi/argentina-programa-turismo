package service;

import java.util.LinkedList;

import dao.AtraccionDAOImpl;
import dao.PromocionDAOImpl;
import model.Atraccion;
import model.Producto;
import model.Promo;
import model.Usuario;

import sistema.OrdenarLista;

public class ProductoService {
	private AtraccionDAOImpl atraccionDAO = new AtraccionDAOImpl();
	private PromocionDAOImpl promoDAO = new PromocionDAOImpl();
	private LinkedList<Producto> productosOfertables = new LinkedList<Producto>();
	
public LinkedList<Producto> getProductos(Usuario user){
	
	 productosOfertables.addAll(atraccionDAO.dameTodos());
	 productosOfertables.addAll(promoDAO.dameTodos());
	 OrdenarLista ordenarOfertables = new OrdenarLista(user);
	productosOfertables.sort(ordenarOfertables);
	 return productosOfertables;
}

public LinkedList<Promo> getPromos(){
	return this.promoDAO.dameTodos();
}
	public LinkedList<Atraccion> getAtracciones(){
		return this.atraccionDAO.dameTodos();
}


}
