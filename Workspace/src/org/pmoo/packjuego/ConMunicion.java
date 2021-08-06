package org.pmoo.packjuego;

public class ConMunicion extends Arma
{
	private int numeroMunicion;
	
	public ConMunicion(int pId,String pNombre,String pDescripcion,int pDanio, int pNumMunicion)
	{
		super(pId,pNombre,pDescripcion,pDanio);
		this.numeroMunicion=pNumMunicion;
	}

	public int getNumeroMunicion() {
		return this.numeroMunicion;
	}

	public void setNumeroMunicion(int pNumeroMunicion) {
		this.numeroMunicion = this.getNumeroMunicion() - pNumeroMunicion;
	}
	
	
}
