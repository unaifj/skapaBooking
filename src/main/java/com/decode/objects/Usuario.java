package com.decode.objects;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
/**
 * Clase Usuario clase objeto para los posibles usuarios de nuestra aplicacion
 * @author En documentacion :Anton
 *
 */
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
	/**
	 * Constructor de Usuario
	 * @param String nomUsuario para saber el Nombre del Usuario
	 * @param String correo para saber el Correo del Usuario
	 * @param String contrasenya para saber la Contraseña del Usuario
	 */
	public Usuario(String nomUsuario, String correo, String contrasenya) {
		super();
		this.id = cont;
		this.nomUsuario = nomUsuario;
		this.correo = correo;
		this.contrasenya = contrasenya;
		cont++;
	}
	/**
	 * Devuelve el id del Usuario
	 * @return Int con el id del Usuario
	 */
	public int getId() {
		return id;
	}
	/**
	 * Para cambiar el id del Usuario
	 * @param  Int con el nuevo id del Usuario
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Devuelve el nombre del Usuario para iniciar sesion
	 * @return String con el nombre del Usuario
	 */
	public String getNomUsuario() {
		return nomUsuario;
	}
	/**
	 * Para cambiar el nombre del Usuario
	 * @param nomUsuario String con el nuevo nombre del Usuario
	 */
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	/**
	 * Devuelve el correo electronico del Usuario
	 * @return correo String con el correo electronico del Usuario
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Para cambiar el correo electronico del Usuario
	 * @param correo String con el nuevo correo electronico del Usuario
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * Devuelve la contraseña del Usuario
	 * @return String con la contraseña del Usuario
	 */
	public String getContrasenya() {
		return contrasenya;
	}
	/**
	 * Para cambiar la contrasenya del Usuario
	 * @param contrasenya String con la nueva contraseña del usuario
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	/**
	 * Devuelve el nombre del Usuario
	 * @return String con el nombre nuevo del Usuario
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Para cambiar el nombre del Usuario
	 * @param nombre String con el nuevo nombre de usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve los apellidos del Usuario
	 * @return String con los apellidos del Usuario
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Para cambiar los apellidos del Usuario
	 * @param apellidos String con los nuevos apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * toString de la clase Usuario
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomUsuario=" + nomUsuario + ", correo=" + correo + ", contrasenya="
				+ contrasenya + "]";
	}
	

	
	

}
