package com.decode.objects;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

/**
 * Clase Opinion clase objeto para las diferentes opiniones de los usuarios
 * @author En documentacion :Mikel
 *
 */


@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Opinion {

	private Usuario usuario;
	private String titulo;
	private String descripcion;
	private float puntuacion;
	
	/**
	 * Constructor de Opinion
	 * @param Obtenemos un usuario de la clase Usuario
	 * @param String titulo para saber el titulo de la opinion
	 * @param String descripcion, una breve descripcion de un apartamento
	 * @param float puntuacion, numero que puede ser decimal para saber la puntuacion del apartamento
	 */
	
	public Opinion(Usuario usuario, String titulo, String descripcion, float puntuacion) {
		super();
		this.usuario = usuario;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.puntuacion = puntuacion;
	}
	/**
	 * Devuelve el usuario de la clase Usuario
	 * @return Usuario de la clase usuario
	 */
	
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * Para cambiar el usuario de la clase Usuario
	 * @param  Usuario con el nuevo valor del Usuario
	 */

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * Devuelve el titulo de la opinion
	 * @return titulo String de la opinion
	 */

	public String getTitulo() {
		return titulo;
	}
	/**
	 * Para cambiar el titulo de la opinion de la clase Opinion
	 * @param  titulo String con el nuevo titulo de la opinion
	 */

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * Devuelve la descripcion de la opinion
	 * @return descripcion String de la opinion
	 */

	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Para cambiar la descripcion de la opinion de la clase Opinion
	 * @param  descripcion String con la nuevo descripcion de la opinion
	 */

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Devuelve la puntuacion de la opinion
	 * @return puntuacion float de la opinion
	 */

	public float getPuntuacion() {
		return puntuacion;
	}
	
	/**
	 * Para cambiar la puntuacion de la opinion de la clase Opinion
	 * @param  puntuacion float con la nuevo puntuacion de la opinion
	 */
	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}
	/**
	 * toString de la clase Opinion
	 */

	@Override
	public String toString() {
		return "Opinion [usuario=" + usuario + ", titulo=" + titulo + ", descripcion=" + descripcion + ", puntuacion="
				+ puntuacion + "]";
	}
	
	
	
	


}
