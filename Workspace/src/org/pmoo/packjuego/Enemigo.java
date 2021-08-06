package org.pmoo.packjuego;

public class Enemigo 
{
	private int vida;
	private int danio;
	private boolean vivo;
	
	public Enemigo(int pVida,int pDanio)
	{
		this.vida=pVida;
		this.danio=pDanio;
		this.vivo=true;
	}
	
	public int getVida()
	{
		return this.vida;
	}
	
	public int getDanio()
	{
		return this.danio;
	}
	
	public void atacar()
	{
		Jugador.getJugador().disminuirSalud(this.danio);
	}
	
	public void recibirDanio(int pDanio)
	{
		this.vida=this.vida - pDanio;
		if(this.vida<=0)
		{
			this.vida=0;
		}
	}
	
	public boolean tieneVida()
	{	
		if(this.vida==0)
		{
			this.vivo=false;
		}
		return this.vivo;
	}
}
