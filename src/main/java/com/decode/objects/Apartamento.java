package com.decode.objects;

import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Apartamento {
	
	private int numHabitaciones;
	private int metrosCuad;
	private Localidad localidad;
	private List<Reserva> reservas;
	
	public Apartamento(int numHabitaciones, int metrosCuad, Localidad localidad) {
		super();
		this.numHabitaciones = numHabitaciones;
		this.metrosCuad = metrosCuad;
		this.localidad = localidad;
	}
	
	public Apartamento() {
		super();
		this.numHabitaciones = 0;
		this.metrosCuad = 0;
		this.localidad = null;
		this.reservas = null;
	}


	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public int getMetrosCuad() {
		return metrosCuad;
	}

	public void setMetrosCuad(int metrosCuad) {
		this.metrosCuad = metrosCuad;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public void setReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	
	
}
