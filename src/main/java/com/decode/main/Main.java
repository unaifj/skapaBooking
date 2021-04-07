package com.decode.main;

import com.decode.bd.DBManager;
import com.decode.sesion.VentanaInicio;

public class Main {

	public static void main(String[] args) {
		
		DBManager dbm = new DBManager();
		dbm.preparedData();
		
		VentanaInicio vi = new VentanaInicio();
		vi.setVisible(true);

	}

}
