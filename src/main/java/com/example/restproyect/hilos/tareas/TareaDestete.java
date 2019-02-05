package com.example.restproyect.hilos.tareas;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.states.objetosinternos.destete.EstadoDestete;

public class TareaDestete extends AbsTarea {


	private List<EstadoDestete> variaciones;
	
	public TareaDestete(List<EstadoDestete> variaciones, FiltroAbs filtro, Documento documento, Integer numero) {
		this.variaciones = variaciones;
		this.filtro = filtro;
		this.doc = documento;
		this.numero = numero;
		
	}
	
	@Override
	public ArrayList<Documento> call() {
		// TODO Auto-generated method stub
		ArrayList<Documento> documentosGenerados = new ArrayList<>();
		try {
			//System.out.println("INICIO DE LA TAREA TareaRastrojo ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");		
			logger.debug("INICIO DE LA TAREA TareaRastrojo ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");
			for(int indexVariaciones = 0; indexVariaciones < variaciones.get(0).getVariacion().size(); indexVariaciones++) {
				Documento doc = new Documento(this.doc.getDocumento());			
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
							
							for(int indexPastura = 0; indexPastura < variaciones.size(); indexPastura++) {				
								//Formula para obtener la pastura que va a variar
								logger.debug("Variacion numero["+indexVariaciones+"] de la tarea numero ["+this.numero+"] con el Thread ["+Thread.currentThread().getName()+"]");								
								Node nodoPastura = nodePastura.item(indexPastura+1);	
										
								nodoPastura.getAttributes().getNamedItem("calfUmbralLw").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getUmbral()));
								nodoPastura.getAttributes().getNamedItem("enableCalf").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getHabilitarCC()));
								nodoPastura.getAttributes().getNamedItem("calfDestiny").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getCalfDestiny()));
								nodoPastura.getAttributes().getNamedItem("calfDietBProtein").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getCalfDietBProtein()));
								nodoPastura.getAttributes().getNamedItem("calfDietIntake").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getCalfDietIntake()));
								nodoPastura.getAttributes().getNamedItem("calfDietDigest").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getCalfDietDigest()));
								nodoPastura.getAttributes().getNamedItem("calfDietDRProtein").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getCalfDietDRProtein()));
								nodoPastura.getAttributes().getNamedItem("umbralBcs").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getUmbralBcs()));
								nodoPastura.getAttributes().getNamedItem("enable").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getHabilitarPeso()));
								
//								
//								if(indexPastura == variaciones.size()-1) {
//									//Reiniciamos el contador para las pasturas
//									System.err.println("Empezando a reiniciar las variaciones");
//									for(int index = 0; index < variaciones.size(); index++) {
//										variaciones.get(index).setUltimoIndex(0);
//									}
//								}else {
									variaciones.get(indexPastura).setUltimoIndex(variaciones.get(indexPastura).getUltimoIndex() + 1);
//								}
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
