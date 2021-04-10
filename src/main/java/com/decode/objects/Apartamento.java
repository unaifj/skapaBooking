package com.decode.objects;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Apartamento {
	private String titulo;
	private String descripcion;
	private String localizacion;
	private int precioNoche;
	private int precioTotal;
	private boolean disponibilidad;
	private int numPersonas;
	
	public Apartamento(String titulo, String descripcion, String localizacion, int precioNoche, int precioTotal,
			boolean disponibilidad, int numPersonas) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.localizacion = localizacion;
		this.precioNoche = precioNoche;
		this.precioTotal = precioTotal;
		this.disponibilidad = disponibilidad;
		this.numPersonas = numPersonas;
	}
	public Apartamento() {
		super();
		this.titulo = "";
		this.descripcion = "";
		this.localizacion = "";
		this.precioNoche = 0;
		this.precioTotal = 0;
		this.disponibilidad = false;
		this.numPersonas = 0;
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
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public int getPrecioNoche() {
		return precioNoche;
	}
	public void setPrecioNoche(int precioNoche) {
		this.precioNoche = precioNoche;
	}
	public int getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
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
		return "Apartamento [titulo=" + titulo + ", descripcion=" + descripcion + ", localizacion=" + localizacion
				+ ", precioNoche=" + precioNoche + ", precioTotal=" + precioTotal + ", disponibilidad=" + disponibilidad
				+ ", numPersonas=" + numPersonas + "]";
	}
	
	

	
	
	

}
