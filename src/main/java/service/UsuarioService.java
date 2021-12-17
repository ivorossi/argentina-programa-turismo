package service;

import java.util.LinkedList;
import dao.UsuarioDAOImpl;
import model.Usuario;

public class UsuarioService {
	
	private UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
			
	public LinkedList<Usuario> getUsers(){
		return this.userDAO.dameTodos();
	}
	
	public Usuario create(String nombre, String apellido, String usuario,String contrsenia, int monedas,Double tiempoDisponible, String gusto, String code) {
		

		Usuario user = new Usuario(nombre, apellido, usuario , contrsenia,  monedas, tiempoDisponible, gusto, code);

		if (user.isValid()) {
			this.userDAO.agregar(user);
		}

		return user;	
		}

	public void eliminarUsuario(String usuario) {
		this.userDAO.borrar(usuario);
	}

	public Usuario buscar(String nombre) {
		return this.userDAO.buscar(nombre);
	}

	public Usuario modificar(String nombre, String apellido, String userName, String password, Integer presupuesto,
			Double tiempo, String gusto, String adm) {
		Usuario user = new Usuario(nombre, apellido, userName, password,  presupuesto, tiempo , gusto, adm);
		if (user.isValid()) {
		this.userDAO.modificar(user);
		}
		return user;
	}

}
