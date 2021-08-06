package org.pmoo.packjuego;

public abstract class Objeto 
{
	protected int id;
	protected String nombre;
	protected String descripcion;
	
	
	public Objeto (int pId,String pNombre,String pDescripcion)
	{
		this.id=pId;
		this.nombre=pNombre;
		this.descripcion=pDescripcion;
	}
	
	public int getId()
	{
		return this.id;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public String getDescripcion() 
	{
		return this.descripcion;
	}
}
