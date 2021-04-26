package com.decode.pago;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import com.decode.objects.Usuario;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class TarjetaCredito {
	
	private Usuario usuario;
	private int numTarjeta;
	private int fecha;
	private int cvv;
	
	public TarjetaCredito(Usuario usuario, int numTarjeta, int fecha, int cvv) {
		super();
		this.usuario = usuario;
		this.numTarjeta = numTarjeta;
		this.fecha = fecha;
		this.cvv = cvv;
	}
	
	public TarjetaCredito() {
		super();
		this.usuario = null;
		this.numTarjeta = 0;
		this.fecha = 0;
		this.cvv = 0;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "TarjetaCredito [usuario=" + usuario + ", numTarjeta=" + numTarjeta + ", fecha=" + fecha + ", cvv=" + cvv
				+ "]";
	}
	
	
	

	
}
