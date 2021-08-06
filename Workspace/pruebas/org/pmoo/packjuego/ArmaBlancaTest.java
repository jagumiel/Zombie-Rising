package org.pmoo.packjuego;
import org.pmoo.packjuego.ArmaBlanca;

import junit.framework.TestCase;


public class ArmaBlancaTest extends TestCase 
{

	
	ArmaBlanca oBJ1;
	ArmaBlanca oBJ2;
	protected void setUp() throws Exception 
	{
		oBJ1= new ArmaBlanca(5,"Cuchillo","Una navaja automatica", 5);
		oBJ2= new ArmaBlanca(10,"Martillo","Un martillo de carpintero",3);
	}

	protected void tearDown() throws Exception 
	{
	oBJ1=null;
	oBJ2=null;
	}
	
	public void testGetNombre()
	{
		assertEquals(oBJ1.getNombre(),"Cuchillo");
	}
	public void testGetDescripcion()
	{
		System.out.println("Tiene que salir: Una navaja automatica.  Y sale->"+oBJ1.getDescripcion());
		System.out.println("Tiene que salir: Un martillo de carpintero.  Y sale->"+oBJ2.getDescripcion());
		
	}
	
	public void testGetDanio()
	{
		assertEquals(oBJ1.getDanio(),5);
		assertEquals(oBJ2.getDanio(),3);
}

}
