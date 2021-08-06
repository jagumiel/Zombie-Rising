package org.pmoo.packjuego;

import junit.framework.TestCase;

public class EnemigoTest extends TestCase
	{

	Enemigo e1;
	Enemigo e2;

	public void setUp() 
	{
		e1= new Enemigo(100,30);
		e2= new Enemigo(100,30);
	}

	
	public void tearDown() 
	{
		e1=null;
		e2=null;
	}

	
	public void testGetVida()
	{
		assertEquals(e1.getVida(), 100);
	}

	
	public void testGetDanio()
	{
		assertEquals(e1.getDanio(), 30);
	}
	
	public void testAtacar()
	{
		e1.atacar();
		assertEquals(Jugador.getJugador().getNivelSalud(), 70);
	}
	
	public void testRecibirDanio()
	{
		
		e1.recibirDanio(50);
		assertEquals(e1.getVida(), 50);
		
		e2.recibirDanio(500);
		assertEquals(e2.getVida(),0);
		
	}
	
	public void testTieneVida()
	{
		e1.recibirDanio(90);
		assertTrue(e1.tieneVida());
		
		e2.recibirDanio(120);
		assertFalse(e2.tieneVida());
	}
		
	

}
