package org.pmoo.packjuego;

import junit.framework.TestCase;

import org.pmoo.packjuego.Juego;
import org.pmoo.packjuego.Enemigo;
import org.pmoo.packjuego.Jugador;
import org.pmoo.packjuego.Inventario;
import org.pmoo.packjuego.Mapa;
import org.pmoo.packjuego.ListaNarraciones;



public class JuegoTest extends TestCase 
{

	protected void setUp()  
	{
		
	
	}

	protected void tearDown() 
	{
		
	}

	
	public void testGetJuego() 
	{
		assertNotNull(Juego.getJuego());
	}


	public void testEmpezarJuego() 
	{
		Inventario.getInventario().inicializarInventario();
		assertEquals(Inventario.getInventario().getTamano(),1);
		Mapa.getMapa().iniciarMapa();
		ListaNarraciones.getListaNarraciones().inicializarLista();
		assertNotNull(ListaNarraciones.getListaNarraciones());
		Jugador.getJugador().getNivelSalud();
		assertEquals(Jugador.getJugador().getNivelSalud(),100);
		Jugador.getJugador().disminuirSalud(100);
		assertTrue(Jugador.getJugador().estaMuerto());
		Jugador.getJugador().suicidarse();
		assertTrue(Jugador.getJugador().estaMuerto());
		assertFalse(Jugador.getJugador().getVictoria());
		
		
	}

	public void testGetNumeroDeEnemigos() 
	{
		assertEquals(Juego.getJuego().getNumeroDeEnemigos(),4);
	}

	public void testRealizarCombate() 
	{
	Enemigo e1= new Enemigo(50,1);
	Jugador.getJugador().equipar();
	assertNotNull(Jugador.getJugador().getArmaActual());
	e1.recibirDanio(50);
	assertFalse(e1.tieneVida());
	Jugador.getJugador().atacar(e1);
	assertFalse(e1.tieneVida());
	if(Juego.getJuego().getNumeroDeEnemigos()==0)
	{
		Jugador.getJugador().getVictoria();
		assertTrue(Jugador.getJugador().getVictoria());
	}
	
	}

}
