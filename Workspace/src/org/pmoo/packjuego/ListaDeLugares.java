package org.pmoo.packjuego;

public class ListaDeLugares 
{
	private Lugar matriz[][][];
	private static int dimensionFila=6;
	private static int dimensionColumna=6;
	private static int dimensionAltura=4;
	
	public ListaDeLugares()
	{
		this.matriz= new Lugar[getDimensionFila()][getDimensionColumna()][getDimensionAltura()];
	}
	
	private Lugar[][][] getMatriz()
	{
		return this.matriz;
	}
	
	private static int getDimensionFila()
	{
		return dimensionFila;
	}
	
	private static int getDimensionColumna()
	{
		return dimensionColumna;
	}
	
	private static int getDimensionAltura()
	{
		return dimensionAltura;
	}
	
	public void aniadirLugar(Lugar pLugar,int pFila,int pColumna,int pAltura)
	{
		if(this.esta(pFila,pColumna,pAltura))
		{
			
		}
		else
		{
			if(pFila>=getDimensionFila()||pColumna>=getDimensionColumna()||pAltura>=getDimensionAltura())
			{
			}
			else
			{
				this.getMatriz()[pFila][pColumna][pAltura]=pLugar;
			}
		}
	}
	
	public Lugar getLugar(int pFila,int pColumna,int pAltura)
	{
		Lugar pLugar=null;
		if(pFila<getDimensionFila()&&pColumna<getDimensionColumna()&&pAltura<getDimensionAltura())
		{
			pLugar=this.getMatriz()[pFila][pColumna][pAltura];
		}
		return pLugar;
	}
	
	private boolean esta(int pFila,int pColumna,int pAltura)
	{
		boolean enc=false;
		if(this.getLugar(pFila, pColumna, pAltura)!=null)
		{
			enc=true;
		}
		return enc;
	}
}
