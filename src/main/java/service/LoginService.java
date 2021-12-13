package service;

import dao.UsuarioDAOImpl;
import model.Usuario;
import model.nullObejt.NullUser;

public class LoginService {
	
	public Usuario login(String username, String password) {
		
		UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
		Usuario user =userDAO.buscar(username);
		
		if(user == null || !user.verificarContrasenia(password)) {
			user = new NullUser();
		}
		
		return user;
	}

}
