package org.pmoo.packjuego;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeOpciones 
{
	private ArrayList<Opcion> lista;
	
	public ListaDeOpciones()
	{
		this.lista=new ArrayList<Opcion>();
	}
	
	private ArrayList<Opcion> getLista()
	{
		return this.lista;
	}
	
	private Iterator<Opcion> getIterador()
	{
		return this.getLista().iterator();
	}
	
	public Opcion buscarOpcion(String pNombre)
	{
		Iterator<Opcion>itr=this.getIterador();
		Opcion aux=null;
		boolean enc=false;
		
		while(itr.hasNext()&&!enc)
		{
			aux=itr.next();
			if(aux.getOpcion().equals(pNombre))
			{
				enc=true;
			}
		}
		if(!enc)
		{
			aux=null;
		}
		
		return aux;
	}
	
	public void aniadirOpcion(Opcion pOpcion) throws OpcionConMismoNombre//SI OPCION EXISTE NO LA ANIADE (excepcion)
	{
		if(this.buscarOpcion(pOpcion.getOpcion())!=null)
		{
			throw new OpcionConMismoNombre();
		}
		else
		{
			this.getLista().add(pOpcion);
		}
	}
	
	public void resetear()
	{
		this.getLista().clear();
	}
	
	public void imprimirOpciones()
	{
		Iterator<Opcion>itr=this.getIterador();
		Opcion pOpcion;
		
		while(itr.hasNext())
		{
			pOpcion=itr.next();
			if(pOpcion.getHabilitar())
			{
				System.out.println(pOpcion.getOpcion());
			}
		}
	}
	
	public int getTamano()//NUEVO para las junits
	{
		return this.getLista().size();
	}
}
