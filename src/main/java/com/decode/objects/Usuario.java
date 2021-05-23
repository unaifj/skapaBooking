package com.decode.objects;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {
	
	private static int cont = 0;
	
	private int id;
	@PrimaryKey
	private String nomUsuario;
	private String correo;
	private String contrasenya;
	private String nombre;
	private String apellidos;
	
	public Usuario(String nomUsuario, String correo, String contrasenya) {
		super();
		this.id = cont;
		this.nomUsuario = nomUsuario;
		this.correo = correo;
		this.contrasenya = contrasenya;
		cont++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomUsuario=" + nomUsuario + ", correo=" + correo + ", contrasenya="
				+ contrasenya + "]";
	}
	

	
	

}
