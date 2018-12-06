package com.example.restproyect.hilos;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.Callable;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.states.objetosinternos.Pastura;

public class TareaRastrojo implements Callable<ArrayList<Documento>>{

	private ArrayList<Pastura> digestibilidadVariaciones;
	private ArrayList<Pastura> rindeVariaciones;
	private FiltroAbs filtro;
	private Documento doc;
	private int numero;
	
	
	
	public TareaRastrojo(ArrayList<Pastura> digestibilidadVariaciones, ArrayList<Pastura> rindeVariaciones, FiltroAbs filtro,
			Documento doc, int numero) {
		super();
		this.digestibilidadVariaciones = digestibilidadVariaciones;
		this.rindeVariaciones = rindeVariaciones;
		this.filtro = filtro;
		this.doc = doc;
		this.numero = numero;
	}



	public ArrayList<Documento> call() {	
		ArrayList<Documento> documentosGenerados = new ArrayList<>();
		System.out.println("***************************************************************************************");
		System.out.println("Documento numero ="+this.numero);
		for(int indexVariaciones = 0; indexVariaciones < digestibilidadVariaciones.get(0).getPasturas().size(); indexVariaciones++) {
//			Document newDocument = this.doc.getDocumento();			
////			System.out.println("Variacion numero["+indexVariaciones+"] de la tarea numero ["+this.numero+"]");
//			Documento doc = new Documento(newDocument);			
//			Document insertDoc = doc.clonarDocumento();
//			newDocument = null;
//			
//			doc.setDocumento(insertDoc);
			
			//Para cada tag dentro del tag <escenario> Busco los tags que tienen las variaciones
			NodeList node = doc.getDocumento().getChildNodes().item(0).getChildNodes();		
			for(int j=0; j < node.getLength(); j++) {
				/*
				 * indice par es un text dentro de los tags, solo 
				 * se trabaja con los elementos impares
				 * que son los TAGS
				 */
				if(j%2 != 0) {
					
						Node nodo =  node.item(j);
						if(filtro.cumple(nodo)) {
							//Obtengo la pastura a variar								
							NodeList nodePastura = node.item(j).getChildNodes();						
							
							for(int indexPastura = 0; indexPastura < digestibilidadVariaciones.size(); indexPastura++) {				
								//Formula para obtener la pastura que va a variar
								System.out.println("Variacion numero["+indexVariaciones+"] de la tarea numero ["+this.numero+"] de la PASTURA ["+indexPastura+"]");
								Node nodoPastura = nodePastura.item(indexPastura*2+1);	
								nodoPastura.getAttributes().getNamedItem("crop_stubbleDigest").setNodeValue(String.valueOf(digestibilidadVariaciones.get(indexPastura).next()));
								nodoPastura.getAttributes().getNamedItem("yield").setNodeValue(String.valueOf(rindeVariaciones.get(indexPastura).next()));
								System.out.println("FIN DE LA Variacion numero["+indexVariaciones+"] de la tarea numero ["+this.numero+"] de la PASTURA ["+indexPastura+"]");
							}	
//							System.err.print("FIN DE LA Variacion numero["+indexVariaciones+"] de la tarea numero ["+this.numero+"]");
							documentosGenerados.add(doc);
							
						}		
				}					
				
			}
		}
		for(int indexPastura = 0; indexPastura < digestibilidadVariaciones.size(); indexPastura++) {								
			digestibilidadVariaciones.get(indexPastura).resetUltimaSeleccion();
			rindeVariaciones.get(indexPastura).resetUltimaSeleccion();
		}
		System.err.println("Finalizando Documento numero ="+this.numero);
		System.out.println("***************************************************************************************");
		return documentosGenerados;			
		
	}
	
	 


}
