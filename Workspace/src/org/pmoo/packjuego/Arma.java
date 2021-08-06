package org.pmoo.packjuego;

public abstract class Arma extends Objeto
{
	protected int danio;


	public Arma(int pId,String pNombre,String pDescripcion,int pDanio)
	{
		super(pId,pNombre,pDescripcion);
		this.danio=pDanio;
	}
	
	public int getDanio() 
	{
		return this.danio;
	}

}
