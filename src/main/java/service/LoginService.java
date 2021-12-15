package service;

import dao.UsuarioDAOImpl;
import model.Usuario;
import model.nullObejt.NullUser;

public class LoginService {
	UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
	
	public Usuario reload(String username) {
		 Usuario user =userDAO.buscar(username);
		 return user;
	}
	
	public Usuario login(String username, String password) {
		
		Usuario user =userDAO.buscar(username);
		
		if(user == null || !user.verificarContrasenia(password)) {
			user = new NullUser();
		}
		
		return user;
	}

}
