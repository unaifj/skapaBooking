package com.decode.objects;
/**
 * Clase Pago clase objeto para la administracion de los pagos
 * @author En documentacion :Anton
 *
 */
public class Pago {
	private double cantidad;
	private Usuario usuarioEmisor;
	private Usuario usuarioReceptor;
	/**
	 * Constructor de Pago
	 * @param Double cantidad para saber la cantidad del pago a realizar
	 * @param Obtenemos un usuarioEmisor de la clase Usuario para saber quien realizara el pago
	 * @param Obtenemos un usuarioReceptor de la clase Usuario para saber quien recibira el pago
	 */
	public Pago(double cantidad, Usuario usuarioEmisor, Usuario usuarioReceptor) {
		super();
		this.cantidad = cantidad;
		this.usuarioEmisor = usuarioEmisor;
		this.usuarioReceptor = usuarioReceptor;
	}
	/**
	 * Devuelve la cantidad del Pago
	 * @return Double con la cantidad del Pago
	 */
	public double getCantidad() {
		return cantidad;
	}
	/**
	 * Para cambiar la cantidad de la clase Pago
	 * @param Double con la nueva cantidad de la clase Pago
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * Devuelve usuarioEmisor del Pago
	 * @return usuarioEmisor con la persona encargada de realizar el pago de la clase Pago
	 */
	public Usuario getUsuarioEmisor() {
		return usuarioEmisor;
	}
	/**
	 * Para cambiar el usuarioEmisor del Pago
	 * @param Usuario usuarioEmisor con el nuevo usuarioEmisor de la clase Pago
	 */
	public void setUsuarioEmisor(Usuario usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}
	/**
	 * Devuelve usuarioReceptor del Pago
	 * @return usuarioReceptor con la persona encargada de recibir el pago de la clase Pago
	 */
	public Usuario getUsuarioReceptor() {
		return usuarioReceptor;
	}
	/**
	 * Para cambiar el usuarioReceptor del Pago
	 * @param Usuario usuarioReceptor con el nuevo usuarioReceptor de la clase Pago
	 */
	public void setUsuarioReceptor(Usuario usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}
	/**
	 * toString de la clase Pago
	 */
	@Override
	public String toString() {
		return "Pago [cantidad=" + cantidad + ", usuarioEmisor=" + usuarioEmisor + ", usuarioReceptor="
				+ usuarioReceptor + "]";
	}

}



	