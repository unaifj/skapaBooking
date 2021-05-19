package com.decode.mockito;

public enum Portion {
	SMALL(1), MEDIUM(2);

	private int tipo;

	private Portion(int tipo) {
		this.tipo = tipo;
	}

	public int tipo() {
		return tipo;
	}

}
