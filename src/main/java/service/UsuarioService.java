package service;

import dao.UsuarioDAOImpl;
import model.Usuario;

public class UsuarioService {
	
	public Usuario create(String nombre, String apellido, String usuario,String contrsenia, int monedas,Double tiempoDisponible, String gusto, String code) {

		Usuario user = new Usuario(usuario , contrsenia, nombre, gusto , monedas, tiempoDisponible);

		if (user.isValid()) {
			UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
			userDAO.agregar(user);
		}

		return user;	
		}

}
