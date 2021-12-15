package service;

import java.util.LinkedList;

import dao.UsuarioDAOImpl;
import model.Usuario;

public class UsuarioService {
	
	UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
			
	public LinkedList<Usuario> getUsers(){
		return userDAO.dameTodos();
	}
	
	public Usuario create(String nombre, String apellido, String usuario,String contrsenia, int monedas,Double tiempoDisponible, String gusto, String code) {

		Usuario user = new Usuario(usuario , contrsenia, nombre, gusto , monedas, tiempoDisponible);

		if (user.isValid()) {
			userDAO.agregar(user);
		}

		return user;	
		}

}
