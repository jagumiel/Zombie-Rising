package org.pmoo.packjuego;

import junit.framework.TestCase;

public class ListaDeLugaresTest extends TestCase 
{
	Lugar lugarNuevo1;
	Lugar lugarNuevo2;
	Lugar lugarNuevo3;
	Lugar lugarNuevo4;
	ListaDeLugares lista;
	
	protected void setUp() 
	{
		lugarNuevo1=new Lugar("La Sala de Control del Reactor",null,null,false,false,false,false,true,true);//3,5,2
		lugarNuevo2=new Lugar("Central Nuclear",null,null,false,false,false,true,true,false);//3,5,0
		lugarNuevo3=new Lugar("El taller",null,null,false,false,false,false,false,false);//4,5,1
		lugarNuevo4=new Lugar("La Sala de Empleados",null,null,false,false,false,false,false,true);//3,5,3
		lista=new ListaDeLugares();
	}

	protected void tearDown() 
	{
		lugarNuevo1=null;
		lugarNuevo2=null;
		lugarNuevo3=null;
		lista=null;
	}
	
}
