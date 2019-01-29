package com.example.restproyect.hilos.tareas;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.states.objetosinternos.engorde.VariacionEngorde;

public class TareaEngorde extends AbsTarea {

	private List<VariacionEngorde> variaciones;
	
	public TareaEngorde(List<VariacionEngorde> variaciones, FiltroAbs filtro) {
		this.variaciones = variaciones;
		this.filtro = filtro;
		
		
	}

	@Override
	public ArrayList<Documento> call() {
		return null;
//		ArrayList<Documento> documentosGenerados = new ArrayList<>();
//		try {
//			//System.out.println("INICIO DE LA TAREA TareaRastrojo ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");		
//			logger.debug("INICIO DE LA TAREA Tarea Engorde ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");
//			Documento doc = new Documento(this.doc.getDocumento());			
//			for(int indexVariaciones = 0; indexVariaciones < digestibilidadVariaciones.get(0).getPasturas().size(); indexVariaciones++) {
//				//Por el tiempo que tardo en clonar el documento puede que queden los hilos 
//				//muertos en algun lado, por eso la generacion de los documentos por tareas la hago afuera
//				Document insertDoc = doc.clonarDocumento();
//				
//				doc.setDocumento(insertDoc);
//				
//				//Para cada tag dentro del tag <escenario> Busco los tags que tienen las variaciones
//				NodeList node = doc.getDocumento().getChildNodes().item(0).getChildNodes();		
//				for(int j=0; j < node.getLength(); j++) {
//					/*
//					 * indice par es un text dentro de los tags, solo 
//					 * se trabaja con los elementos impares
//					 * que son los TAGS
//					 */
//					if(j%2 != 0) {
//						
//						Node nodo =  node.item(j);
//						if(filtro.cumple(nodo)) {
//							//Obtengo la pastura a variar								
//							NodeList nodePastura = node.item(j).getChildNodes();						
//							
//							for(int indexPastura = 0; indexPastura < digestibilidadVariaciones.size(); indexPastura++) {				
//								//Formula para obtener la pastura que va a variar
//								logger.debug("Variacion numero["+indexVariaciones+"] de la tarea numero ["+this.numero+"] con el Thread ["+Thread.currentThread().getName()+"]");								
//								Node nodoPastura = nodePastura.item(indexPastura*2+1);	
//								nodoPastura.getAttributes().getNamedItem(this.param1).setNodeValue(String.valueOf(digestibilidadVariaciones.get(indexPastura).next()));
//								nodoPastura.getAttributes().getNamedItem(this.param2).setNodeValue(String.valueOf(rindeVariaciones.get(indexPastura).next()));
//								
//							}	
//							
//							documentosGenerados.add(doc);
//							
//						}		
//					}					
//					
//				}
//			}		
//			logger.debug("FIN DE LA TAREA ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");
//		} finally {
//			
//		}
//		return documentosGenerados;	
	}

}
