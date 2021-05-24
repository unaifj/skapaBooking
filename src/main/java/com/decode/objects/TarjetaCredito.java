package com.decode.objects;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
/**
 * Clase TarjetaCredito clase objeto para las diferentes tarjetas de credito
 * @author En documentacion :Anton
 *
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class TarjetaCredito {
	
	@ForeignKey
	private int id;
	private int numTarjeta;
	private int fecha;
	private int cvv;
	/**
	 * Constructor de Tarjeta de Credito
	 * @param Obtenemos un usuario de la clase Usuario
	 * @param Int numTarjeta para saber el numero de la tarjeta
	 * @param Int fecha para saber la fecha de caducidad de la tarjeta
	 * @param Int CVV para saber el cvv de la tarjeta de credito
	 */
	public TarjetaCredito(int id, int numTarjeta, int fecha, int cvv) {
		super();
		this.id = id;
		this.numTarjeta = numTarjeta;
		this.fecha = fecha;
		this.cvv = cvv;
	}
	/**
	 *Constructor vacio de Tarjeta de Credito
	 */
	public TarjetaCredito() {
		super();
		this.id = 0;
		this.numTarjeta = 0;
		this.fecha = 0;
		this.cvv = 0;
	}
	/**
	 * Devuelve el usuario de la clase Usuario
	 * @return Usuario de la clase usuario
	 */
	public int getId() {
		return id;
	}
	/**
	 * Para cambiar el usuario de la clase Usuario
	 * @param  Usuario con el nuevo valor del Usuario
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Devuelve el numero de Tarjeta
	 * @return numTarjeta Int de la tarjeta de credito
	 */
	public int getNumTarjeta() {
		return numTarjeta;
	}
	/**
	 * Para cambiar el numero de la tarjeta de la clase Tarjeta Credito
	 * @param  numTarjeta con el nuevo numero de Tarjeta de Credito
	 */
	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	/**
	 * Devuelve la fecha de la clase Tarjeta de Credito
	 * @return fecha de la clase Tarjeta de Credito
	 */
	public int getFecha() {
		return fecha;
	}
	/**
	 * Para cambiar la fecha de la clase Tarjeta de credito
	 * @param  fecha Int con la nueva fecha
	 */
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	/**
	 * Devuelve el cvv de la clase Tarjeta de Credito
	 * @return Cvv de la clase Tarjeta de Credito
	 */
	public int getCvv() {
		return cvv;
	}
	/**
	 * Para cambiar el cvv de la clase Tarjeta de Credito
	 * @param  cvv con el nuevo valor cvv de la Tarjeta de Credito
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	/**
	 * toString de la clase Tarjeta de Credito
	 */
	@Override
	public String toString() {
		return "TarjetaCredito [id=" + id + ", numTarjeta=" + numTarjeta + ", fecha=" + fecha + ", cvv=" + cvv
				+ "]";
	}
	
	
	

	
}
