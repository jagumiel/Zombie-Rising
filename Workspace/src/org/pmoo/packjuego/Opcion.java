package org.pmoo.packjuego;

public class Opcion 
{
	private String nombre;
	private boolean habilitar; 
	
	public Opcion(String pNombre)
	{
		this.nombre=pNombre;
		this.habilitar=true;
	}
	
	public String getOpcion()
	{
		return this.nombre;
	}
	
	public boolean getHabilitar()
	{
		return this.habilitar;
	}
	
	public void setHabilitar(boolean pHabilitar)
	{
		this.habilitar=pHabilitar;
	}
}
