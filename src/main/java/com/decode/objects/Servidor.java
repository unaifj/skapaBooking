package com.decode.objects;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
/**
 * Clase Servidor clase objeto para los diferentes servidores 
 * @author En documentacion :Anton
 *
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Servidor {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT, primaryKey = "true")
	
	private int id;
	private String nomServidor;
	private String correoS;
	private String contrasenyaS;
	private int puerto;
	/**
	 * Constructor de Servidor
	 * @param Int id para saber el id del servidor
	 * @param String nomServidor para saber el nombre del Servidor
	 * @param String correoS para saber el correo del Servidor
	 * @param String contrasenyaS para saber la contraseña del Servidor
	 * @param Int puerto para saber el puerto del Servidor
	 */
	public Servidor(int id, String nomServidor, String correoS, String contrasenyaS, int puerto) {
		super();
		this.id = id;
		this.nomServidor = nomServidor;
		this.correoS = correoS;
		this.contrasenyaS = contrasenyaS;
		this.puerto = puerto;
	}
	/**
	 *Constructor vacio de Servidor
	 */
	public Servidor() {
		super();
		this.id = 0;
		this.nomServidor = "";
		this.correoS = "";
		this.contrasenyaS = "";
		this.puerto = 0;
	}
	/**
	 * Devuelve el id del servidor de la clase Servidor
	 * @return id de la clase Servidor
	 */
	public int getId() {
		return id;
	}
	/**
	 * Para cambiar el id  de la clase Servidor
	 * @param  Int id con el nuevo valor id del Servidor
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Devuelve el nombreServidor del servidor de la clase Servidor
	 * @return nomServidor de la clase Servidor
	 */
	public String getNomServidor() {
		return nomServidor;
	}
	/**
	 * Para cambiar el nombre Servidor  de la clase Servidor
	 * @param  String nomServidor con el nuevo nombre del Servidor
	 */
	public void setNomServidor(String nomServidor) {
		this.nomServidor = nomServidor;
	}
	/**
	 * Devuelve el correo del servidor de la clase Servidor
	 * @return correoS de la clase Servidor
	 */
	public String getCorreoS() {
		return correoS;
	}
	/**
	 * Para cambiar el correo del Servidor  de la clase Servidor
	 * @param  String correoS con el nuevo correo del Servidor
	 */
	public void setCorreoS(String correoS) {
		this.correoS = correoS;
	}
	/**
	 * Devuelve la contrasenya del servidor de la clase Servidor
	 * @return contrasenyaS de la clase Servidor
	 */
	public String getContrasenyaS() {
		return contrasenyaS;
	}
	/**
	 * Para cambiar la contraseña del Servidor de la clase Servidor
	 * @param  String contrasenyaS con la nueva contrasenya del Servidor
	 */
	public void setContrasenyaS(String contrasenyaS) {
		this.contrasenyaS = contrasenyaS;
	}
	/**
	 * Devuelve el puerto del servidor de la clase Servidor
	 * @return puerto de la clase Servidor
	 */
	public int getPuerto() {
		return puerto;
	}
	/**
	 * Para cambiar el puerto del Servidor de la clase Servidor
	 * @param  Int puerto con el nuevo puerto del Servidor
	 */
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
	/**
	 * toString de la clase Servidor
	 */
	@Override
	public String toString() {
		return "Servidor [id=" + id + ", nomServidor=" + nomServidor + ", correoS=" + correoS + ", contrasenyaS="
				+ contrasenyaS + ", puerto=" + puerto + "]";
	}
	
	
	
	
	

}
