package model.nullObejt;

import model.Usuario;

public class NullUser extends Usuario {

	public NullUser() {
		super("", "", "", "", 0, 0);
	}
	
	@Override
	public boolean isNull() {
		return true;
	}
}
