package com.example.restproyect.hilos;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.states.objetosinternos.Pastura;

public class TareaRastrojo extends Tarea{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
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
		try {
			//System.out.println("INICIO DE LA TAREA TareaRastrojo ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");		
			logger.debug("INICIO DE LA TAREA TareaRastrojo ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");
			Documento doc = new Documento(this.doc.getDocumento());			
			for(int indexVariaciones = 0; indexVariaciones < digestibilidadVariaciones.get(0).getPasturas().size(); indexVariaciones++) {
				//Por el tiempo que tardo en clonar el documento puede que queden los hilos 
				//muertos en algun lado, por eso la generacion de los documentos por tareas la hago afuera
				Document insertDoc = doc.clonarDocumento();
				
				doc.setDocumento(insertDoc);
				
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
								logger.debug("Variacion numero["+indexVariaciones+"] de la tarea numero ["+this.numero+"] con el Thread ["+Thread.currentThread().getName()+"]");								
								Node nodoPastura = nodePastura.item(indexPastura*2+1);	
								nodoPastura.getAttributes().getNamedItem("crop_stubbleDigest").setNodeValue(String.valueOf(digestibilidadVariaciones.get(indexPastura).next()));
								nodoPastura.getAttributes().getNamedItem("yield").setNodeValue(String.valueOf(rindeVariaciones.get(indexPastura).next()));
								
							}	
							
							documentosGenerados.add(doc);
							
						}		
					}					
					
				}
			}		
			logger.debug("FIN DE LA TAREA ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");
		} finally {
			
		}
		return documentosGenerados;			
		
	}
	
	 


}
