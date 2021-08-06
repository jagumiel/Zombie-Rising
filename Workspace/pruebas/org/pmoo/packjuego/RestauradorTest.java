package org.pmoo.packjuego;

import junit.framework.TestCase;

public class RestauradorTest extends TestCase {

	Restaurador a1,a2;
	protected void setUp()
	{
		a1= new Restaurador(657,"Lata de Comida","Una lata de comida",15);
		a2= new Restaurador(7,"Botiquin","Un Botiquin de primeros auxilios",40);
	}

	protected void tearDown()
	{
		a1=null;
		a2=null;
	}

	
	public void testGetNombre()
	{
		assertEquals(a1.getNombre(),"Lata de Comida");
		assertEquals(a2.getNombre(), "Botiquin");
	}
	
	public void testGetDescripcion()
	{
		System.out.println("Tiene que salir: Una lata de comida.  Y sale->"+a1.getDescripcion());
		System.out.println("Tiene que salir: Un Botiquin de primeros auxilios.  Y sale->"+a2.getDescripcion());
	}
	
	public void testGetCantidad()
	{
		assertEquals(a1.getNombre(),"Lata de Comida");
		assertEquals(a2.getNombre(),"Botiquin");
	}
	
}

