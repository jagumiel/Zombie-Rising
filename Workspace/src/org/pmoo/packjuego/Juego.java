package org.pmoo.packjuego;

import java.io.IOException;
import java.util.Scanner;

public class Juego 
{
	private static Juego miJuego=new Juego();
	private int numeroDeEnemigos;
	
	private Juego()
	{
		this.numeroDeEnemigos=4;
	}
	
	public static Juego getJuego()
	{
		return miJuego;
	}
	public static void main(String args[]) throws IOException
	{
		Juego.getJuego().empezarJuego();
	}
	
	public void empezarJuego() throws IOException
	{	
		Inventario.getInventario().inicializarInventario();
		Mapa.getMapa().iniciarMapa();
		ListaNarraciones.getListaNarraciones().inicializarLista();
		Mapa.getMapa().imprimirSituacion();
		
		while(!Jugador.getJugador().estaMuerto()&&!Jugador.getJugador().getVictoria())
		{	
			Mapa.getMapa().preguntar();
		}
		this.partidaAcabada();
	}
        
	
	private void partidaAcabada() throws IOException
	{
		if(Jugador.getJugador().estaMuerto())
		{
			System.out.println("Ahora seras pasto de gusanos. Partida terminada.");
		}
		else
		{
			System.out.println("Enhorabuena, has conseguido sobrevivir.");
		}
		this.reiniciarPartida();
	}
	
	private void reiniciarPartida() throws IOException//NUEVO
	{
		String dato;
		
		Scanner entrada=new Scanner(System.in);
		System.out.println("");
		System.out.println("Quieres volver a jugar la partida?(si/no): ");
		System.out.println("");
		dato=entrada.next();
		if(dato.equals("si")||dato.equals("SI"))
		{
			this.limpiarPantalla();
			Jugador.getJugador().resetear();//NUEVO
			this.resetearNumEnemigos();//NUEVO
			this.empezarJuego();
		}
		else
		{
			if(dato.equals("no")||dato.equals("NO"))
			{
				System.out.println("Se ha terminado la aplicacion.");
			}
		}
		
	}
	
	private void setNumeroDeEnemigos(int pNum)
	{
		this.numeroDeEnemigos=this.numeroDeEnemigos - pNum;
	}
	
	public int getNumeroDeEnemigos()
	{
		return this.numeroDeEnemigos;
	}
	
	private void resetearNumEnemigos()
	{
		this.numeroDeEnemigos=4;
	}
	
	
	public void realizarCombate(Lugar pLugar)
	{
		Enemigo auxEn=pLugar.getEnemigo();
	
		Jugador.getJugador().equipar();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		while(!Jugador.getJugador().estaMuerto()&&auxEn.tieneVida())
		{
			auxEn.atacar();
			Jugador.getJugador().atacar(auxEn);
			System.out.println("Jugador: Nivel de salud-->"+Jugador.getJugador().getNivelSalud()+",Danio causado-->"+Jugador.getJugador().getDanio());
			System.out.println("Enemigo: Nivel de salud-->"+auxEn.getVida()+",Danio causado-->"+auxEn.getDanio());
			System.out.println("");
		}
		Jugador.getJugador().guardarArma();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		if(!auxEn.tieneVida()&&!Jugador.getJugador().estaMuerto())
		{
			pLugar.borrarEnemigo();
			this.setNumeroDeEnemigos(1);
			System.out.println("");
			System.out.println("Has logrado sobrevivir al ataque del zombie.");
			System.out.println("");
			if(this.getNumeroDeEnemigos()==0)
			{
				Jugador.getJugador().setVictoria(true);
			}
		}
	}
	
	private void limpiarPantalla()
	{
		for(int i=1;i<=100;i++)
		{
			System.out.println("");
		}
	}
}