package modelo;

import java.io.Serializable;

public class Genero implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;
	public Genero(int id, String nombre)
	{
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() 
	{
		return id;
	}
}
