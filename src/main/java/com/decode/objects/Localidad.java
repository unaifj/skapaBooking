package com.decode.objects;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
/**
 * Clase Localidad clase objeto para las diferentes localidades
 * @author En documentacion :Anton
 *
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Localidad {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT, primaryKey = "true")
	private int id;
	private String provincia;
	private String municipio;
	private int cp;
	private String direccion;
	/**
	 * Constructor de Reserva
	 * @param String provincia para saber la provincia de la clase Localidad
	 * @param String municipio para saber el municipio de la clase Localidad
	 * @param Int cp para saber el codigo posta de la clase Localidad
	 * @param String direccion para saber la direccion de la clase Localidad
	 */
	public Localidad(String provincia, String municipio, int cp, String direccion) {
		super();
		this.provincia = provincia;
		this.municipio = municipio;
		this.cp = cp;
		this.direccion = direccion;
	}
	/**
	 *Constructor vacio de Localidad
	 */
	public Localidad() {
		super();
		this.provincia = "";
		this.municipio = "";
		this.cp = 00000;
		this.direccion = "";
	}
	/**
	 * Devuelve el id de la Localidad
	 * @return Int con el id de la Localidad
	 */
	public int getId() {
		return id;
	}
	/**
	 * Para cambiar el id de la Localidad
	 * @param  Int con el nuevo id de la Localidad
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Devuelve la provincia de la clase Localidad
	 * @return String con el provincia de la Localidad
	 */
	public String getProvincia() {
		return provincia;
	}
	/**
	 * Para cambiar la provincia de la Localidad
	 * @param provincia String con la provincia de la Localidad
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	/**
	 * Devuelve el municipio de la clase Localidad
	 * @return String con el municipio de la Localidad
	 */
	public String getMunicipio() {
		return municipio;
	}
	/**
	 * Para cambiar el municipio de la Localidad
	 * @param municipio String con el municipio de la Localidad
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	/**
	 * Devuelve numero de codigo postal de la clase Localidad
	 * @return cp de la clase Localidad
	 */
	public int getCp() {
		return cp;
	}
	/**
	 * Para cambiar el numero de codigo postal de la clase Localidad
	 * @param  cp Int con el nuevo codigo postal de la clase Localidad
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}
	/**
	 * Devuelve la direccion de la clase Localidad
	 * @return String con la direccion de la Localidad
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Para cambiar la direccin de la Localidad
	 * @param direccion String con el direccion de la Localidad
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * toString de la clase Localidad
	 */
	@Override
	public String toString() {
		return "Localidad [id=" + id + ", provincia=" + provincia + ", municipio=" + municipio + ", cp=" + cp
				+ ", direccion=" + direccion + "]";
	}
	
	

	
	

}
