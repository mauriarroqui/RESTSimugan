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
	
	public TareaEngorde(List<VariacionEngorde> variaciones, FiltroAbs filtro, Documento documento, Integer numero) {
		this.variaciones = variaciones;
		this.filtro = filtro;
		this.doc = documento;
		this.numero = numero;
		
	}
	private Node cambiarValoresMes(List<Integer> valores, Node nodo) {
		nodo.getAttributes().getNamedItem("January").setNodeValue(String.valueOf(valores.get(0)));
		nodo.getAttributes().getNamedItem("February").setNodeValue(String.valueOf(valores.get(1)));
		nodo.getAttributes().getNamedItem("March").setNodeValue(String.valueOf(valores.get(2)));
		nodo.getAttributes().getNamedItem("April").setNodeValue(String.valueOf(valores.get(3)));
		nodo.getAttributes().getNamedItem("May").setNodeValue(String.valueOf(valores.get(4)));
		nodo.getAttributes().getNamedItem("June").setNodeValue(String.valueOf(valores.get(5)));
		nodo.getAttributes().getNamedItem("July").setNodeValue(String.valueOf(valores.get(6)));
		nodo.getAttributes().getNamedItem("August").setNodeValue(String.valueOf(valores.get(7)));
		nodo.getAttributes().getNamedItem("September").setNodeValue(String.valueOf(valores.get(8)));
		nodo.getAttributes().getNamedItem("October").setNodeValue(String.valueOf(valores.get(9)));
		nodo.getAttributes().getNamedItem("November").setNodeValue(String.valueOf(valores.get(10)));
		nodo.getAttributes().getNamedItem("December").setNodeValue(String.valueOf(valores.get(11)));
		
		return nodo;
		
	}
	@Override
	public ArrayList<Documento> call() {
		//return null;
		ArrayList<Documento> documentosGenerados = new ArrayList<>();
		try {
			//System.out.println("INICIO DE LA TAREA TareaRastrojo ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");		
			logger.debug("INICIO DE LA TAREA Tarea Engorde ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");
			for(int indexVariaciones = 0; indexVariaciones < variaciones.size(); indexVariaciones++) {
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
							//Modificamos los ATRIBUTOS del Document
							
							nodo.getAttributes().getNamedItem("fattMethod").setNodeValue(variaciones.get(indexVariaciones).getTipoEngorde());
							nodo.getAttributes().getNamedItem("cuts").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getCutsEnable()));
							nodo.getAttributes().getNamedItem("empties").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getVaciasEnable()));
							nodo.getAttributes().getNamedItem("enable").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getGeneralEnable()));
							nodo.getAttributes().getNamedItem("enableCrop_stubble").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getRastrojoEnable()));
							nodo.getAttributes().getNamedItem("enableStockPilled").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getDiferidoEnable()));
							//Falta este tag verlo
//							nodo.getAttributes().getNamedItem("stockPilledPriority").setNodeValue(variaciones.get(indexVariaciones).getDiferidoEnable());
							
							
							NodeList nodeVarEngorde = node.item(j).getChildNodes();	
							
							//Modificamos los TAGS dentro del Document <fattening>
							
							for(int i = 0; i < nodeVarEngorde.getLength(); i++) {
								if(nodeVarEngorde.item(i).getNodeName().equals("pastureAllow")){
									Node atributos = nodeVarEngorde.item(i);
									atributos = cambiarValoresMes(variaciones.get(indexVariaciones).getPasture(),atributos);
								}
								if(nodeVarEngorde.item(i).getNodeName().equals("silageAllow")){
									Node atributos = nodeVarEngorde.item(i);
									atributos = cambiarValoresMes(variaciones.get(indexVariaciones).getSilage(),atributos);
								}
								if(nodeVarEngorde.item(i).getNodeName().equals("grainAllow")){
									Node atributos = nodeVarEngorde.item(i);
									atributos = cambiarValoresMes(variaciones.get(indexVariaciones).getGrain(),atributos);
								}
								if(nodeVarEngorde.item(i).getNodeName().equals("stockPilledAllow")){
									Node atributos = nodeVarEngorde.item(i);
									atributos = cambiarValoresMes(variaciones.get(indexVariaciones).getDiferido(),atributos);
								}
								if(nodeVarEngorde.item(i).getNodeName().equals("crop_stubbleAllow")){
									Node atributos = nodeVarEngorde.item(i);
									atributos = cambiarValoresMes(variaciones.get(indexVariaciones).getRastrojo(),atributos);
								}
								
								if(nodeVarEngorde.item(i).getNodeName().equals("csf")){
									Node atributos = nodeVarEngorde.item(i);
									atributos.getAttributes().getNamedItem("type").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getFeedlotType()));
									atributos.getAttributes().getNamedItem("bcsValue").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getCc()));
									atributos.getAttributes().getNamedItem("lwValue").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getPesoVivo()));
								}
								if(nodeVarEngorde.item(i).getNodeName().equals("diet")){			                          
									Node atributos = nodeVarEngorde.item(i);
									atributos.getAttributes().getNamedItem("feedlotBProtein").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getProtein()));
									atributos.getAttributes().getNamedItem("feedlotIntake").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getIntake()));
									atributos.getAttributes().getNamedItem("feedlotDigest").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getDigest()));
									atributos.getAttributes().getNamedItem("feedlotDRProtein").setNodeValue(String.valueOf(variaciones.get(indexVariaciones).getDRPRotein()));
								}
							}

//								//Formula para obtener la pastura que va a variar
							logger.debug("Variacion numero["+indexVariaciones+"] de la tarea numero ["+this.numero+"] con el Thread ["+Thread.currentThread().getName()+"]");	
//								

							
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
