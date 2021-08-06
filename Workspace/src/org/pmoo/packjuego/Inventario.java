package org.pmoo.packjuego;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario 
{
	private static Inventario miInventario=new Inventario();
	private ArrayList<Objeto> lista;
	
	private Inventario()
	{
		this.lista=new ArrayList<Objeto>();
	}
	public static Inventario getInventario()
	{
		return miInventario;
	}
	
	private ArrayList<Objeto> getLista()
	{
		return this.lista;
	}
	
	private Iterator<Objeto> getIterador()
	{
		return this.getLista().iterator();
	}
	
	public void anadirObjetoAlInventario(Objeto pObjeto)throws ObjetoConMismoId
	{
		if(this.esta(pObjeto))
		{
			throw new ObjetoConMismoId();
		}
		else
		{
			this.getLista().add(pObjeto);
		}
	}
	
	private void eliminarObjeto(Objeto pObjeto)
	{
		this.getLista().remove(pObjeto);
	}
	
	public boolean esta(Objeto pObjeto)//NUEVO PARA JUNITS
	{
		boolean enc=false;
		Iterator<Objeto>itr=this.getIterador();
		Objeto aux;
		
		while(itr.hasNext()&&!enc)
		{
			aux=itr.next();
			if(aux.getId()==pObjeto.getId())
			{
				enc=true;
			}
		}
		
		return enc;
	}
	
	
	public Objeto sacarObjeto(int pId) //////MEJORADO
	{
		Objeto aux=null;
		Objeto aux2=null;
		
		boolean enc=false;
		Iterator<Objeto>itr=this.getIterador();
		
		
		while(itr.hasNext() && !enc)
		{
			aux=itr.next();
			if(aux.getId()==pId)
			{
				enc=true;
				this.eliminarObjeto(aux);
			}
		}
		if(!enc)
		{
			aux=null;
		}
		else
		{
			if(aux instanceof Restaurador)
			{
				aux2=(Restaurador)aux;
			}
			else
			{
				if(aux instanceof ConMunicion)
				{
					aux2=(ConMunicion)aux;
				}
				else
				{
					aux2=(ArmaBlanca)aux;
				}
			}
		}
		return aux2;
	}

	
	public void inicializarInventario()
	{
		try
		{
			this.resetear();
			Objeto cuchillo =new ArmaBlanca(6,"Cuchillo Jamonero","Buen cuchillo para cortar jamon.",3);
			this.anadirObjetoAlInventario(cuchillo);
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
			System.exit(0);
		}
	}
	
	private void resetear()
	{
		this.getLista().clear();
	}
	
	public int getTamano()
	{
		return this.getLista().size();
	}
}
