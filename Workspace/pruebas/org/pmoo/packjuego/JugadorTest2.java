package org.pmoo.packjuego;

import junit.framework.TestCase;

public class JugadorTest2 extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		Jugador.getJugador().resetear();
	}




	public void testGetJugador()
	
	{
		assertNotNull (Jugador.getJugador());
	}
	
	public void testGetNombre()
	{
		assertEquals(Jugador.getJugador().getNombre(),"Dimitri");
		
		
	}
	
	public void testGetArmaActual()
	{
	 Objeto	a1,a2;
	 
	 a1=new ConMunicion(1, "EscopetaDeCombate", "Arma utilizada por fuerzas especiales de la policia de todo el mundo..",50,20);
	a2=new ConMunicion(4,"Pistola Magnum","arma de fuego pequena pero precisa.",25,10);
	
	Inventario.getInventario().inicializarInventario();	
	assertEquals(Inventario.getInventario().getTamano(),1);		
	try
	{
		Inventario.getInventario().anadirObjetoAlInventario(a2);
				assertEquals(Inventario.getInventario().getTamano(),2);		
		System.out.println("Deben de salir un mensaje de excepcion diciendo que ya existe un objeto con el mismo id. y muestra: ");
		System.out.println("======================================================================================");
		Inventario.getInventario().anadirObjetoAlInventario(a2);
		
	}
	catch(ObjetoConMismoId e)
	{
		System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
	}

		
}	
	
	public void testGetDanio()
	{
		Objeto a1,a2;
	 a1=new ConMunicion(1, "EscopetaDeCombate", "Arma utilizada por fuerzas especiales de la policia de todo el mundo..",50,20);
   	a2=new ConMunicion(4,"Pistola Magnum","arma de fuego pequena pero precisa.",25,10);
		
		
		Inventario.getInventario().inicializarInventario();
		assertNotNull(Inventario.getInventario());
		assertEquals(Inventario.getInventario().getTamano(),1);	
		try
		{
			Inventario.getInventario().anadirObjetoAlInventario(a2);
			
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
		}
		Jugador.getJugador().equipar();
		assertEquals(Jugador.getJugador().getDanio(),25);
		try
		{
			Inventario.getInventario().anadirObjetoAlInventario(a1);
			
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
		}
		Jugador.getJugador().equipar();
		assertEquals(Jugador.getJugador().getDanio(),25);
		
	}
	public void testGetNivelSalud()
	{
		Inventario.getInventario().inicializarInventario();
		assertEquals(Jugador.getJugador().getNivelSalud(),100);
		Jugador.getJugador().disminuirSalud(25);
		assertEquals(Jugador.getJugador().getNivelSalud(),75);
		Jugador.getJugador().disminuirSalud(50);
		assertEquals(Jugador.getJugador().getNivelSalud(),25);
		Jugador.getJugador().disminuirSalud(3456);
		assertEquals(Jugador.getJugador().getNivelSalud(),0);
	}

	
	
	
	public void testEstaMuerto()
	{
		assertFalse(Jugador.getJugador().estaMuerto());
		Jugador.getJugador().disminuirSalud(100);
		assertTrue(Jugador.getJugador().estaMuerto());
		
		
	}
	
	public void testGetVictoria()
	{
		assertFalse(Jugador.getJugador().getVictoria());
		Jugador.getJugador().setVictoria(true);
		assertTrue(Jugador.getJugador().getVictoria());
	}
	
	public void testDisminuirSalud()
	{
		assertEquals(Jugador.getJugador().getNivelSalud(),100);
		Jugador.getJugador().disminuirSalud(23);
		assertEquals(Jugador.getJugador().getNivelSalud(),77);
		Jugador.getJugador().disminuirSalud(50);
		assertEquals(Jugador.getJugador().getNivelSalud(),27);
		Jugador.getJugador().disminuirSalud(23);
		assertEquals(Jugador.getJugador().getNivelSalud(),4);
		Jugador.getJugador().disminuirSalud(4);
		assertEquals(Jugador.getJugador().getNivelSalud(),0);
		Jugador.getJugador().disminuirSalud(60);
		assertEquals(Jugador.getJugador().getNivelSalud(),0);
		
				
	}
	public void testAtacar()
	{
		Objeto a1;
		 a1=new ConMunicion(1, "EscopetaDeCombate", "Arma utilizada por fuerzas especiales de la policia de todo el mundo..",50,20);
		Enemigo e1;
		e1=new Enemigo (10,1);
		assertEquals(e1.getVida(),10);
		Inventario.getInventario().inicializarInventario();
		try
		{
			Inventario.getInventario().anadirObjetoAlInventario(a1);
			
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
		}
		Jugador.getJugador().equipar();
		Jugador.getJugador().atacar(e1);
		assertFalse(e1.tieneVida());
				
		}
	public void testSuicidarse()
	{
		System.out.println("Debe salir un mensaje de suicidio");
		System.out.println("===================================================");
		assertFalse(Jugador.getJugador().estaMuerto());
		assertEquals(Jugador.getJugador().getNivelSalud(),100);
		Jugador.getJugador().suicidarse();
		assertTrue(Jugador.getJugador().estaMuerto());
		assertEquals(Jugador.getJugador().getNivelSalud(),0);
		
	}
	
	public void testGuardarArma()
	{
		Objeto a1;
		a1=new ConMunicion(1, "EscopetaDeCombate", "Arma utilizada por fuerzas especiales de la policia de todo el mundo..",50,20);
		Inventario.getInventario().inicializarInventario();
		try
		{
			Inventario.getInventario().anadirObjetoAlInventario(a1);
			
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
		}
		assertTrue(Inventario.getInventario().esta(a1));
		Jugador.getJugador().equipar();
		assertFalse(Inventario.getInventario().esta(a1));
		Jugador.getJugador().guardarArma();
		assertTrue(Inventario.getInventario().esta(a1));	
		
	}
	
}