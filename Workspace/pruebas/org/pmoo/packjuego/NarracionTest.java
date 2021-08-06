package org.pmoo.packjuego;

import junit.framework.TestCase;

public class NarracionTest extends TestCase {


	Narracion n1;
	
	protected void setUp() 
	{
		n1=new Narracion("hola, este es el test","1234");
		
	}

	protected void tearDown() 
	{
		n1=null;
		
	}
		
	public void testGetNarracion()
	{
		assertEquals(n1.getNarracion(), "hola, este es el test");	
	}
	
	public void testGetId()
	{	
		assertEquals(n1.getId(), "1234");		
	}

}
