package org.pmoo.packjuego;

public class Lugar 
{
	private boolean tieneEnemigo;
	private boolean visitado;
	private String descripcion;
	private boolean n,s,e,o,u,d;
	private ListaDeOpciones listaOpciones=new ListaDeOpciones();
	private Enemigo enemigo;
	private Narracion narracion;
	private Objeto unObjeto;
	
	public Lugar(String pDescripcion,Enemigo pEnemigo,Objeto pObjeto,boolean pNorte,boolean pSur,boolean pEste,boolean pOeste,boolean pSubir,boolean pBajar)
	{
		this.descripcion=pDescripcion;
		this.visitado=false;
		this.enemigo=pEnemigo;
		this.unObjeto=pObjeto;
		this.n=pNorte;
		this.s=pSur;
		this.e=pEste;
		this.o=pOeste;
		this.u=pSubir;
		this.d=pBajar;
		this.inicializarListaOpciones();
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	
	private boolean tieneEnemigo()
	{
		if(this.enemigo!=null)
		{
			this.tieneEnemigo=true;
		}
		else
		{
			this.tieneEnemigo=false;
		}
		return this.tieneEnemigo;
	}
	
	public boolean getVisitado()
	{
		return this.visitado;
	}
	
	public void yaVisiatado()
	{
		this.visitado=true;
	}
	
	public boolean getNorte()
	{
		return this.n;
	}
	
	public boolean getSur()
	{
		return this.s;
	}
	
	public boolean getEste()
	{
		return this.e;
	}
	
	public boolean getOeste()
	{
		return this.o;
	}
	
	public boolean getSubir()
	{
		return this.u;
	}
	
	public boolean getBajar()
	{
		return this.d;
	}
	
	public Narracion getNarracion()
	{
		return this.narracion;
	}
	
	public ListaDeOpciones getListaOpciones()
	{
		return this.listaOpciones;
	}
	
	
	public void activarOpcion(String pNombre)
	{
		this.getListaOpciones().buscarOpcion(pNombre).setHabilitar(true);
	}
	
	public void desactivarOpcion(String pNombre)
	{
		this.getListaOpciones().buscarOpcion(pNombre).setHabilitar(false);
	}
	
	public boolean estaOpcion(String pNombre)
	{
		boolean enc=false;
		Opcion pOpcion;
		
		pOpcion=this.getListaOpciones().buscarOpcion(pNombre);
		if(pOpcion!=null&&pOpcion.getHabilitar())
		{
			enc=true;
		}
		return enc;
	}
	
	public void mostrarNarracion(String pId)
	{
		if(!this.getVisitado())
		{
			this.narracion=ListaNarraciones.getListaNarraciones().buscarNarracionPorId(pId);
			System.out.println(this.getNarracion().getNarracion());
		}
		else
		{
			System.out.println("Estas en "+this.getDescripcion());
		}
	}
	
	public Enemigo getEnemigo()
	{
		return this.enemigo;
	}
	
	public void borrarEnemigo()
	{
		this.enemigo=null;
	}
	
	private void inicializarListaOpciones()
	{
		this.aniadirOpcionALaLista(new Opcion("coger"));
		this.aniadirOpcionALaLista(new Opcion("norte"));
		this.aniadirOpcionALaLista(new Opcion("sur"));
		this.aniadirOpcionALaLista(new Opcion("este"));
		this.aniadirOpcionALaLista(new Opcion("oeste"));
		this.aniadirOpcionALaLista(new Opcion("subir"));
		this.aniadirOpcionALaLista(new Opcion("bajar"));
		this.aniadirOpcionALaLista(new Opcion("atacar"));
		this.aniadirOpcionALaLista(new Opcion("suicidarse"));
	}
	
	private void actualizarListaOpciones()
	{
		if(this.getObjeto()!=null)
		{
			this.activarOpcion("coger");
		}
		else
		{
			this.desactivarOpcion("coger");
		}
		if(this.getNorte()&&!this.tieneEnemigo())
		{
			this.activarOpcion("norte");
		}
		else
		{
			this.desactivarOpcion("norte");
		}
		if(this.getSur()&&!this.tieneEnemigo())
		{
			this.activarOpcion("sur");
			
		}
		else
		{
			this.desactivarOpcion("sur");
		}
		if(this.getEste()&&!this.tieneEnemigo())
		{
			this.activarOpcion("este");
			
		}
		else
		{
			this.desactivarOpcion("este");
		}
		if(this.getOeste()&&!this.tieneEnemigo())
		{
			this.activarOpcion("oeste");
			
		}
		else
		{
			this.desactivarOpcion("oeste");
		}
		if(this.getSubir()&&!this.tieneEnemigo())
		{
			this.activarOpcion("subir");
			
		}
		else
		{
			this.desactivarOpcion("subir");
		}
		if(this.getBajar()&&!this.tieneEnemigo())
		{
			this.activarOpcion("bajar");
			
		}
		else
		{
			this.desactivarOpcion("bajar");
		}
		if(this.getEnemigo()!=null)
		{
			this.activarOpcion("atacar");
		}
		else
		{
			this.desactivarOpcion("atacar");
		}
	}
	
	public void realizarAccion(String pAccion)
	{
		
		switch(pAccion)
		{
			case "atacar":
			{
				Juego.getJuego().realizarCombate(this);
				break;
			}
			
			case "suicidarse":
			{
				Jugador.getJugador().suicidarse();
				break;
			}
			
			case "norte":
			{
				Mapa.getMapa().moverse(pAccion);
				break;
			}
			
			case "sur":
			{
				Mapa.getMapa().moverse(pAccion);
				break;
			}
			
			case "este":
			{
				Mapa.getMapa().moverse(pAccion);
				break;
			}
			
			case "oeste":
			{
				Mapa.getMapa().moverse(pAccion);
				break;
			}
			
			case "subir":
			{
				Mapa.getMapa().moverse(pAccion);
				break;
			}
			
			case "bajar":
			{
				Mapa.getMapa().moverse(pAccion);
				break;
			}
			
			case "coger":
			{
				Jugador.getJugador().cogerObjeto();
				break;
			}
		}
	}
	
	public void mostrarOpciones()
	{
		System.out.println("*********************");
		System.out.println("Opciones Disponibles:");
		System.out.println("*********************");
		this.actualizarListaOpciones();
		this.getListaOpciones().imprimirOpciones();
	}
	
	public void aniadirOpcionALaLista(Opcion pOpcion)
	{
		try
		{
			this.getListaOpciones().aniadirOpcion(pOpcion);
		}
		catch(OpcionConMismoNombre e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe una opcion con ese nombre.");
			System.exit(0);
		}
	}
	
	public Objeto getObjeto()
	{
		return this.unObjeto;
	}
	
	public void borrarObjeto()
	{
		this.unObjeto=null;
	}
}
