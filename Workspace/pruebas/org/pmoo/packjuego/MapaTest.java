package org.pmoo.packjuego;

import junit.framework.TestCase;

public class MapaTest extends TestCase 
{

	protected void setUp() 
	{
		Mapa.getMapa().iniciarMapa();
	}

	protected void tearDown()
	{
		
	}
	
	public void testGetMapa()
	{
		assertNotNull(Mapa.getMapa());
	}
	
	
	public void testIniciarMapa()
	{
		System.out.println(Mapa.getMapa().getLugarActual());
		assertEquals(Mapa.getMapa().getLugarActual(),"132");
	}
	
	public void testAniadirObjetoAlInventario()
	{
		assertEquals(Inventario.getInventario().getTamano(),1);
		Mapa.getMapa().moverse("norte");
		Mapa.getMapa().aniadirObjetoAlInventario();
		assertEquals(Inventario.getInventario().getTamano(),2);
	}
	
	/*public void testPreguntar()
	{
		
	}*/

}
