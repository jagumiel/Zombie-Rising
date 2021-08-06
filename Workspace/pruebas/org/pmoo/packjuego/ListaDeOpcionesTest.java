package org.pmoo.packjuego;

import junit.framework.TestCase;

public class ListaDeOpcionesTest extends TestCase 
{
	Opcion opcion1;
	Opcion opcion2;
	Opcion opcion3;
	Opcion opcion4;
	Opcion opcion5;
	Opcion opcion6;
	Opcion opcion7;
	Opcion opcion8;
	Opcion opcion9;
	ListaDeOpciones lista;
	
	protected void setUp()
	{
		opcion1=new Opcion("coger");
		opcion2=new Opcion("norte");
		opcion3=new Opcion("sur");
		opcion4=new Opcion("este");
		opcion5=new Opcion("oeste");
		opcion6=new Opcion("subir");
		opcion7=new Opcion("bajar");
		opcion8=new Opcion("atacar");
		opcion9=new Opcion("suicidarse");
		lista=new ListaDeOpciones();
	}

	protected void tearDown() 
	{
		opcion1=null;
		opcion2=null;
		opcion3=null;
		opcion4=null;
		opcion5=null;
		opcion6=null;
		opcion7=null;
		opcion8=null;
		lista=null;
	}
	
	public void testListaDeOpciones()
	{
		assertNotNull(lista);
	}
	
	public void testBuscarOpcion()
	{
		try
		{
			//NINGUNA OPCION EN LA LISTA
			assertNull(lista.buscarOpcion("coger"));
			assertNull(lista.buscarOpcion("sur"));
			assertNull(lista.buscarOpcion("atacar"));
			assertNull(lista.buscarOpcion("oeste"));
			assertNull(lista.buscarOpcion("subir"));
			assertNull(lista.buscarOpcion("suicidarse"));
			assertNull(lista.buscarOpcion("este"));
			assertNull(lista.buscarOpcion("bajar"));
			assertNull(lista.buscarOpcion("norte"));
			
			//ESTAN LA MITAD
			lista.aniadirOpcion(opcion3);
			lista.aniadirOpcion(opcion5);
			lista.aniadirOpcion(opcion6);
			lista.aniadirOpcion(opcion9);
			lista.aniadirOpcion(opcion7);
			assertNull(lista.buscarOpcion("coger"));
			assertNotNull(lista.buscarOpcion("sur"));
			assertSame(lista.buscarOpcion("sur"),opcion3);
			assertNull(lista.buscarOpcion("atacar"));
			assertNotNull(lista.buscarOpcion("oeste"));
			assertSame(lista.buscarOpcion("oeste"),opcion5);
			assertNotNull(lista.buscarOpcion("subir"));
			assertSame(lista.buscarOpcion("subir"),opcion6);
			assertNotNull(lista.buscarOpcion("suicidarse"));
			assertSame(lista.buscarOpcion("suicidarse"),opcion9);
			assertNull(lista.buscarOpcion("este"));
			assertNotNull(lista.buscarOpcion("bajar"));
			assertSame(lista.buscarOpcion("bajar"),opcion7);
			assertNull(lista.buscarOpcion("norte"));
			
			//ESTAN TODAS
			lista.aniadirOpcion(opcion1);
			lista.aniadirOpcion(opcion2);
			lista.aniadirOpcion(opcion4);
			lista.aniadirOpcion(opcion8);
			
			assertNotNull(lista.buscarOpcion("coger"));
			assertSame(lista.buscarOpcion("coger"),opcion1);
			assertNotNull(lista.buscarOpcion("norte"));
			assertSame(lista.buscarOpcion("norte"),opcion2);
			assertNotNull(lista.buscarOpcion("este"));
			assertSame(lista.buscarOpcion("este"),opcion4);
			assertNotNull(lista.buscarOpcion("atacar"));
			assertSame(lista.buscarOpcion("atacar"),opcion8);
		}
		catch(OpcionConMismoNombre e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe una opcion con ese nombre.");
		}
	}
	
	public void testAniadirOpcion()
	{
		try
		{
			assertEquals(lista.getTamano(),0);
			lista.aniadirOpcion(opcion1);
			lista.aniadirOpcion(opcion2);
			lista.aniadirOpcion(opcion4);
			lista.aniadirOpcion(opcion8);
			lista.aniadirOpcion(opcion3);
			lista.aniadirOpcion(opcion5);
			lista.aniadirOpcion(opcion6);
			lista.aniadirOpcion(opcion9);
			lista.aniadirOpcion(opcion7);
			assertEquals(lista.getTamano(),9);
			assertNotNull(lista.buscarOpcion("coger"));
			assertSame(lista.buscarOpcion("coger"),opcion1);
			assertNotNull(lista.buscarOpcion("norte"));
			assertSame(lista.buscarOpcion("norte"),opcion2);
			assertNotNull(lista.buscarOpcion("sur"));
			assertSame(lista.buscarOpcion("sur"),opcion3);
			assertSame(lista.buscarOpcion("este"),opcion4);
			assertNotNull(lista.buscarOpcion("atacar"));
			assertNotNull(lista.buscarOpcion("oeste"));
			assertSame(lista.buscarOpcion("oeste"),opcion5);
			assertNotNull(lista.buscarOpcion("subir"));
			assertSame(lista.buscarOpcion("subir"),opcion6);
			assertNotNull(lista.buscarOpcion("bajar"));
			assertSame(lista.buscarOpcion("bajar"),opcion7);
			assertNotNull(lista.buscarOpcion("atacar"));
			assertSame(lista.buscarOpcion("atacar"),opcion8);
			assertNotNull(lista.buscarOpcion("suicidarse"));
			assertSame(lista.buscarOpcion("suicidarse"),opcion9);
			
			//ANIADIR UNA OPCION QUE YA EXISTE
			System.out.println("Deben de salir un mensaje de excepcion diciendo que ya existe una opcion con ese nombre. y muestra: ");
			System.out.println("===========================================================================================");
			lista.aniadirOpcion(opcion7);
		}
		catch(OpcionConMismoNombre e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe una opcion con ese nombre.");
		}
	}
	
	public void testResetear()
	{
		try
		{
			assertEquals(lista.getTamano(),0);
			lista.aniadirOpcion(opcion1);
			lista.aniadirOpcion(opcion2);
			lista.aniadirOpcion(opcion4);
			lista.aniadirOpcion(opcion8);
			lista.aniadirOpcion(opcion3);
			lista.aniadirOpcion(opcion5);
			lista.aniadirOpcion(opcion6);
			lista.aniadirOpcion(opcion9);
			lista.aniadirOpcion(opcion7);
			assertEquals(lista.getTamano(),9);
			lista.resetear();
			assertEquals(lista.getTamano(),0);
		}
		catch(OpcionConMismoNombre e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe una opcion con ese nombre.");
		}
	}
	
	public void testImprimirOpciones()
	{
		try
		{
			lista.aniadirOpcion(opcion1);
			lista.aniadirOpcion(opcion2);
			lista.aniadirOpcion(opcion4);
			lista.aniadirOpcion(opcion8);
			lista.aniadirOpcion(opcion3);
			lista.aniadirOpcion(opcion5);
			lista.aniadirOpcion(opcion6);
			lista.aniadirOpcion(opcion9);
			lista.aniadirOpcion(opcion7);
			System.out.println("Debe de salir las opciones de esta manera: ");
			System.out.println("");
			System.out.println("coger");
			System.out.println("norte");
			System.out.println("este");
			System.out.println("atacar");
			System.out.println("sur");
			System.out.println("oeste");
			System.out.println("subir");
			System.out.println("suicidarse");
			System.out.println("bajar");
			System.out.println("===========================================================================================");
			System.out.println("Y tu programa lo muestra asi: ");
			lista.imprimirOpciones();
		}
		catch(OpcionConMismoNombre e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe una opcion con ese nombre.");
		}
	}
	
	public void testGetTamano()
	{
		try
		{
			assertEquals(lista.getTamano(),0);
			lista.aniadirOpcion(opcion1);
			assertEquals(lista.getTamano(),1);
			lista.aniadirOpcion(opcion2);
			assertEquals(lista.getTamano(),2);
			lista.aniadirOpcion(opcion4);
			assertEquals(lista.getTamano(),3);
			lista.aniadirOpcion(opcion8);
			assertEquals(lista.getTamano(),4);
			lista.aniadirOpcion(opcion3);
			assertEquals(lista.getTamano(),5);
			lista.aniadirOpcion(opcion5);
			assertEquals(lista.getTamano(),6);
			lista.aniadirOpcion(opcion6);
			assertEquals(lista.getTamano(),7);
			lista.aniadirOpcion(opcion9);
			assertEquals(lista.getTamano(),8);
			lista.aniadirOpcion(opcion7);
			assertEquals(lista.getTamano(),9);
		}
		catch(OpcionConMismoNombre e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe una opcion con ese nombre.");
		}
	}
}
