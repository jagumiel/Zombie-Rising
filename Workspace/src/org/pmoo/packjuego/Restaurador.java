package org.pmoo.packjuego;

public class Restaurador extends Objeto

{
	private int cantidad;
	public Restaurador(int pId,String pNombre,String pDescripcion,int pCantidad)
	{
		super(pId,pNombre,pDescripcion);
		this.cantidad=pCantidad;
	}
	
	public int getCantidad()
	{
		return this.cantidad;
	}
}
