package com.decode.objects;

public class Pago {
	private double cantidad;
	private Usuario usuarioEmisor;
	private Usuario usuarioReceptor;
	
	public Pago(double cantidad, Usuario usuarioEmisor, Usuario usuarioReceptor) {
		super();
		this.cantidad = cantidad;
		this.usuarioEmisor = usuarioEmisor;
		this.usuarioReceptor = usuarioReceptor;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Usuario getUsuarioEmisor() {
		return usuarioEmisor;
	}

	public void setUsuarioEmisor(Usuario usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}

	public Usuario getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(Usuario usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}

	@Override
	public String toString() {
		return "Pago [cantidad=" + cantidad + ", usuarioEmisor=" + usuarioEmisor + ", usuarioReceptor="
				+ usuarioReceptor + "]";
	}

}



	