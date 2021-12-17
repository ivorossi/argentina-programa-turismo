package service;

import java.util.ArrayList;
import java.util.LinkedList;

import dao.AtraccionDAOImpl;
import dao.PromocionDAOImpl;
import model.Atraccion;
import model.Producto;
import model.Promo;
import model.PromoAbsoluta;
import model.PromoAxB;
import model.PromoPorcentual;
import model.Usuario;

import sistema.OrdenarLista;

public class ProductoService {
	private AtraccionDAOImpl atraccionDAO = new AtraccionDAOImpl();
	private PromocionDAOImpl promoDAO = new PromocionDAOImpl();
	private LinkedList<Producto> productosOfertables = new LinkedList<Producto>();
	private LinkedList<Atraccion> atraccionesTipo = new LinkedList<Atraccion>();
	
	public LinkedList<Producto> getProductos(Usuario user) {
		productosOfertables.clear();
		productosOfertables.addAll(atraccionDAO.dameTodos());
		productosOfertables.addAll(promoDAO.dameTodos());
		OrdenarLista ordenarOfertables = new OrdenarLista(user);
		productosOfertables.sort(ordenarOfertables);
		return productosOfertables;
	}

	public LinkedList<Promo> getPromos() {
		return this.promoDAO.dameTodos();
	}

	public LinkedList<Atraccion> getAtracciones() {
		return this.atraccionDAO.dameTodos();
	}

	public Atraccion crearAtraccion(String nombre, int costoToltal, double duracion, int cupo, String tipo,
			String descipcion, String url) {
		Atraccion atraccion = new Atraccion(nombre, costoToltal, duracion, cupo, tipo, descipcion, url);
		if (atraccion.isValid()) {
			atraccionDAO.agregar(atraccion);
		}
		return atraccion;
	}

	public void eliminarAtraccion(String nombre) {
		this.atraccionDAO.borrar(nombre);
	}

	public Atraccion buscarAtraccion(String nombre) {
		return this.atraccionDAO.buscar(nombre);
	}
	public Atraccion modificar(int id, String nombre, int costoToltal, double duracion, int cupo, String tipo,
			String descipcion, String url) {
		Atraccion atraccion = new Atraccion(id ,nombre, costoToltal, duracion, cupo, tipo, descipcion, url);
		if (atraccion.isValid()) {
			atraccionDAO.modificar(atraccion);
		}
		return atraccion;
	}
	public LinkedList<Atraccion> atraccionesPorTipo(String tipo){
		this.atraccionesTipo.clear();
		for(Atraccion elemento: this.getAtracciones()) {
			if(elemento.getTipoDeProducto().equalsIgnoreCase(tipo)) {
				this.atraccionesTipo.add(elemento);
			}
		}
		return this.atraccionesTipo;
	}
	
	public Promo crearPromo(String nombre, String tipoDeProducto, String tipoDePromo, String descuento, String[] ids,String descripcion, String url) {
		ArrayList<Atraccion> atraccionesDePromo = new ArrayList<Atraccion>();
		for(String elemento: ids) {
			atraccionesDePromo.add(this.atraccionDAO.buscar(elemento));
		}
		Promo promocion = null;
		if (tipoDePromo.equalsIgnoreCase("absoluta")) {
			int oferta = Integer.parseInt(descuento);
			promocion = new PromoAbsoluta(nombre, tipoDeProducto, oferta,atraccionesDePromo,descripcion, url);

		}
		if (tipoDePromo.equalsIgnoreCase("AxB")) {
			promocion = new PromoAxB(nombre, tipoDeProducto, descuento ,atraccionesDePromo,descripcion, url);

		}
		if (tipoDePromo.equalsIgnoreCase("porcentual")) {
			int oferta = Integer.parseInt(descuento);
			promocion = new PromoPorcentual(nombre, tipoDeProducto, oferta,atraccionesDePromo,descripcion, url);
		}
		this.promoDAO.agregar(promocion);	
		return promocion;
	}
	public void eliminarPromocion(String nombre) {
		this.promoDAO.borrar(nombre);
	}

	public Promo buscarPromo(String nombre) {
		return this.promoDAO.buscar(nombre);
	}

	public Promo modificarPromo(int idPromo, String nombre, String tipoDeProducto, String tipoDePromo, String descuento,
			String[] ids, String descipcion, String url) {
		ArrayList<Atraccion> atraccionesDePromo = new ArrayList<Atraccion>();
		for(String elemento: ids) {
			atraccionesDePromo.add(this.atraccionDAO.buscar(elemento));
		}
		Promo promocion = null;
		if (tipoDePromo.equalsIgnoreCase("absoluta")) {
			int oferta = Integer.parseInt(descuento);
			promocion = new PromoAbsoluta(idPromo, nombre, tipoDeProducto, oferta,atraccionesDePromo, descipcion, url);

		}
		if (tipoDePromo.equalsIgnoreCase("AxB")) {
			promocion = new PromoAxB(idPromo, nombre, tipoDeProducto, descuento ,atraccionesDePromo,descipcion, url);

		}
		if (tipoDePromo.equalsIgnoreCase("porcentual")) {
			int oferta = Integer.parseInt(descuento);
			promocion = new PromoPorcentual(idPromo, nombre, tipoDeProducto, oferta,atraccionesDePromo,descipcion, url);
		}
		this.promoDAO.modificar(promocion);
		return promocion;
	}
}
