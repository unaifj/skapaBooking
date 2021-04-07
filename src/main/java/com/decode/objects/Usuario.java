package com.decode.objects;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {
	private String nomUsuario;
	private String correo;
	private String contrasenya;
	
	public Usuario(String nomUsuario, String correo, String contrasenya) {
		super();
		this.nomUsuario = nomUsuario;
		this.correo = correo;
		this.contrasenya = contrasenya;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public String toString() {
		return "Usuario [nomUsuario=" + nomUsuario + ", correo=" + correo + ", contrasenya=" + contrasenya + "]";
	}
	

}
