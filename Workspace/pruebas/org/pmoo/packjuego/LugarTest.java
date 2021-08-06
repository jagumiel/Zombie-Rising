package org.pmoo.packjuego;

import junit.framework.TestCase;

public class LugarTest extends TestCase 
{
	Lugar l1;
	Lugar l2;

	
	public void setUp()
	{
		l1=new Lugar("whatever", null, null, true, true, true, true, true, true);
		l2=new Lugar("whatever", null, null, false, false, false, false, false, false);

	}


	public void tearDown()
	{
		l1=null;
		l2=null;
	}

	
	public void testGetDescripcion() 
	{ 
		assertEquals(l1.getDescripcion(),"whatever");
	}
	
	public void testGetVisitado()
	{
		//assertEquals
	}

	public void testGetYaVisitado()
	{
		//TODO
	}
	
	public void testGetNorte()
	{
		assertTrue(l1.getNorte());
		assertFalse(l2.getNorte());
	}
	
	public void testGetSur()
	{
		assertTrue(l1.getSur());
		assertFalse(l2.getSur());

	}
	
	public void testGetEste()
	{
		assertTrue(l1.getEste());
		assertFalse(l2.getEste());
	}
	
	public void testGetOeste()
	{
		assertTrue(l1.getOeste());
		assertFalse(l2.getOeste());
	}
	
	public void testGetSubir()
	{
		assertTrue(l1.getSubir());
		assertFalse(l2.getSubir());
	}
	
	public void testGetBajar()
	{
		assertTrue(l1.getBajar());
		assertFalse(l2.getBajar());
	}
	
	public void testActivarOpcion()
	{	
		
		l1.activarOpcion("coger");
		assertTrue(l1.getListaOpciones().buscarOpcion("coger").getHabilitar());
	}
	
	public void testDesactivarOpcion()
	{
		l1.desactivarOpcion("coger");
		assertFalse(l1.getListaOpciones().buscarOpcion("coger").getHabilitar());
	}
	
	public void testEstaOpcion()
	{
		assertTrue(l1.estaOpcion("coger"));
		assertFalse(l1.estaOpcion("orinar"));
	}
	
	 public void testGetEnemigo()
	 {
	  assertNotNull(l2.getEnemigo());
	 }
	 
	 public void testBorrarEnemigo()
	 {
	  l2.borrarEnemigo();
	  assertNull(l2.getEnemigo());
	 }
	 
	 public void testMostrarNarracion()
	 {
	  Mapa.getMapa().iniciarMapa();
	  Lugar l1=Mapa.getMapa().getLugarActual();//posicion 1,3,2
	  System.out.println("debería de mostrar este mensaje: Te encuentras en una habitacion acolchada. Llevas una camisa que te impide mover.Si coges este cristal, te ayudara a liberarte.Una vez que te hayas liberado podras acercarte a la puerta y salir");
	  System.out.println("");
	  l1.mostrarNarracion("132");
	  Mapa.getMapa().moverse("norte");
	  Lugar l2=Mapa.getMapa().getLugarActual();//posicion 2,3,2
	  System.out.println("debería de mostrar este mensaje: En el periodico hay un simbolo nuclear Habra pasado algo?,"+" Catastrofe nuclear en Prypiat (el periodico resalta)");
	  System.out.println("");
	  l2.mostrarNarracion("232");
	  
	  Mapa.getMapa().moverse("sur");
	  Lugar l3=Mapa.getMapa().getLugarActual();//posicion 2,3,2
	  System.out.println("debería de mostrar este mensaje: estas en el cuarto.");
	  System.out.println("");
	  l3.mostrarNarracion("132");
	 }
	 
}
