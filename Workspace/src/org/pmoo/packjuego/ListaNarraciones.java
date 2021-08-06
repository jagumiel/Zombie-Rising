package org.pmoo.packjuego;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaNarraciones 
{
	private static ListaNarraciones miListaNarraciones=new ListaNarraciones();
	private ArrayList<Narracion> lista;
	
	private ListaNarraciones() //CAMBIADO
	{
		this.lista=new ArrayList<Narracion>();
	}
	
	public static ListaNarraciones getListaNarraciones()
	{
		return miListaNarraciones;
	}
	
	private ArrayList<Narracion> getLista()
	{
		return this.lista;
	}
	
	private Iterator<Narracion> getIterador()
	{
		return this.getLista().iterator();
	}
	
	public Narracion buscarNarracionPorId(String pId)
	{
		Narracion aux=null;
		Iterator<Narracion>itr=this.getIterador();
		boolean enc=false;
		
		while(itr.hasNext()&&!enc)
		{
			aux=itr.next();
			if(aux.getId().equals(pId))
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
	
	public void aniadirNarracion(Narracion pNarracion)
	{
		if(this.buscarNarracionPorId(pNarracion.getId())!=null)
		{
		}
		else
		{
			this.getLista().add(pNarracion);
		}
	}
	
	public void resetear()
	{
		this.getLista().clear();
	}
	
	public void inicializarLista()
	{
		//DETALLADAS
		
		
			this.aniadirNarracion(new Narracion("Te encuentras en una habitacion acolchada. Llevas una camisa que te impide mover"+" Si coges este cristal, te ayudara a liberarte."+" Una vez que te hayas liberado podras acercarte a la puerta y salir","132"));	
			this.aniadirNarracion(new Narracion("En el periodico hay un simbolo nuclear Habra pasado algo?,"+" Catastrofe nuclear en Prypiat (el periodico resalta)","232"));
			this.aniadirNarracion(new Narracion("Parece que al fondo que hay unas escaleras.","222"));
			this.aniadirNarracion(new Narracion("En estas habitaciones es donde ataban a los locos. Aun retumban entre las paredes sus gritos desgarradores (hay una mascara en el suelo)."+" Has recogido un objeto que te puede servir en el futuro","242"));
			this.aniadirNarracion(new Narracion("Esto parece que era una cocina","224"));
			this.aniadirNarracion(new Narracion("Ya has salido del manicomio. Hay un pequeno jardin, pero no hay mucha vegetacion. Cuidado con la radiacion.","130"));
			this.aniadirNarracion(new Narracion("Estas en una interseccion, elige bien tu camino, nunca sabes lo que te puede pasar.","330"));
			this.aniadirNarracion(new Narracion("Puede que en este viejo almacen quimico haya medicinas."+" (Manejar con precaucion) ","221"));
			this.aniadirNarracion(new Narracion("Te encuentras en el recibidor. Hace frio y esta todo oscuro. Todo esta destartalado","131"));
			this.aniadirNarracion(new Narracion("Estas fuera del psiquiatrico. Es tarde, pronto caera la noche."+" Hay algo raro en el ambiente","230"));
			this.aniadirNarracion(new Narracion("Estas en la cocina, el hambre aprieta despues de la siesta que te has echado, eh? lastima que no haya nada util.","241"));
			this.aniadirNarracion(new Narracion("Estas de camino a la central nuclear de Prypiat. Eso que sale del reactor parece un humo verde."+" Cuidado, no les des tu cerebro! (Pone en un cartel cercano)","340"));
			this.aniadirNarracion(new Narracion("Desde aqui se puede ver el parque de atracciones","320"));
			this.aniadirNarracion(new Narracion("Parece que el reactor ha reventado. Hay muchas victimas y algunos estan mutando."+" Ya casi no hay luz. Yo que tu me preparia para lo que viene","350"));
			this.aniadirNarracion(new Narracion("Esto es el pasillo del psiquiatrico.","231"));
			this.aniadirNarracion(new Narracion("Aquello de alli parecen edificios","410"));
			this.aniadirNarracion(new Narracion("Estas en la habitacion, registra a ver si encuentras la tarjeta de la que te hablo aquel misterioso extrano.","051"));
			this.aniadirNarracion(new Narracion("Estas en las escaleras, busca a ver si alguien se ha dejado algo por ahi tirado.","151"));
			this.aniadirNarracion(new Narracion("Notas como la radiacion te afecta a los organos, eh? Este traje puede que te salve","351"));
			this.aniadirNarracion(new Narracion("La radiacion es muy alta. Te afecta a la salud","352"));
			this.aniadirNarracion(new Narracion("La sala esta vacia. En esa mesa de altos cargos puede que haya algun objeto de interes","353"));
			this.aniadirNarracion(new Narracion("Aqui huele a victoria, estas cerca.","210"));
			this.aniadirNarracion(new Narracion("Este parque de atracciones esta un poco descuidado. Parece mentira que un dia hubo ninios riendo y jugando","310"));
			this.aniadirNarracion(new Narracion("Estas en un bosque tenue y frondoso... Te has metido en un buen lio, amigo. La oscuridad se cierne sobre ti. De repente oyes jadeos. Hasta luego","300"));
			this.aniadirNarracion(new Narracion("El tren! Al fin! Salvacion. Oh, no, espero que hayas cogido municion porque esos zombis parecen hambrientos","110"));
			this.aniadirNarracion(new Narracion("Aqui es donde termina tu viaje, si has matado a todos los zombies y logras matar al zombie final podras salvarte. Va a ser una batalla determinante.","010"));
			this.aniadirNarracion(new Narracion("La estetica comunista de estos apartamentos tampoco ha cambiado nada.Sube por las escaleras y entra en la habitacion, si te atreves.","510"));
			this.aniadirNarracion(new Narracion("Estas en la escalera, revisa por si acaso encuentras algo. Aunque todo esto es bastante tenebroso.","511"));
			this.aniadirNarracion(new Narracion("Los balones ya no resuenan en esta cancha de basket. Solo se escuchan tus pasos y tu respiracion.","521"));
			this.aniadirNarracion(new Narracion("Yo que tu registraria el lugar","501"));
			this.aniadirNarracion(new Narracion("Este olor a cloro no falla. Estas en el polideportivo","530"));
			this.aniadirNarracion(new Narracion("Esta era una piscina olimpica, no creo que te apetezca darte un banito radioactivo, verdad?","532"));
			this.aniadirNarracion(new Narracion("Estas en la recepcion. Como comprenderas no hay nadie vigilando, adelante, campa a tus anchas.","531"));
			this.aniadirNarracion(new Narracion("Que hay en esa taquilla entreabierta?","541"));
			this.aniadirNarracion(new Narracion("Esa fabrica parece tenebrosa. Yo que tu no entraria, pero cada uno es artifice de su propio holocausto..","440"));
			this.aniadirNarracion(new Narracion("Te lo dije, esto huele me huele muy mal, no vas a acabar bien.","441"));
			this.aniadirNarracion(new Narracion("Aqui se acaba todo, y ahora, como sales de aqui?","451"));
			this.aniadirNarracion(new Narracion("Estas en otra interseccion, decide, o la fabrica o el polideportivo.","430"));
		
	}
	
	public int getTamano()
	{
		return this.getLista().size();
	}
	
}
