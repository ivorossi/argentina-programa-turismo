package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exceptions.ExcepcionDeProducto;
import model.Atraccion;
import model.Promo;
import model.PromoAbsoluta;
import model.PromoAxB;
import model.PromoPorcentual;

public class PromocionDAOImpl extends GenericDAO<Promo> {

	@Override
	public int agregar(Promo promocion) {
		int cambios = 0;
		try {
			PreparedStatement statement = super.consulta("INSERT INTO promocion"
					+ "( nombre, tipo_promocion, descuento, tipo, descripcion, url) VALUES ( ?, ?, ?, ?, ?, ? )");
			statement.setString(1, promocion.getNombreDeProducto());
			statement.setString(2, promocion.getTipoDePromo());
			statement.setString(3, promocion.getDescuento());
			statement.setString(4, promocion.getTipoDeProducto());
			statement.setString(5, promocion.getDescuento());
			statement.setString(6, promocion.getTipoDeProducto());
			cambios += statement.executeUpdate();
			AtraccionesDePromoDAOImpl atraccionDePromo = new AtraccionesDePromoDAOImpl();
			cambios = atraccionDePromo.agregar(promocion);
		} catch (Exception e) {
			System.out.println(e);
		}
		return cambios;
	}

	@Override
	public int modificar(Promo promocion) {
		int cambios = 0;
		try {
			PreparedStatement statement = super.consulta(
					"UPDATE promocion SET nombre =?, tipo_promocion =?, descuento =?,"
							+ "tipo =?, descripcion=?, url=? WHERE id_promocion =?");
			statement.setString(1, promocion.getNombreDeProducto());
			statement.setString(2, promocion.getTipoDePromo());
			statement.setString(3, promocion.getDescuento());
			statement.setString(4, promocion.getTipoDeProducto());
			statement.setString(5, promocion.getDescripcion());
			statement.setString(6, promocion.getRefImg());
			statement.setInt(7, promocion.getIdProducto());
			cambios += statement.executeUpdate();
			AtraccionesDePromoDAOImpl atraccionDePromo = new AtraccionesDePromoDAOImpl();
			cambios += atraccionDePromo.modificar(promocion);
		} catch (Exception e) {
			System.out.println(e);
		}
		return cambios;
	}


	@Override
	protected String consultaDeBuscar() {
		return "SELECT * FROM promocion WHERE nombre =?";
	}

	@Override
	protected String consultaDeDameTodos() {
		return "SELECT * FROM promocion WHERE borrar = 0";
	}

	@Override
	protected String consultaDeContarTodos() {
		return "SELECT * FROM promocion WHERE nombre =?";
	}

	@Override
	protected String consultaDeBorrar() {
		return "UPDATE promocion SET borrar =? WHERE nombre =?";
		
	}

	@Override
	public Promo convertirT(ResultSet resultados) throws SQLException {
		AtraccionesDePromoDAOImpl atraccionDePromo = new AtraccionesDePromoDAOImpl();

			if (resultados.getString(3).equalsIgnoreCase("absoluta")) {
				return new PromoAbsoluta(resultados.getInt(1), resultados.getString(2), resultados.getString(5),
						Integer.parseInt(resultados.getString(4)), atraccionDePromo.buscar(resultados.getString(2)), resultados.getString(6), resultados.getString(7) );
			}
			if (resultados.getString(3).equalsIgnoreCase("AxB")) {
				return new PromoAxB(resultados.getInt(1), resultados.getString(2), resultados.getString(5),
						resultados.getString(4), atraccionDePromo.buscar(resultados.getString(2)), resultados.getString(6), resultados.getString(7) );
			}
			if (resultados.getString(3).equalsIgnoreCase("absoluta")) {
				return new PromoPorcentual(resultados.getInt(1), resultados.getString(2), resultados.getString(5),
						Double.parseDouble(resultados.getString(4)), atraccionDePromo.buscar(resultados.getString(2)), resultados.getString(6), resultados.getString(7) );
			}

		return null;
	}



}
