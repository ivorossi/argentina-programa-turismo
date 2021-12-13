package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Usuario {
	private boolean adm = false;
	private String usuario, contrasenia;
	private String nombre;
	private String gusto;
	private int presupuesto;
	private double tiempoDisponible;
	private Itinerario itinerarioDelUsuario;
	private Map<String, String> errores;
	public Usuario(String usuario, String contrasenia, String nombre, String gusto, 
					int presupuesto, double tiempoDisponible) {
		
		this.nombre = nombre;
		this.gusto = gusto;
		this.tiempoDisponible = tiempoDisponible;
		this.presupuesto = presupuesto;
		this.usuario = usuario;
		this.contrasenia = contrasenia; 
		this.itinerarioDelUsuario = new Itinerario(usuario);
	}
	public boolean isValid() {
		validate();
		return errores.isEmpty();
	}
	
	public void validate() {
		errores = new HashMap<String, String>();

		if (this.presupuesto <= 0) 
			errores.put("cost", "Debe ser positivo");

		if (this.tiempoDisponible <= 0) 
			errores.put("duration", "Debe ser positivo");
	}
	
	public Map<String, String> getErrors() {
		return errores;
	}
	
	public boolean isNull() {
		return false;
	}
	public boolean isAdm() {
		return this.adm;
	}
	
	public void Comprar(Producto compra) {
		this.presupuesto -= compra.getCostoTotal();
		this.tiempoDisponible -= compra.getTimepoDeProducto();
		compra.restarCupo();
		itinerarioDelUsuario.setProducto(compra);
	}

	public String getNombre() {
		return nombre;
	}

	public String getGusto() {
		return gusto;
	}

	public String getContrasenia() {
		return contrasenia;
	}



	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public Boolean verificarContrasenia(String contrasenia) {
		return this.contrasenia.equals(contrasenia);
	}
	@Override
	public String toString() {
		return nombre + itinerarioDelUsuario + "\nGracias Por tu compra!!\n" + "tu vuelto es: " + presupuesto
				+ " monedas y tu tiempo libre es de: " + tiempoDisponible + "hs;";
	}

	public  ArrayList<Producto >getItinerario() {
		return this.itinerarioDelUsuario.getProductosDelUsuario();
	}
	
	public boolean loPuedoComprar(Producto haComprar) {
		
		return (this.getTiempoDisponible() >= haComprar.getTimepoDeProducto()
				&& this.getPresupuesto() >= haComprar.getCostoTotal() && haComprar.hayCupo()
				&& !this.itinerarioDelUsuario.estaComprado(haComprar));
	}
	
}
