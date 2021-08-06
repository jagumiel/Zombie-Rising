package org.pmoo.packjuego;

import junit.framework.TestCase;

public class ArmaTest extends TestCase 

{
Arma a1;
Arma a2;

	protected void setUp() throws Exception {
		a1= new ArmaBlanca(5,"Cuchillo","Una navaja automatica", 5);
		a2= new ConMunicion(46,"Makarov","Una pistola semiautomatica de 9mm de origen ruso",10,12);
	}

	protected void tearDown() throws Exception {
		a1=null;
		a2=null;
	}
		
		public void testGetNombre()
		{
			assertEquals(a1.getNombre(),"Cuchillo");
			assertEquals(a2.getNombre(),"Makarov");
		}
		
		public void tesGetDescripcion()
		{
			System.out.println("Tiene que salir: Una navaja automatica.  Y sale->"+a1.getDescripcion());
			System.out.println("Tiene que salir: Una pistola semiautomatica de 9mm de origen ruso.  Y sale->"+a2.getDescripcion());
		
			
		}
	
		public void testGetDanio()
		{
			assertEquals(a1.getDanio(),5);
			assertEquals(a2.getDanio(),10);
			
		}
	
	
	

}
