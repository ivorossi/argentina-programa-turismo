package model;

import java.util.ArrayList;

import exceptions.ExcepcionDeProducto;

public class PromoAxB extends Promo {
	private String atraccionGratis;

	public PromoAxB(int idProducto, String nombreDeProducto, String tipoDeProducto,
			String atraccionGratis,  ArrayList<Atraccion> atracciones) throws ExcepcionDeProducto {

		super(idProducto, nombreDeProducto, tipoDeProducto, atracciones);

		this.atraccionGratis = atraccionGratis;
		this.aplicarDescuento();
	}
	
	public PromoAxB( String nombreDeProducto, String tipoDeProducto,
			String atraccionGratis,  ArrayList<Atraccion> atracciones, String descripcion , String url)  {

		super( nombreDeProducto, tipoDeProducto, atracciones, descripcion, url);

		this.atraccionGratis = atraccionGratis;
		this.aplicarDescuento();
	}
	public PromoAxB(int id, String nombreDeProducto, String tipoDeProducto,
			String atraccionGratis,  ArrayList<Atraccion> atracciones, String descripcion , String url)  {

		super( nombreDeProducto, tipoDeProducto, atracciones, descripcion, url);

		this.atraccionGratis = atraccionGratis;
		this.aplicarDescuento();
	}


	private void aplicarDescuento() {
		for (Atraccion elemento : super.atracciones) {
			if (this.atraccionGratis.equalsIgnoreCase(elemento.getNombreDeProducto()))
				super.costoTotal -= elemento.getCostoTotal();
		}
	}

	@Override
	public String toString() {
		return "Promo de tipo AxB la atraccion: " + atraccionGratis + " es gratis.\n" + super.toString();
	}

	@Override
	public String getTipoDePromo() {
		return "AxB";
	}

	@Override
	public String getDescuento() {
		return this.atraccionGratis ;
	}

}
