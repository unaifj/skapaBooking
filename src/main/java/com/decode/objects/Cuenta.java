package com.decode.objects;

public class Cuenta {
	private String tipoDeCuenta;
	private long cuentaBancaria;
	private String titular;
	private String fechaCaducidad;
	private int CVV;
	
	public Cuenta(String tipoDeCuenta, long cuentaBancaria, String titular, String fechaCaducidad, int cVV) {
		super();
		this.tipoDeCuenta = tipoDeCuenta;
		this.cuentaBancaria = cuentaBancaria;
		this.titular = titular;
		this.fechaCaducidad = fechaCaducidad;
		this.CVV = cVV;
	}

	public String getTipoDeCuenta() {
		return tipoDeCuenta;
	}

	public void setTipoDeCuenta(String tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}

	public long getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(long cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}

	@Override
	public String toString() {
		return "Cuenta [tipoDeCuenta=" + tipoDeCuenta + ", cuentaBancaria=" + cuentaBancaria + ", titular=" + titular
				+ ", fechaCaducidad=" + fechaCaducidad + ", CVV=" + CVV + "]";
	}
	

}
