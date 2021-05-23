package com.decode.objects;

/**
 * Clase Cuenta clase objeto para las diferentes cuentas de credito
 * @author En documentacion :Mikel
 *
 */

public class Cuenta {
	private String tipoDeCuenta;
	private long cuentaBancaria;
	private String titular;
	private String fechaCaducidad;
	private int CVV;
	
	/**
	 * Constructor de Cuentan
	 * @param String tipoDeCuenta , para saber de que tipo es la cuenta es la del usuario
	 * @param long cuentaBancaria, el numero de cuenta bancaria del usuario
	 * @param String titular, nombre del titular de la cuenta bancaria
	 * @param Int CVV para saber el cvv de la tarjeta de credito
	 */
	
	public Cuenta(String tipoDeCuenta, long cuentaBancaria, String titular, String fechaCaducidad, int cVV) {
		super();
		this.tipoDeCuenta = tipoDeCuenta;
		this.cuentaBancaria = cuentaBancaria;
		this.titular = titular;
		this.fechaCaducidad = fechaCaducidad;
		this.CVV = cVV;
	}
	/**
	 * Devuelve el tipo de cuenta de la clase cuenta
	 * @return String tipoDeCuenta de la clase cuenta
	 */

	public String getTipoDeCuenta() {
		return tipoDeCuenta;
	}
	/**
	 * Para cambiar el tipo de cuenta de la cuenta bancaria de la clase cuenta
	 * @param  tipo de cuenta con el nuevo tipo de cuenta  de la clase cuenta
	 */
	

	public void setTipoDeCuenta(String tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}
	/**
	 * Devuelve los digitos cuenta bancaria de la clase cuenta
	 * @return float cuentaBancaria de la clase cuenta
	 */
	

	public long getCuentaBancaria() {
		return cuentaBancaria;
	}
	/**
	 * Para cambiar el numero  de la cuenta bancaria de la clase cuenta
	 * @param float cuenta con el nuevo numero de la cuenta bancaria de la clase cuenta
	 */
	

	public void setCuentaBancaria(long cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	/**
	 * Devuelve el nombre del titular de la cuenta de la clase cuenta
	 * @return String nombre del titular de la cuenta
	 */

	public String getTitular() {
		return titular;
	}
	
	/**
	 * Para cambiar el nombre  del titular de la cuenta bancaria de la clase cuenta
	 * @param String nombre con el nuevo nombre del titular del cuenta bancaria
	 */

	public void setTitular(String titular) {
		this.titular = titular;
	}
	/**
	 * Devuelve la fecha de caducidad de la cuenta de la clase cuenta
	 * @return String fecha de caducidad de la cuenta
	 */
	

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	/**
	 * Para cambiar la fecha de caducidad  de la cuenta bancaria de la clase cuenta
	 * @param String fecha de caducidad con la nueva fecha de caducidad de la cuenta bancaria
	 */

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	/**
	 * Devuelve el cvv de la clase Tarjeta de Credito
	 * @return Cvv de la clase Tarjeta de Credito
	 */

	public int getCVV() {
		return CVV;
	}
	
	/**
	 * Para cambiar el cvv de la clase Tarjeta de Credito
	 * @param  cvv con el nuevo valor cvv de la Tarjeta de Credito
	 */

	public void setCVV(int cVV) {
		CVV = cVV;
	}
	/**
	 * toString de la clase Cuenta
	 */

	@Override
	public String toString() {
		return "Cuenta [tipoDeCuenta=" + tipoDeCuenta + ", cuentaBancaria=" + cuentaBancaria + ", titular=" + titular
				+ ", fechaCaducidad=" + fechaCaducidad + ", CVV=" + CVV + "]";
	}
	

}
