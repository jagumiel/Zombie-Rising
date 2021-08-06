package org.pmoo.packjuego;

public class Narracion 
{
	private String narracion;
	private String id;//ESTE ID COINCIDIRA CON LA POSICION DEL LUGAR
	
	public Narracion(String pNarracion,String pId)
	{
		this.narracion=pNarracion;
		this.id=pId;
	}
	
	public String getNarracion()
	{
		return this.narracion;
	}
	
	public String getId()
	{
		return this.id;
	}
}
