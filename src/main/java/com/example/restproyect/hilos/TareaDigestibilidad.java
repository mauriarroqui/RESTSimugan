package com.example.restproyect.hilos;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.states.objetosinternos.Pastura;
/*
 * TAREA DE GENERACION DE ESCENARIOS TANTO PARA RASTROJO COMO PARA DIFERIDOS
 * 
 * */
public class TareaDigestibilidad extends Tarea{
	
	protected ArrayList<Pastura> digestibilidadVariaciones;
	protected ArrayList<Pastura> rindeVariaciones;
	private String param1;
	private String param2;
	
	
	
	
	public TareaDigestibilidad(ArrayList<Pastura> digestibilidadVariaciones, ArrayList<Pastura> rindeVariaciones, FiltroAbs filtro,
			Documento doc, int numero, String param1, String param2) {
		super();
		this.digestibilidadVariaciones = digestibilidadVariaciones;
		this.rindeVariaciones = rindeVariaciones;
		this.filtro = filtro;
		this.doc = doc;
		this.numero = numero;
		this.param1 = param1;
		this.param2 = param2;
	}


	
	public ArrayList<Documento> call() {	
		ArrayList<Documento> documentosGenerados = new ArrayList<>();
		try {
			//System.out.println("INICIO DE LA TAREA TareaRastrojo ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");		
			logger.debug("INICIO DE LA TAREA Tarea Digestibilidad ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");
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
								nodoPastura.getAttributes().getNamedItem(this.param1).setNodeValue(String.valueOf(digestibilidadVariaciones.get(indexPastura).next()));
								nodoPastura.getAttributes().getNamedItem(this.param2).setNodeValue(String.valueOf(rindeVariaciones.get(indexPastura).next()));
								
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
