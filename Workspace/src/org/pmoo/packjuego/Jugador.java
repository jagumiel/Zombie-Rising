package org.pmoo.packjuego;

public class Jugador 
{
	private static Jugador miJugador=new Jugador("Dimitri");
	private boolean muerte;
	private String nombre;
	private int nivelSalud;
	private int danio;
	private Arma armaActual;
	private boolean victoria;
	
	private Jugador(String pNombre)
	{
		this.muerte=false;
		this.nombre=pNombre;
		this.nivelSalud=100;
		this.danio=0;
		this.armaActual=null;
		this.victoria=false;
	}
	
	public static Jugador getJugador()
	{
		return miJugador;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getNivelSalud()
	{
		return this.nivelSalud;
	}
	
	public int getDanio()
	{
		this.danio=this.getArmaActual().getDanio();
		return this.danio;
	}
	
	public Arma getArmaActual()
	{
		return this.armaActual;
	}
	
	public boolean estaMuerto()
	{
		return this.muerte;
	}
	
	
	public boolean getVictoria()
	{
		return this.victoria;
	}
	
	public void setVictoria(boolean pVic)
	{
		this.victoria=pVic;
	}
	
	public void disminuirSalud(int pDanio)
	{
		this.nivelSalud=this.nivelSalud - pDanio;
		if(this.nivelSalud<50)
		{
			this.aumentarSalud();
		}
		if(this.nivelSalud<=0)
		{
			this.nivelSalud=0;
			this.muerte=true;
		}
	}
	
	private void aumentarSalud()//CAMBIADO
	{
		int i=1;
		boolean sacado=false;
		Restaurador aux=null;
		while(i<=8&& !sacado)
		{
			aux=(Restaurador)Inventario.getInventario().sacarObjeto(i);
			if(aux!=null)
			{
				sacado=true;
			}
			i++;
		}
		if(sacado)
		{
			this.nivelSalud=this.nivelSalud + aux.getCantidad();
			if(this.nivelSalud>100)
			{
				this.nivelSalud=100;
			}
		}
	}
	
	public void atacar(Enemigo pEnemigo)
	{
		ConMunicion aux;
	
		pEnemigo.recibirDanio(this.getDanio());
		if(this.getArmaActual()instanceof ConMunicion)
		{
			aux=(ConMunicion)this.getArmaActual();
			aux.setNumeroMunicion(1);
			if(aux.getNumeroMunicion()==0)
			{
				this.equipar();
			}
		}
	}
	
	public void suicidarse ()
	{
		this.nivelSalud=0;
		this.muerte=true; 
		System.out.println("A causa de la presion que tienes en este momento decides que lo mejor es suicidarte.");
	}
		
	 
	public void equipar()
	{
		int i=1;
		
		while(i<=6 && this.getArmaActual()==null)
		{
			this.armaActual=(Arma)Inventario.getInventario().sacarObjeto(i);
			i++;
		}
	}
	
	public void guardarArma()
	{
		ConMunicion aux;
		try
		{
			if(this.getArmaActual() instanceof ConMunicion)
			{
				aux=(ConMunicion)this.getArmaActual();
				if(aux.getNumeroMunicion()>0)
				{
					Inventario.getInventario().anadirObjetoAlInventario(this.getArmaActual());
					this.armaActual=null;
				}
			}
			else
			{
				Inventario.getInventario().anadirObjetoAlInventario(this.getArmaActual());
				this.armaActual=null;
			}
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
			System.exit(0);
		}
	}
	
	public void cogerObjeto()
	{
		Mapa.getMapa().aniadirObjetoAlInventario();
	}
	
	public void resetear()
	{
		this.muerte=false;
		this.nivelSalud=100;
		this.danio=0;
		this.armaActual=null;
		this.victoria=false;
	}
}
