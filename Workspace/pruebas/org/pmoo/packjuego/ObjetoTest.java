package org.pmoo.packjuego;

import junit.framework.TestCase;

public class ObjetoTest extends TestCase 
{
	
	Objeto o1,o2,o3;
	
	protected void setUp() 
	{
		o1=new ConMunicion(4,"Pistola Magnum","arma de fuego pequena pero precisa.",25,10);
		o2=new Restaurador(16,"botiquin","Te incrementa la vida 70hp",70);
		o3=new ArmaBlanca(6,"Cuchillo Jamonero","Buen cuchillo para cortar jamon.",3);
	}

	protected void tearDown()
	{
		o1=null;
		o2=null;
		o3=null;
	}
	
	public void testGetId()
	{
		assertEquals(o1.getId(),4);
		assertEquals(o2.getId(),16);
		assertEquals(o3.getId(),6);
	}
	
	public void testGetNombre()
	{
		assertEquals(o1.getNombre(),"Pistola Magnum");
		assertEquals(o2.getNombre(),"botiquin");
		assertEquals(o3.getNombre(),"Cuchillo Jamonero");
	}
	
	public void testGetDescripcion()
	{
		assertEquals(o1.getDescripcion(),"arma de fuego pequena pero precisa.");
		assertEquals(o2.getDescripcion(),"Te incrementa la vida 70hp");
		assertEquals(o3.getDescripcion(),"Buen cuchillo para cortar jamon.");
	}

}
