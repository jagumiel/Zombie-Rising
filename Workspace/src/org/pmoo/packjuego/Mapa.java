package org.pmoo.packjuego;

import java.util.Scanner;

public class Mapa 
{
	private static Mapa miMapa=new Mapa();
	private  ListaDeLugares matriz;
	private int posicionFila,posicionColumna,posicionAltura;
	private String CoordenadaActual;
	private Lugar lugarActual;
	
	private Mapa()
	{
		this.posicionFila=0;
		this.posicionColumna=0;
		this.posicionAltura=0;
		this.matriz=new ListaDeLugares();
		this.lugarActual=null;
	}
	
	public static Mapa getMapa()
	{
		return miMapa;
	}
	
	private ListaDeLugares getMatriz()
	{
		return this.matriz;
	}
	
	private String getCoordenadaActual()
	{
		this.CoordenadaActual=Integer.toString(this.getPosicionFila())+Integer.toString(this.getPosicionColumna())+Integer.toString(this.getPosicionAltura());
		
		return this.CoordenadaActual;
	}
	
	public Lugar getLugarActual()
	{
		this.lugarActual=this.getMatriz().getLugar(this.getPosicionFila(),this.getPosicionColumna(),this.getPosicionAltura());
		return this.lugarActual;
	}
	
	private void partidaGanada()
	{
		if(this.getCoordenadaActual().equals("010")&&Juego.getJuego().getNumeroDeEnemigos()==0)
		{
			Jugador.getJugador().setVictoria(true);
		}
	}
	
	private int getPosicionFila()
	{
		return this.posicionFila;
	}
	
	private int getPosicionColumna()
	{
		return this.posicionColumna;
	}
	
	private int getPosicionAltura()
	{
		return this.posicionAltura;
	}
	
	private void iniciarLista()
	{            
		Enemigo nuevoEnemigo;
		nuevoEnemigo=new Enemigo (50,5);
		
			//Planta B
			//Fila1: La primera linea equivale a la posición 0,0 en el eje de coordenadas x,y.
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,0,0);
			Enemigo enemigoFinal=new Enemigo(200,15);
			this.getMatriz().aniadirLugar(new Lugar("La Estacion de Tren",enemigoFinal,null,true,false,false,false,false,false),0,1,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,2,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,3,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,4,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,5,0);
	
			//Fila2:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,0,0);
			Objeto botiquin=new Restaurador(16,"botiquin","Te incrementa la vida 70hp",70);
			this.getMatriz().aniadirLugar(new Lugar("Los Tuneles",nuevoEnemigo,botiquin,true,true,false,false,false,false),1,1,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,2,0);
			this.getMatriz().aniadirLugar(new Lugar("El Psiquiatrico",null,null,true,false,false,false,true,false),1,3,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,4,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,5,0);
	
			//Fila3:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,0,0);
			this.getMatriz().aniadirLugar(new Lugar("Calle de la Libertad",null,null,true,true,false,false,false,false),2,1,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,2,0);
			this.getMatriz().aniadirLugar(new Lugar("Camino del Psiquiatrico",null,null,true,true,false,false,false,false),2,3,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,4,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,5,0);
			
			//Fila4:
			Enemigo nuevoEnemigo2=new Enemigo(200,30);
			this.getMatriz().aniadirLugar(new Lugar("El Bosque",nuevoEnemigo2,null,false,false,true,false,false,false),3,0,0);
			//Objeto llave=new Miscelanea(7,"llave","Llave para abrir alguna puerta.",true);
			this.getMatriz().aniadirLugar(new Lugar("El Parque de Atracciones",nuevoEnemigo,null,true,true,true,true,false,false),3,1,0);
			this.getMatriz().aniadirLugar(new Lugar("Camino del Parque",null,null,false,false,true,true,false,false),3,2,0);
			this.getMatriz().aniadirLugar(new Lugar("Interseccion 1",null,null,true,true,true,true,false,false),3,3,0);
			this.getMatriz().aniadirLugar(new Lugar("Camino de la Central",null,null,false,false,true,true,false,false),3,4,0);
			this.getMatriz().aniadirLugar(new Lugar("Central Nuclear",null,null,false,false,false,true,true,false),3,5,0);
	
			//Fila5:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,0,0);
			this.getMatriz().aniadirLugar(new Lugar("Camino del Poblado",null,null,true,true,false,false,false,false),4,1,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,2,0);
			this.getMatriz().aniadirLugar(new Lugar("Interseccion 3",null,null,true,true,true,false,false,false),4,3,0);
			this.getMatriz().aniadirLugar(new Lugar("La vieja fabrica",null,null,false,false,false,false,true,false),4,4,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,5,0);
	
			//Fila6:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,0,0);
			Objeto pistolaMagnum=new ConMunicion(4,"Pistola Magnum","arma de fuego pequena pero precisa.",25,10);
			this.getMatriz().aniadirLugar(new Lugar("Portal del apartamento",null,pistolaMagnum,false,true,false,false,true,false),5,1,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,2,0);
			this.getMatriz().aniadirLugar(new Lugar("Polideportivo",null,null,false,true,false,false,true,false),5,3,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,4,0);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,5,0);
			
			//Planta1 (Aquí estan las plantas bajas de los edificios.
			//Fila1: La primera linea equivale a la posición 0,0 en el eje de coordenadas x,y.
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,0,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,1,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,2,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,3,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,4,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,5,1);
	
			//Fila2:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,0,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,1,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,2,1);
			this.getMatriz().aniadirLugar(new Lugar("El Hall",null,null,true,false,false,false,false,true),1,3,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,4,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,5,1);
	
			//Fila3:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,0,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,1,1);
			//Objeto acido=new Miscelanea(8, "Acido Sulfurico", "Un potente y efectivo quimico. No lo ingieras",false);
			this.getMatriz().aniadirLugar(new Lugar("El Almacen Quimico",null,null,false,false,true,false,true,false),2,2,1);
			this.getMatriz().aniadirLugar(new Lugar("El Corredor",null,null,false,true,true,true,false,false),2,3,1);
			this.getMatriz().aniadirLugar(new Lugar("La Cocina",null,null,false,false,false,true,true,false),2,4,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,5,1);
			
			//Fila4:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,0,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,1,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,2,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,3,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,4,1);
			this.getMatriz().aniadirLugar(new Lugar("El Recibidor de la Central",null,null,false,false,false,false,true,true),3,5,1);
	
			//Fila5:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,0,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,1,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,2,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,3,1);
			this.getMatriz().aniadirLugar(new Lugar("La Entrada de la Fabrica",null,null,false,false,true,false,true,false),4,4,1);//Si sale hay zombie.
			this.getMatriz().aniadirLugar(new Lugar("El taller",null,null,false,false,false,false,false,false),4,5,1);//Le cae algo en la cabeza y muere.
	
			//Fila6:
			this.getMatriz().aniadirLugar(new Lugar("La Habitacion del Apartamento",null,null,false,false,true,false,false,false),5,0,1);
			Objeto colt=new ConMunicion(3, "Colt45", "Arma utilizada por cuerpos policiales del todo el mundo..",50,20);
			this.getMatriz().aniadirLugar(new Lugar("El descansillo",null,colt,false,false,false,true,false,true),5,1,1);		
			this.getMatriz().aniadirLugar(new Lugar("La Cancha de Basket",null,null,false,false,true,false,false,false),5,2,1);
			this.getMatriz().aniadirLugar(new Lugar("El Hall del polideportivo",null,null,false,false,true,true,true,true),5,3,1);
			Objeto escopeta= new ConMunicion(2,"Escopeta Recortada","Un buen arma para atacar de cerca, pero no tiene mucho alcance.",5,10);
			this.getMatriz().aniadirLugar(new Lugar("Los Vestuarios",null,escopeta,false,false,false,true,false,false),5,4,1);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,5,1);
			
			//Planta2
			//Fila1: La primera linea equivale a la posición 0,0 en el eje de coordenadas x,y.
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,0,2);	
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,1,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,2,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,3,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,4,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,5,2);
	
			//Fila2:
			//Objeto nuevoObjeto=new Miscelanea(10," un Cristal","cristal de una ventana",true);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,0,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,1,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,2,2);
			this.getMatriz().aniadirLugar(new Lugar("El Cuarto",null,null,true,false,false,false,false,false),1,3,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,4,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,5,2);
	
			//Fila3:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,0,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,1,2);
			Objeto mascaraGas=new Restaurador(11,"Mascara Antigas", "Si no quieres morir, mas te vale que la lleves puesta.",0);
			this.getMatriz().aniadirLugar(new Lugar("La Habitacion",null,mascaraGas,false,false,true,false,false,true),2,2,2);
			Objeto metralleta=new ConMunicion(1,"metralleta", "una potente arma", 200, 10);
			this.getMatriz().aniadirLugar(new Lugar("El Pasillo",null,metralleta,false,true,true,true,false,false),2,3,2);
			this.getMatriz().aniadirLugar(new Lugar("La Habitacion",null,null,false,false,false,true,false,true),2,4,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,5,2);
			
			//Fila4:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,0,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,1,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,2,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,3,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,4,2);
			this.getMatriz().aniadirLugar(new Lugar("La Sala de Control del Reactor",null,null,false,false,false,false,true,true),3,5,2);
	
			//Fila5:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,0,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,1,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,2,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,3,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,4,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,5,2);
	
			//Fila6:
	
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,2,2);
			Objeto botiquin2=new Restaurador(17,"botiquin","Te incrementa la vida 70hp",70);
			this.getMatriz().aniadirLugar(new Lugar("La Piscina",null,botiquin2,false,false,false,false,false,true),5,3,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,4,2);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,5,2);
			
			//Planta3
			//Fila1: La primera linea equivale a la posición 0,0 en el eje de coordenadas x,y.
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,0,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,1,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,2,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,3,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,4,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),0,5,3);
	
			//Fila2:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,0,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,1,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,2,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,3,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,4,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),1,5,3);
	
			//Fila3:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,0,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,1,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,2,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,3,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,4,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),2,5,3);
			
			//Fila4:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,0,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,1,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,2,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,3,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),3,4,3);
			//Objeto llaveReactor=new Miscelanea(13,"Llave del reactor","Sirve para encender y apagar el reactor nuclear.",true);
			this.getMatriz().aniadirLugar(new Lugar("La Sala de Empleados",null,null,false,false,false,false,false,true),3,5,3);
	
			//Fila5:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,0,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,1,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,2,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,3,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,4,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),4,5,3);
	
			//Fila6:
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,0,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,1,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,2,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,3,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,4,3);
			this.getMatriz().aniadirLugar(new Lugar(null,null,null,false,false,false,false,false,false),5,5,3);

	} 
	
	public void iniciarMapa()
	{
		this.iniciarLista();
		this.posicionFila=1;
		this.posicionColumna=3;
		this.posicionAltura=2; //Esto decide en que lugar del mapa empiezas.
	}
	
	public void preguntar()
	{
		String dato;
		
		Scanner entrada=new Scanner(System.in);
		System.out.println("¿Que quieres hacer?: ");
		this.getLugarActual().mostrarOpciones();
		System.out.println("");
		dato=entrada.next();
				this.realizarAccion(dato);
	}
	
	public void imprimirSituacion()
	{
		this.getLugarActual().mostrarNarracion(this.getCoordenadaActual());
		if(this.getLugarActual().getObjeto()!=null&&this.getLugarActual().getObjeto().getId()==11)
		{
			Jugador.getJugador().cogerObjeto();
		}
			System.out.println("");
	}
	
	public void realizarAccion(String pAccion)
	{
		if(this.getLugarActual().estaOpcion(pAccion))
		{
			this.getLugarActual().realizarAccion(pAccion);
		}
		else
		{
			System.out.println("opcion incorrecta");
		}
	}
	public void aniadirObjetoAlInventario()
	{
		try
		{
			Inventario.getInventario().anadirObjetoAlInventario(this.getLugarActual().getObjeto());
			System.out.println("has recogido "+this.getLugarActual().getObjeto().getNombre()+" y lo has aniadido a tu inventario.");
			this.getLugarActual().borrarObjeto();
		}
		catch(ObjetoConMismoId e)
		{
			System.out.println("Se ha producido una excepcion.Ya existe un objeto con el mismo id.");
			System.exit(0);
		}
	}
	
	public void moverse(String pDireccion)
	{
		switch(pDireccion)
		{
		case "norte":{
						if(this.getLugarActual().getNorte()==false)
						{
							System.out.println("No se puede ir hacia el Norte.");
						}
						else
						{
							this.getLugarActual().yaVisiatado();
							this.posicionFila=this.getPosicionFila() + 1;
							this.imprimirSituacion();
						}
						break;
					 }
		
		case "sur":{
						if(this.getLugarActual().getSur()==false)
						{
							System.out.println("No se puede ir hacia el Sur.");
						}
						else
						{
							this.getLugarActual().yaVisiatado();
							this.posicionFila=this.getPosicionFila() - 1;
							this.imprimirSituacion();
						}
						break;
					 }
			
		case "este":{
						if(this.getLugarActual().getEste()==false)
						{
							System.out.println("No se puede ir hacia el Este.");
						}
						else
						{
							this.getLugarActual().yaVisiatado();
							this.posicionColumna=this.getPosicionColumna() + 1;
							this.imprimirSituacion();
						}
						break;
			 		 }
		
		case "oeste":{
						if(this.getLugarActual().getOeste()==false)
						{
							System.out.println("No se puede ir hacia el Oeste.");
						}
						else
						{
							this.getLugarActual().yaVisiatado();
							this.posicionColumna=this.getPosicionColumna() - 1;
							this.imprimirSituacion();
						}
						break;
			 		 }
		
		case "subir":{
						if(this.getLugarActual().getSubir()==false)
						{
							System.out.println("No se puede subir.");
						}
						else
						{
							this.getLugarActual().yaVisiatado();
							this.posicionAltura=this.getPosicionAltura() + 1;
							this.imprimirSituacion();
						}
						break;
					}

		case "bajar":{
						if(this.getLugarActual().getBajar()==false)
						{
							System.out.println("No se puede bajar.");
						}
						else
						{
							this.getLugarActual().yaVisiatado();
							this.posicionAltura=this.getPosicionAltura() - 1;
							this.imprimirSituacion();
						}
						break;
					}
		}
		this.partidaGanada();
	}
}
