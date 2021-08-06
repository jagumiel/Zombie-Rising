package org.pmoo.packjuego;

import junit.framework.TestCase;

public class InventarioTest extends TestCase 
{

	Objeto objeto1;
	Objeto objeto2;
	Objeto objeto3;
	Objeto objeto4;
	
	protected void setUp()
	{
		Inventario.getInventario().inicializarInventario();
		objeto1=new ConMunicion(1, "Colt45", "Arma utilizada por cuerpos policiales del todo el mundo..",50,20);
		objeto2=new Restaurador(7,"botiquin","Te incrementa la vida 70hp",70);
		objeto3=new ConMunicion(4,"Pistola Magnum","arma de fuego pequena pero precisa.",25,10);
		objeto4=new ArmaBlanca(6,"Cuchillo Jamonero","Buen cuchillo para cortar jamon.",3);
	}

	protected void tearDown() 
	{
		objeto1=null;
		objeto2=null;
		objeto3=null;
	}
	
	public void testGetInventario()
	{
		assertNotNull(Inventario.getInventario());
	}
	
	public void testAnadirObjetoAlInventario()//COMPROBAR QUE NO HAY DOS OBJETOS CON EL MISMO ID
	{
		try
		{
			assertEquals(Inventario.getInventario().getTamano(),1);
			assertTrue(Inventario.getInventario().esta(objeto4));
			Inventario.getInventario().anadirObjetoAlInventario(objeto1);
			assertEquals(Inventario.getInventario().getTamano(),2);
			assertTrue(Inventario.getInventario().esta(objeto1));
			Inventario.getInventario().anadirObjetoAlInventario(objeto2);
			assertEquals(Inventario.getInventario().getTamano(),3);
			assertTrue(Inventario.getInventario().esta(objeto2));
			Inventario.getInventario().anadirObjetoAlInventario(objeto3);
			assertEquals(Inventario.getInventario().getTamano(),4);
			assertTrue(Inventario.getInventario().esta(objeto3));
		
			//ANIADIR UN OBJETO CON EL MISMO ID
			System.out.println("Deben de salir un mensaje de excepcion diciendo que ya existe un objeto con el mismo id. y muestra: ");
			System.out.println("======================================================================================");
			Inventario.getInventario().anadirObjetoAlInventario(objeto2);
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
		}
	}
	
	
	public void testEsta()
	{
		try
		{
			assertTrue(Inventario.getInventario().esta(objeto4));
			assertFalse(Inventario.getInventario().esta(objeto2));
			assertFalse(Inventario.getInventario().esta(objeto3));
			Inventario.getInventario().anadirObjetoAlInventario(objeto1);
			assertTrue(Inventario.getInventario().esta(objeto1));
			Inventario.getInventario().anadirObjetoAlInventario(objeto2);
			Inventario.getInventario().anadirObjetoAlInventario(objeto3);
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
		}
	}
	
	public void testSacarObjeto()
	{
		Objeto aux;
		
		try
		{
			assertEquals(Inventario.getInventario().getTamano(),1);
			Inventario.getInventario().anadirObjetoAlInventario(objeto1);
			assertEquals(Inventario.getInventario().getTamano(),2);
			Inventario.getInventario().anadirObjetoAlInventario(objeto2);
			assertEquals(Inventario.getInventario().getTamano(),3);
			Inventario.getInventario().anadirObjetoAlInventario(objeto3);
			assertEquals(Inventario.getInventario().getTamano(),4);
		
			aux=Inventario.getInventario().sacarObjeto(objeto2.getId());
			assertNotNull(aux);
			assertEquals(Inventario.getInventario().getTamano(),3);
			assertTrue(aux instanceof Restaurador);
		
			aux=Inventario.getInventario().sacarObjeto(objeto1.getId());
			assertNotNull(aux);
			assertEquals(Inventario.getInventario().getTamano(),2);
			assertTrue(aux instanceof ConMunicion);
		
			aux=Inventario.getInventario().sacarObjeto(objeto4.getId());
			assertNotNull(aux);
			assertEquals(Inventario.getInventario().getTamano(),1);
			assertTrue(aux instanceof ArmaBlanca);
		
			aux=Inventario.getInventario().sacarObjeto(objeto3.getId());
			assertNotNull(aux);
			assertEquals(Inventario.getInventario().getTamano(),0);
			assertTrue(aux instanceof ConMunicion);
		
			//SACAR UN OBJETO QUE NO EXISTA
			aux=Inventario.getInventario().sacarObjeto(objeto1.getId());
			assertNull(aux);
			assertEquals(Inventario.getInventario().getTamano(),0);
			assertFalse(aux instanceof ConMunicion);
		
			aux=Inventario.getInventario().sacarObjeto(objeto3.getId());
			assertNull(aux);
			assertEquals(Inventario.getInventario().getTamano(),0);
			assertFalse(aux instanceof ConMunicion);
		
			aux=Inventario.getInventario().sacarObjeto(objeto2.getId());
			assertNull(aux);
			assertEquals(Inventario.getInventario().getTamano(),0);
			assertFalse(aux instanceof Restaurador);
		
			aux=Inventario.getInventario().sacarObjeto(objeto4.getId());
			assertNull(aux);
			assertEquals(Inventario.getInventario().getTamano(),0);
			assertFalse(aux instanceof ArmaBlanca);
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
		}
	}
	
	public void testInicializarInventario()
	{
		try
		{
			assertEquals(Inventario.getInventario().getTamano(),1);
			assertTrue(Inventario.getInventario().esta(objeto4));
			Inventario.getInventario().anadirObjetoAlInventario(objeto1);
			assertEquals(Inventario.getInventario().getTamano(),2);
			assertTrue(Inventario.getInventario().esta(objeto1));
			Inventario.getInventario().anadirObjetoAlInventario(objeto2);
			assertEquals(Inventario.getInventario().getTamano(),3);
			assertTrue(Inventario.getInventario().esta(objeto2));
			Inventario.getInventario().anadirObjetoAlInventario(objeto3);
			assertEquals(Inventario.getInventario().getTamano(),4);
			assertTrue(Inventario.getInventario().esta(objeto3));
		
			Inventario.getInventario().inicializarInventario();
			assertEquals(Inventario.getInventario().getTamano(),1);
			assertTrue(Inventario.getInventario().esta(objeto4));
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
		}
	}
	
	public void testGetTamano()
	{
		try
		{
			assertEquals(Inventario.getInventario().getTamano(),1);
			Inventario.getInventario().anadirObjetoAlInventario(objeto1);
			assertEquals(Inventario.getInventario().getTamano(),2);
			Inventario.getInventario().anadirObjetoAlInventario(objeto2);
			assertEquals(Inventario.getInventario().getTamano(),3);
			Inventario.getInventario().anadirObjetoAlInventario(objeto3);
			assertEquals(Inventario.getInventario().getTamano(),4);
			
			Inventario.getInventario().sacarObjeto(objeto2.getId());
			assertEquals(Inventario.getInventario().getTamano(),3);
			Inventario.getInventario().sacarObjeto(objeto1.getId());
			assertFalse(Inventario.getInventario().getTamano()==4);
			
			Inventario.getInventario().sacarObjeto(objeto1.getId());
			assertEquals(Inventario.getInventario().getTamano(),2);
			Inventario.getInventario().sacarObjeto(objeto1.getId());
			assertFalse(Inventario.getInventario().getTamano()==3);
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
		}
	}
}
