package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Atraccion;

public class AtraccionDAOImpl extends GenericDAO<Atraccion> {

	@Override
	public int agregar(Atraccion atraccion) {
		int cambios = 0;
		try {
			PreparedStatement statement = super.consulta("INSERT INTO atraccion" + 
		"(  nombre, tipo, costo, cupo, duracion, descripcion, url) VALUES (?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, atraccion.getNombreDeProducto());
			statement.setString(2, atraccion.getTipoDeProducto());
			statement.setInt(3, atraccion.getCostoTotal());
			statement.setInt(4, atraccion.getCupo());
			statement.setDouble(5, atraccion.getTimepoDeProducto());
			statement.setString(6, atraccion.getDescripcion());
			statement.setString(7, atraccion.getRefImg());

			cambios += statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return cambios;
	}

	@Override
	public int modificar(Atraccion atraccion) {
		int cambios = 0;
		try {
			PreparedStatement statement = super.consulta("UPDATE atraccion SET nombre =?, tipo =?, costo =?," + 
					"cupo =?, duracion =?, descripcion =?, url=? WHERE id_atraccion =?");
			statement.setString(1, atraccion.getNombreDeProducto());
			statement.setString(2, atraccion.getTipoDeProducto());
			statement.setInt(3, atraccion.getCostoTotal());
			statement.setInt(4, atraccion.getCupo());
			statement.setDouble(5, atraccion.getTimepoDeProducto());
			statement.setString(6, atraccion.getDescripcion());
			statement.setString(7, atraccion.getRefImg());
			statement.setInt(8, atraccion.getIdProducto());

			cambios = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return cambios;
	}



	@Override
	public String consultaDeContarTodos() {
		return "SELECT count(1) AS total FROM atraccion";
	}

	@Override
	protected String consultaDeDameTodos() {
		return "SELECT * FROM atraccion WHERE borrar = 0";
	}

	@Override
	protected String consultaDeBuscar() {
		return "SELECT * FROM atraccion WHERE nombre =?";
	}
	@Override
	protected Atraccion convertirT(ResultSet resultados) throws SQLException {

			return new Atraccion(resultados.getInt(1), resultados.getString(2), resultados.getInt(4),
								resultados.getDouble(6), resultados.getInt(5), resultados.getString(3), 
								resultados.getString(7), resultados.getString(8));
	}

	@Override
	protected String consultaDeBorrar() {
		return "UPDATE atraccion SET borrar =?  WHERE nombre =?";
	}
}
