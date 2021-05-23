package com.decode.objects;

import java.util.List;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

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
	
	public Apartamento(int numHabitaciones, int metrosCuad, Localidad localidad, List<Reserva> reservas) {
		super();
		this.id = cont;
		this.numHabitaciones = numHabitaciones;
		this.metrosCuad = metrosCuad;
		this.localidad = localidad;
		this.reservas = reservas;
		cont++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Apartamento [id=" + id + ", numHabitaciones=" + numHabitaciones + ", metrosCuad=" + metrosCuad
				+ ", localidad=" + localidad + ", reservas=" + reservas + "]";
	}
	
	
	
	
	
	
	
	
}
