package com.decode.objects;

import java.util.Calendar;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase Anuncio clase objeto para las diferentes anuncios
 * @author En documentacion : Jagoba Gomez Sanchez
 *
 */

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Anuncio {
	
	private static int cont = 0;
	
	@PrimaryKey
	private int id;
	private int idUsuario;
	@ForeignKey
	private Apartamento apartamento;
	private String titulo;
	private String descripcion;
	private double precioNoche;
	private boolean disponibilidad;
	private int numPersonas;
	private String img;
	
/**
 * Constructor de Anuncio
 * @param idUsuario id para establecer la id del usuario que ha publicado el anuncio
 * @param apartamento obtenemos el apartamento de dicho anuncio
 * @param titulo Para establecer un titulo al anuncio
 * @param descripcion Para establecer una descripcion al anuncio
 * @param precioNoche Para establecer el precio por noche del anuncio
 * @param disponibilidad Boolean para saber si esta disponible o no
 * @param numPersonas Para saber el numero de personas maximo para el anuncio 
 * @param img Imagen del apartamento para el anuncio
 */

	public Anuncio(int idUsuario, Apartamento apartamento, String titulo, String descripcion,
			double precioNoche, boolean disponibilidad, int numPersonas, String img) {
		super();
		this.id = cont;
		this.idUsuario = idUsuario;
		this.apartamento = apartamento;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.disponibilidad = disponibilidad;
		this.numPersonas = numPersonas;
		this.img = img;
		cont++;
	}
	
	
	



	
/**
 * Para conseguir el id del anuncio
 * @return int Id del anuncio
 */



	public int getId() {
		return id;
	}






/**
 * Para cambiar el id del anuncio
 * @param id con el id del anuncio
 */


	public void setId(int id) {
		this.id = id;
	}



	/**
	 * Devuelve el id del usuario que ha creado el anuncio
	 * @return int Id usuario de la clase Anuncio
	 */


	public int getIdUsuario() {
		return idUsuario;
	}


/**
 * Para cambiar el id del usuario que ha creado el anuncio
 * @param idUsuario de la clase Anuncio
 */





	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}






/**
 * Devuelve el apartamento que se anuncia en el anuncio
 * @return Apartamento Apartamento de la clase Apartamento 
 */


	public Apartamento getApartamento() {
		return apartamento;
	}






/**
 * Para cambiar el apartamento del anuncio
 * @param apartamento Apartamento de la clase apartamento
 */


	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}








/**
 * Devuelve el titulo del anuncio
 * @return String titulo de la clase Anuncio
 */
	public String getTitulo() {
		return titulo;
	}






/**
 * Para cambiar el titulo del anuncio
 * @param titulo del la clase anuncio
 */


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}






/**
 * Devuelve la descripcion del anuncio
 * @return String descripcion de la clase Anuncio
 */


	public String getDescripcion() {
		return descripcion;
	}






/**
 * Para cambiar la descripcion del anuncio
 * @param descripcion
 */


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}







/**
 * Devuelve el precio por noche del anuncio
 * @return double PrecioNoche de la clase anuncio
 */

	public double getPrecioNoche() {
		return precioNoche;
	}



/**
 * Para cambiar el precio por noche de cada anuncio
 * @param precioNoche de la clase anuncio
 */





	public void setPrecioNoche(double precioNoche) {
		this.precioNoche = precioNoche;
	}

/**
 * Para saber si esta dsiponible el anuncio o no
 * @return boolean isDisponibilidad de la clase anuncio
 */







	public boolean isDisponibilidad() {
		return disponibilidad;
	}






/**
 * Para cambiar la disponibilidad del anuncio
 * @param disponibilidad de la clase anuncio
 */


	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}






/**
 * Devuelve el numero de personas maximo del anuncio
 * @return int NumPersonas de la clase anuncio
 */


	public int getNumPersonas() {
		return numPersonas;
	}





/**
 * Para cambiar el numero de personas del anuncio
 * @param numPersonas de la clase anuncio
 */



	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}




/**
 * Devuelve la imagen subida por el usuario del anuncio
 * @return String Img de la clase anuncio
 */




	public String getImg() {
		return img;
	}



/**
 * Para cambiar la imagen de la clase anuncio
 * @param img de la clase anuncio
 */





	public void setImg(String img) {
		this.img = img;
	}





/**
 * toString de la clase Anuncio
 */



	@Override
	public String toString() {
		return "Anuncio [id=" + id + ", idUsuario=" + idUsuario + ", apartamento=" + apartamento + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + ", precioNoche=" + precioNoche + ", disponibilidad=" + disponibilidad
				+ ", numPersonas=" + numPersonas + ", img=" + img + "]";
	}









	public boolean comprobarDis(Calendar fechaEntrada, Calendar fechaSalida) {
	
		boolean disponible = true;
		if (apartamento.getReservas() != null) {
			for (Reserva r : apartamento.getReservas()) {
				if (fechaEntrada.after(r.getFechaEntrada()) && fechaEntrada.before(r.getFechaSalida())) {
					disponible = false;
				}else if (fechaSalida.after(r.getFechaEntrada())&& fechaSalida.before(r.getFechaSalida())) {
					disponible = false;
				}
			}
		}
		
		
		return disponible;
	}
	

}
