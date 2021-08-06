package org.pmoo.packjuego;

import junit.framework.TestCase;

public class OpcionTest extends TestCase {

	Opcion op1;
	
	protected void setUp() 
	{
		op1=new Opcion("prueba");	
	}

	protected void tearDown() 
	{
		op1=null;		
	}
	public void testGetOpcion()
	{	
		assertEquals(op1.getOpcion(), "prueba");
	}
	
	
	public void testGetHabilitar()
	{
		assertTrue(op1.getHabilitar());
		assertEquals(op1.getHabilitar(),true);
	}
	
	
	public void testSetHabilitar()
	{
		op1.setHabilitar(false);
		assertFalse(op1.getHabilitar());	
	}

}
