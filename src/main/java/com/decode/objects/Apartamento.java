package com.decode.objects;

import java.util.List;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
/**
 * Clase Anuncio clase objeto para las diferentes anuncios
 * @author En documentacion :
 *
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Apartamento {
	private static int cont = 0;
	
	@PrimaryKey
	private int id;
	private int numHabitaciones;
	private int metrosCuad;
	@ForeignKey
	private Localidad localidad;
	@ForeignKey
	private List<Reserva> reservas;
	
	
	/**
	 * Constructor de Apartamento
	 * @param Int id para establecer una id unica a cada apartamento
	 * @param Int numero de habitaciones del apartamento
	 * @param Int metros cuadrados disponibles
	 * @param Localidad establecemos la localidad donde se encuentra
	 * @param List<Reserva> listamos las reservas asociadas a el apartamento
	
	 */

	
	public Apartamento(int numHabitaciones, int metrosCuad, Localidad localidad, List<Reserva> reservas) {
		super();
		this.id = cont;
		this.numHabitaciones = numHabitaciones;
		this.metrosCuad = metrosCuad;
		this.localidad = localidad;
		this.reservas = reservas;
		cont++;
	}
	
	/**
	 * Devuelve el id del apartamento
	 * @return Int id del apartamento
	 */

	public int getId() {
		return id;
	}
	
	/**
	 * Establece el id del apartemnto
	 * @param Int id del apartamento
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Devuelve el numero de habitaciones
	 * @return Int numer de habitaciones
	 * 
	 **/

	public int getNumHabitaciones() {
		return numHabitaciones;
	}
	
	/**
	 * Establece el numero de habitaciones
	 *  * @param Int id del numero de habitaciones
	 */

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	
	/**
	 * Devuelve los metros cuadrados
	 * @return Int metros cuadrados
	 * 
	 **/

	public int getMetrosCuad() {
		return metrosCuad;
	}
	
	/**
	 * Establece los metros cuadrados
	 *  * @param Int metros cuadrados
	 */

	public void setMetrosCuad(int metrosCuad) {
		this.metrosCuad = metrosCuad;
	}
	
	/**
	 * Devuelve la localidad de el aparatmento
	 * @return Localidad de el apartamento
	 * 
	 **/

	public Localidad getLocalidad() {
		return localidad;
	}
	
	/**
	 * Establece la localidad
	 *  * @param Localidad del apartamento
	 */

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	/**
	 * Devuelve una lista con las reservas
	 * @return List<Reserva> lista de reservas asociadas
	 * 
	 **/
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	/**
	 * Establece la lista de reservas
	 *  * @param List<Reserva> del apartamento
	 */

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	
	/**
	 * toString de la clase Apartamento
	 */
	@Override
	public String toString() {
		return "Apartamento [id=" + id + ", numHabitaciones=" + numHabitaciones + ", metrosCuad=" + metrosCuad
				+ ", localidad=" + localidad + ", reservas=" + reservas + "]";
	}
	
	
	
	
	
	
	
	
}
