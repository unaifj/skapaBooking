package com.decode.objects;

import java.util.Calendar;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Anuncio {
	
	@Join
	private Apartamento apartamento;
	private String titulo;
	private String descripcion;
	private double precioNoche;
	private boolean disponibilidad;
	private int numPersonas;
	
	public Anuncio(Apartamento apartamento, String titulo, String descripcion, double precioNoche, boolean disponibilidad,
			int numPersonas) {
		super();
		this.apartamento = apartamento;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.disponibilidad = disponibilidad;
		this.numPersonas = numPersonas;
	}
	
	public Anuncio() {
		super();
		this.apartamento = null;
		this.titulo = "";
		this.descripcion = "";
		this.precioNoche = 0.0;
		this.disponibilidad = false;
		this.numPersonas = 0;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(int precioNoche) {
		this.precioNoche = precioNoche;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	@Override
	public String toString() {
		return "Anuncio [apartamento=" + apartamento + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", precioNoche=" + precioNoche + ", disponibilidad=" + disponibilidad + ", numPersonas=" + numPersonas
				+ "]";
	}
	
	public boolean comprobarDis(Calendar fechaEntrada, Calendar fechaSalida) {
	
		boolean disponible = true;
		
		if (this.apartamento.getReservas() != null) {
			for (Reserva r : this.apartamento.getReservas()) {
				if (fechaEntrada.after(r.getFechaEntrada()) && fechaEntrada.before(r.getFechaSalida())) {
					disponible = false;
				}else if (fechaSalida.after(r.getFechaEntrada())&& fechaSalida.before(r.getFechaSalida())) {
					disponible = false;
				}
			}
		}
		
		
		return disponible;
	}
	

}
