package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.ProvedorDeConeccion;
import model.Atraccion;
import model.Promo;

public class AtraccionesDePromoDAOImpl {

	private PreparedStatement consulta(String sql) throws SQLException {

		Connection conn = ProvedorDeConeccion.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		return statement;
	}

	public int agregar(Promo promocion) {
		int cambios = 0;
		try {
			for (Atraccion elemento : promocion.getAtracciones()) {

				PreparedStatement statement = this.consulta
						("INSERT INTO promocion_atraccion" + "(  nombre_promo , id_atraccion) VALUES ( ?, ?)");
				statement.setString(1, promocion.getNombreDeProducto());
				statement.setInt(2, elemento.getIdProducto());
				cambios = statement.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return cambios;

	}

	public int modificar(Promo promocion) {
		int cambios = 0;
		cambios += this.borrar(promocion);
		cambios += this.agregar(promocion);
		return cambios;
	}

	protected int borrar(Promo promocion) {
		int cambios = 0;
		try {
			PreparedStatement statement = this.consulta("DELETE FROM promocion_atraccion WHERE nombre_promo =?");
			statement.setString(1, promocion.getNombreDeProducto());
			cambios = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return cambios;
	}

	public ArrayList<Atraccion> buscar(String nombre) {
		AtraccionDAOImpl atraccion = new AtraccionDAOImpl();
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		try {
			PreparedStatement statement = this.consulta("SELECT atraccion.nombre" + " FROM promocion_atraccion"
					+ " JOIN atraccion ON atraccion.id_atraccion = promocion_atraccion.id_atraccion"
					+ " WHERE nombre_promo = ?");
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();
			while (resultados.next()) {
				atracciones.add(atraccion.buscar(resultados.getString(1)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return atracciones;
	}

}
