package com.decode.objects;

import java.util.Calendar;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Reserva {
	
	private Usuario usuario;
	private Calendar fechaEntrada;
	private Calendar fechaSalida;
	private int numPersonas;
	private String metodoPago;
	private Anuncio anuncio;
	
	public Reserva(Usuario usuario, String metodoPago, Anuncio anuncio, Calendar fechaEntrada, Calendar fechaSalida, int numPersonas) {
		super();
		this.usuario = usuario;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.numPersonas = numPersonas;
	}
	
	public Reserva() {
		super();
		this.usuario = null;
		this.fechaEntrada = null;
		this.fechaSalida = null;
		this.numPersonas = 0;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Calendar getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Calendar fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	@Override
	public String toString() {
		return "Reserva [usuario=" + usuario + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida
				+ ", numPersonas=" + numPersonas + "]";
	}
	
	
	
	
	
	

}
