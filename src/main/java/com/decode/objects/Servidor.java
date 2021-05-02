package com.decode.objects;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Servidor {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT, primaryKey = "true")
	
	private int id;
	private String nomServidor;
	private String correoS;
	private String contrasenyaS;
	private int puerto;
	
	public Servidor(int id, String nomServidor, String correoS, String contrasenyaS, int puerto) {
		super();
		this.id = id;
		this.nomServidor = nomServidor;
		this.correoS = correoS;
		this.contrasenyaS = contrasenyaS;
		this.puerto = puerto;
	}

	public Servidor() {
		super();
		this.id = 0;
		this.nomServidor = "";
		this.correoS = "";
		this.contrasenyaS = "";
		this.puerto = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomServidor() {
		return nomServidor;
	}

	public void setNomServidor(String nomServidor) {
		this.nomServidor = nomServidor;
	}

	public String getCorreoS() {
		return correoS;
	}

	public void setCorreoS(String correoS) {
		this.correoS = correoS;
	}

	public String getContrasenyaS() {
		return contrasenyaS;
	}

	public void setContrasenyaS(String contrasenyaS) {
		this.contrasenyaS = contrasenyaS;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	@Override
	public String toString() {
		return "Servidor [id=" + id + ", nomServidor=" + nomServidor + ", correoS=" + correoS + ", contrasenyaS="
				+ contrasenyaS + ", puerto=" + puerto + "]";
	}
	
	
	
	
	

}
