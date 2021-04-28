package com.decode.SSB;

public class Usuario {
	 
    private static final long serialVersionUID = 1L;
 
    public String nombre;
 
    public String nombreUsuario;	
    
    public String correo;
 
    public Usuario() {
        super();
    }

	public Usuario(String nombre, String nombreUsuario, String correo) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
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

	
     
   
}
