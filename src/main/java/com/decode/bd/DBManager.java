package com.decode.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import javax.swing.JOptionPane;

public class DBManager {

		private static Connection connection=null;
		private static Statement statement=null;
		
		
		public static Connection initBD() {
			try {
				Class.forName("org.sqlite.JDBC");
				 connection = DriverManager.getConnection("jdbc:sqlite:----" );
					statement = connection.createStatement();
					statement.setQueryTimeout(30);  // poner timeout 30 msg
					LogController.log(Level.INFO, "Conectada base de datos ", null );
				    return connection;
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog( null, "Error de conexion!! No se ha podido conectar con la bd ", "ERROR", JOptionPane.ERROR_MESSAGE );
					System.out.println( "Error de conexion!! No se ha podido conectar con la bd" );
					return null;
				}
		}
		
		public static void close() {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				LogController.log( Level.SEVERE, "Error en conexion de base de datos " , e );
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() {
			return connection;
		}
		
		
		public static Statement getStatement() {
			return statement;
		}
		
		

}
