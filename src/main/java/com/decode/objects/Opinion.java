package com.decode.objects;

public class Opinion {

	private int idUsuario;
	private String titulo;
	private String descripcion;
	private float puntuacion;
	
	
	public Opinion(int idUsuario, String titulo, String descripcion, float puntuacion) {
		super();
		this.idUsuario = idUsuario;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.puntuacion = puntuacion;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public float getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}


	@Override
	public String toString() {
		return "Opinion [idUsuario=" + idUsuario + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", puntuacion=" + puntuacion + "]";
	}
	


}
