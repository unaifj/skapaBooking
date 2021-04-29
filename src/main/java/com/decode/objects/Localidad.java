package com.decode.objects;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Localidad {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT, primaryKey = "true")
	private int id;
	private String provincia;
	private String municipio;
	private int cp;
	private String direccion;
	
	public Localidad(String provincia, String municipio, int cp, String direccion) {
		super();
		this.provincia = provincia;
		this.municipio = municipio;
		this.cp = cp;
		this.direccion = direccion;
	}
	
	public Localidad() {
		super();
		this.provincia = "";
		this.municipio = "";
		this.cp = 00000;
		this.direccion = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Localidad [id=" + id + ", provincia=" + provincia + ", municipio=" + municipio + ", cp=" + cp
				+ ", direccion=" + direccion + "]";
	}
	
	

	
	

}
