package com.decode.objects;

import java.util.Calendar;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Anuncio {
	
	private static int cont = 0;
	
	@PrimaryKey
	private int id;
	private int idUsuario;
	@ForeignKey
	private Apartamento apartamento;
	private String titulo;
	private String descripcion;
	private double precioNoche;
	private boolean disponibilidad;
	private int numPersonas;
	private String img;
	

	public Anuncio(int idUsuario, Apartamento apartamento, String titulo, String descripcion,
			double precioNoche, boolean disponibilidad, int numPersonas, String img) {
		super();
		this.id = cont;
		this.idUsuario = idUsuario;
		this.apartamento = apartamento;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.disponibilidad = disponibilidad;
		this.numPersonas = numPersonas;
		this.img = img;
		cont++;
	}

	







	public int getId() {
		return id;
	}









	public void setId(int id) {
		this.id = id;
	}









	public int getIdUsuario() {
		return idUsuario;
	}









	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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









	public void setPrecioNoche(double precioNoche) {
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









	public String getImg() {
		return img;
	}









	public void setImg(String img) {
		this.img = img;
	}









	@Override
	public String toString() {
		return "Anuncio [id=" + id + ", idUsuario=" + idUsuario + ", apartamento=" + apartamento + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + ", precioNoche=" + precioNoche + ", disponibilidad=" + disponibilidad
				+ ", numPersonas=" + numPersonas + ", img=" + img + "]";
	}









	public boolean comprobarDis(Calendar fechaEntrada, Calendar fechaSalida) {
	
		boolean disponible = true;
		if (apartamento.getReservas() != null) {
			for (Reserva r : apartamento.getReservas()) {
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
