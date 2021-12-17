package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAOImpl extends GenericDAO<Usuario> {

	@Override
	public int agregar(Usuario visitante) {
		int cambios = 0;
		try {
			PreparedStatement statement = super.consulta("INSERT INTO visitante"
					+ "(nombre, apellido, usuario, contrasenia, presupuesto, tiempo_disponible, gusto, admin ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, visitante.getNombre());
			statement.setString(2, visitante.getApellido());
			statement.setString(3, visitante.getUsuario());
			statement.setString(4, visitante.getContrasenia());
			statement.setInt(5, visitante.getPresupuesto());
			statement.setDouble(6, visitante.getTiempoDisponible());
			statement.setString(7, visitante.getGusto());
			statement.setBoolean(8, visitante.isAdm());
			cambios += statement.executeUpdate();
			ItinerarioDAOImpl itinerario =new ItinerarioDAOImpl(); 
			cambios += itinerario.agregar(visitante);
		} catch (Exception e) {
			System.out.println(e);
		}
		return cambios;
	}

	@Override
	public int modificar(Usuario visitante) {
		int cambios = 0;
		try {
			PreparedStatement statement = super.consulta("UPDATE visitante SET nombre =?, apellido =?, contrasenia =?,"
					+ "presupuesto =?, tiempo_disponible =?, gusto=?, admin=? WHERE usuario =?");
			statement.setString(1, visitante.getNombre());
			statement.setString(2, visitante.getApellido());
			statement.setString(3, visitante.getContrasenia());
			statement.setInt(4, visitante.getPresupuesto());
			statement.setDouble(5, visitante.getTiempoDisponible());
			statement.setString(6, visitante.getGusto());
			statement.setBoolean(7, visitante.isAdm());
			statement.setString(8, visitante.getUsuario());
			cambios = statement.executeUpdate();
			ItinerarioDAOImpl itinerario =new ItinerarioDAOImpl(); 
			cambios += itinerario.modificar(visitante);
		} catch (Exception e) {
			System.out.println(e);
		}
		return cambios;
	}

	@Override
	public String consultaDeContarTodos() {
		return "SELECT count(1) AS total FROM visitante";
	}

	@Override
	protected String consultaDeDameTodos() {
		return "SELECT * FROM visitante WHERE borrar = 0";
	}

	@Override
	protected String consultaDeBuscar() {
		return "SELECT * FROM visitante WHERE usuario =?";
	}

	@Override
	protected Usuario convertirT(ResultSet resultados) throws SQLException {

			return new Usuario(resultados.getString(1), resultados.getString(2), resultados.getString(3),
					resultados.getString(4), resultados.getInt(5), resultados.getDouble(6), resultados.getString(7), resultados.getString(8));

	}

	@Override
	protected String consultaDeBorrar() {
		return "UPDATE visitante SET borrar =?  WHERE usuario =?";
	}
}
