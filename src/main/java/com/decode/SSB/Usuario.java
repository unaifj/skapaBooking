package com.decode.SSB;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {
	 
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int codigo;
    
    private String nombre;
 
    private String nombreUsuario;	
    
    private String correo;

	public Usuario(int codigo, String nombre, String nombreUsuario, String correo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
	}
    
	public Usuario() {
		super();
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", correo="
				+ correo + "]";
	}
 
    

	
     
   
}
