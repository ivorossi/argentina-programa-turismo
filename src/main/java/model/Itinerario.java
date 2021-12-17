package model;

import java.util.ArrayList;

import dao.ItinerarioDAOImpl;


public class Itinerario {
	private ArrayList<Producto> productosDelusuario = new ArrayList<Producto>();

	public Itinerario(String usuario) {
		
		ItinerarioDAOImpl itinerario = new ItinerarioDAOImpl();
		this.productosDelusuario = itinerario.buscar(usuario);
	}

	public ArrayList<Producto> getProductosDelUsuario() {
		return this.productosDelusuario;
	}

	public void setProducto(Producto productoDelusuario) {
		this.productosDelusuario.add(productoDelusuario);
	}

	public boolean estaComprado(Producto haComprar) {
		if(this.productosDelusuario.isEmpty())
			return false;
		for (Producto yaComprados : productosDelusuario) {
			
			if (yaComprados.esPromo()) {
				Promo comprado = (Promo) yaComprados;
				for (Atraccion elemento : comprado.getAtracciones()) {
					if(haComprar.verificaCompra(elemento))
						return true;
				}
			}else if( haComprar.verificaCompra(yaComprados))
				 	return true;
			
		}
		return false;
	}
	
	public int costoTotal() {
		int costoTotal = 0;
		for(Producto elemento : this.productosDelusuario) {
			costoTotal += elemento.getCostoTotal();
		}
		return costoTotal;
	}
	public double tiempoTotal() {
		double tiempoTotal = 0;
		for(Producto elemento : this.productosDelusuario) {
			tiempoTotal += elemento.getTimepoDeProducto();
		}
		return tiempoTotal;
	}

	private String toStrigDeOroductos() {
		String listadoDeProductos = "";
		for (Producto elemento : productosDelusuario) {
			listadoDeProductos += elemento.toString() + "\n\n";
		}
		return listadoDeProductos;
	}

	@Override
	public String toString() {
		return " tu itinerario: \n\n" + toStrigDeOroductos();
	}

}
