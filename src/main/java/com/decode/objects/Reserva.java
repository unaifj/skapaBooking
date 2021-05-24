package com.decode.objects;

import java.util.Calendar;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
/**
 * Clase Reserva clase objeto para las diferentes reservas
 * @author En documentacion :Anton
 *
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Reserva {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT, primaryKey = "true")
	private int id;
	@ForeignKey
	private int idUsuario;
	private int idApartamento;
	private Calendar fechaEntrada;
	private Calendar fechaSalida;
	private int numPersonas;
	private String metodoPago;
	private int numTarjeta;
	/**
	 * Constructor de Reserva
	 * @param Obtenemos un usuario de la clase Usuario
	 * @param String metodoPago para saber el metodo de pago que se va a utilizar en la reserva
	 * @param Calendar fechaEntrada para saber la fecha de Entrada de la Reserva
	 * @param Calendar fechaSalida para saber la fecha de Salida de la Reserva
	 * @param Int numPersonas para saber el numPersonas de la Reserva
	 */
	public Reserva(int idUsuario, int idApartamento, String metodoPago, Calendar fechaEntrada, Calendar fechaSalida, int numPersonas, int numTarjeta) {
		super();
		this.idUsuario = idUsuario;
		this.idApartamento = idApartamento;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.numPersonas = numPersonas;
		this.numTarjeta=numTarjeta;
	}
	/**
	 *Constructor vacio de Reserva
	 */
	public Reserva() {
		super();
		this.idUsuario = 0;
		this.idApartamento=0;
		this.fechaEntrada = null;
		this.fechaSalida = null;
		this.numPersonas = 0;
		this.numTarjeta=0;
	}
	/**
	 * Devuelve el id de la Reserva
	 * @return Int con el id de la Reserva
	 */
	public int getId() {
		return id;
	}
	/**
	 * Para cambiar el id de la Reserva
	 * @param  Int con el nuevo id de la Reserva
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Devuelve el usuario de la clase Usuario
	 * @return Usuario de la clase usuario
	 */
	public int getIdApartamento() {
		return idApartamento;
	}
	/**
	 * Para cambiar el usuario de la clase Usuario
	 * @param  Usuario con el nuevo valor del Usuario
	 */
	public void setIdApartamento(int idApartamento) {
		this.idApartamento = idApartamento;
	}
	/**
	 * Devuelve el usuario de la clase Usuario
	 * @return Usuario de la clase usuario
	 */
	public int idUsuario() {
		return idUsuario;
	}
	/**
	 * Para cambiar el usuario de la clase Usuario
	 * @param  Usuario con el nuevo valor del Usuario
	 */
	public void setidUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * Devuelve la fecha de Entrada de la clase Reserva
	 * @return fecha de Entrada de la clase Reserva
	 */
	public Calendar getFechaEntrada() {
		return fechaEntrada;
	}
	/**
	 * Para cambiar la fecha de Entrada de la clase Reserva
	 * @param  fechaEntrada Calendar con la nueva fecha de Entrada
	 */
	public void setFechaEntrada(Calendar fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	/**
	 * Devuelve la fecha de Salida de la clase Reserva
	 * @return fecha de Salida de la clase Reserva
	 */
	public Calendar getFechaSalida() {
		return fechaSalida;
	}
	/**
	 * Para cambiar la fecha de Salida de la clase Reserva
	 * @param  fechaSalida Calendar con la nueva fecha de Salida
	 */
	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	/**
	 * Devuelve numero de Personas de la clase Reserva
	 * @return numPersonas de la clase Reserva
	 */
	public int getNumPersonas() {
		return numPersonas;
	}
	/**
	 * Para cambiar el numero de personas de la clase Reserva
	 * @param  numPersonas Int con el nuevo numero de Personas de la clase Reserva
	 */
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	/**
	 * toString de la clase Reserva
	 */
	/**
	 * Devuelve el id de la Reserva
	 * @return Int con el id de la Reserva
	 */
	public int getNumTarjeta() {
		return numTarjeta;
	}
	/**
	 * Para cambiar el id de la Reserva
	 * @param  Int con el nuevo id de la Reserva
	 */
	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", idUsuario=" + idUsuario + ", idApartamento=" + idApartamento + ", fechaEntrada="
				+ fechaEntrada + ", fechaSalida=" + fechaSalida + ", numPersonas=" + numPersonas + ", metodoPago="
				+ metodoPago + ", numTarjeta=" + numTarjeta + "]";
	}
	
	

	
	
	
	
	
	

}
