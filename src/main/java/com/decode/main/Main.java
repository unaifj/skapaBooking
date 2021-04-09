package com.decode.main;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Usuario;
import com.decode.sesion.VentanaInicio;

public class Main {

	public static void main(String[] args) {
		
		DBManager dbm = new DBManager();
		try {
			dbm.preparedData();
			dbm.listarUsuarios();
			for (Usuario user: dbm.listarUsuarios()) {
				System.out.println(user);
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		VentanaInicio vi = new VentanaInicio();
		vi.setVisible(true);

	}

}

