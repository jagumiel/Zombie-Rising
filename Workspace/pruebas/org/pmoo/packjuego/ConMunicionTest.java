package org.pmoo.packjuego;

import junit.framework.TestCase;

public class ConMunicionTest extends TestCase {

		ConMunicion a1,a2;
	protected void setUp()
	{
		a1= new ConMunicion(68,"Escopeta","Una escopeta del calibre 20",20,5);
		a2= new ConMunicion(46,"Makarov","Una pistola semiautomatica de 9mm de origen ruso",10,12);
	}

	protected void tearDown()
	{
		a1=null;
		a2=null;
	}
	
	
	public void testGetNombre()
	{
		assertEquals(a1.getNombre(), "Escopeta");
		assertEquals(a2.getNombre(), "Makarov");
	}
	
	public void tesGetDescripcion()
	{
		System.out.println("Tiene que salir: Una navaja automatica.  Y sale->"+a1.getDescripcion());
		System.out.println("Tiene que salir: Una pistola semiautomatica de 9mm de origen ruso.  Y sale->"+a2.getDescripcion());
	
		
	}
	
	public void testGetDanio()
	{
		assertEquals(a1.getDanio(),20);
		assertEquals(a2.getDanio(),10);
		
	}
	
	public void testGetMunicion()
	{
		assertEquals(a1.getNumeroMunicion(),5);
		assertEquals(a2.getNumeroMunicion(),12);
		a1.setNumeroMunicion(5);
		assertEquals(a1.getNumeroMunicion(),0);
	}

}
