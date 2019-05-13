package com.example.restproyect.hilos.tareas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.states.objetosinternos.destete.EstadoDestete;
import com.example.restproyect.states.objetosinternos.mobs.VariacionMob;
import com.example.restproyect.states.objetosinternos.mobs.VariacionesMobs;

public class TareaMob extends AbsTarea {
	
	private List<VariacionesMobs> variaciones;
	private FiltroAbs filtro;
	private Documento doc;
	private Integer numero;
	
	public TareaMob(List<VariacionesMobs> variaciones, FiltroAbs filtro, Documento documento, Integer numero) {
		this.variaciones = variaciones;
		this.filtro = filtro;
		this.doc = documento;
		this.numero = numero;
		
	}
	
	public String getMonth(int i) {
		String result = "";
		switch (i) {
		case 0:
			result = "January";
			break;
		case 1:
			result = "February";
			break;
		case 2:
			result = "March";
			break;
		case 3:
			result = "April";
			break;
		case 4:
			result = "May";
			break;
		case 5:
			result = "June";
			break;
		case 6:
			result = "July";
			break;
		case 7:
			result = "August";
			break;
		case 8:
			result = "September";
			break;
		case 9:
			result = "October";
			break;
		case 10:
			result = "November";
			break;
		case 11:
			result = "December";
			break;

		}
		return result;
	}
	
	@Override
	public ArrayList<Documento> call() {
		// TODO Auto-generated method stub
		ArrayList<Documento> documentosGenerados = new ArrayList<>();
		final int cantMobs = variaciones.size();
		final int cantVariaciones = variaciones.get(0).getVariacion().size();
		System.out.println("cantidad de mobs = "+ cantMobs + " cantidad de Variaciones = " + cantVariaciones);
		// este for loopea las variaciones obtenidas de la reactWeb
		for (int indexVariaciones = 0; indexVariaciones < cantVariaciones; indexVariaciones++){
			Documento doc = new Documento(this.doc.getDocumento());
			Document insertDoc = doc.clonarDocumento();
			
			doc.setDocumento(insertDoc);
			
			NodeList node = doc.getDocumento().getChildNodes().item(0).getChildNodes();	
			// este for busca el tag <MOBS>
			for(int j=0; j < node.getLength(); j++) {
				if(j%2 != 0) {
					Node nodo =  node.item(j);
					if(filtro.cumple(nodo)) {
						NodeList nodeMobs = node.item(j).getChildNodes();
						// este for recorre los mobs y aca deberia modificar todos los tags y atributos
						for(int k = 0; k < nodeMobs.getLength(); k++) {
							if(k%2 != 0) {
								Node nodoMobs = nodeMobs.item(k);
								VariacionMob variacion = variaciones.get(k - 1).getVariacion().get(indexVariaciones); // k - 1 para compensar el problema de k%2
								nodoMobs.getAttributes().getNamedItem("enableCrop_stubble").setNodeValue(String.valueOf(variacion.isDiferidosEnable()));
								nodoMobs.getAttributes().getNamedItem("enableStockPilled").setNodeValue(String.valueOf(variacion.isRastrojoEnable()));
								
								nodoMobs.getAttributes().getNamedItem("service").setNodeValue(String.valueOf(variacion.getParamGenerales().get(0)));
								nodoMobs.getAttributes().getNamedItem("repositionPercent").setNodeValue(String.valueOf(variacion.getParamGenerales().get(1)));
								nodoMobs.getAttributes().getNamedItem("minInServiceWeight").setNodeValue(String.valueOf(variacion.getParamGenerales().get(2)));
								
								Node nodoPastura = nodoMobs.getChildNodes().item(1);
								Node nodoSilage =	nodoMobs.getChildNodes().item(3);
								Node nodoGrain = nodoMobs.getChildNodes().item(5);
								Node nodoDiferido = nodoMobs.getChildNodes().item(7);
								Node nodoRastrojo = nodoMobs.getChildNodes().item(9);
								Node nodoWeaning = nodoMobs.getChildNodes().item(13);
								for(int i = 0 ; i<12;i++) {
									nodoPastura.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(String.valueOf(variacion.getPastureAllow().get(i)));
									nodoGrain.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(String.valueOf(variacion.getSilageAllow().get(i)));
									nodoSilage.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(String.valueOf(variacion.getGrainAllow().get(i)));
									nodoDiferido.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(String.valueOf(variacion.getStockAllow().get(i)));
									nodoRastrojo.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(String.valueOf(variacion.getCropAllow().get(i)));
									
								}
								

								// ---weaning
								if (nodoWeaning.getAttributes() != null) {
									nodoWeaning.getAttributes().getNamedItem("enableCrop_stubble").setNodeValue(String.valueOf(variacion.getWeaningMobs().isDiferidosEnable()));
									nodoWeaning.getAttributes().getNamedItem("enableStockPilled").setNodeValue(String.valueOf(variacion.getWeaningMobs().isRastrojoEnable()));
									Node nodoWeaningPastura = nodoWeaning.getChildNodes().item(1);
									Node nodoWeaningSilage =	nodoWeaning.getChildNodes().item(3);
									Node nodoWeaningGrain = nodoWeaning.getChildNodes().item(5);
									Node nodoWeaningDiferido = nodoWeaning.getChildNodes().item(7);
									Node nodoWeaningRastrojo = nodoWeaning.getChildNodes().item(9);
									for (int i = 0; i < 12; i++) {
										nodoWeaningPastura.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(String.valueOf(variacion.getWeaningMobs().getPastureAllow().get(i)));
										nodoWeaningGrain.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(String.valueOf(variacion.getWeaningMobs().getSilageAllow().get(i)));
										nodoWeaningSilage.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(String.valueOf(variacion.getWeaningMobs().getGrainAllow().get(i)));
										nodoWeaningDiferido.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(String.valueOf(variacion.getWeaningMobs().getStockAllow().get(i)));
										nodoWeaningRastrojo.getAttributes().getNamedItem(this.getMonth(i)).setNodeValue(String.valueOf(variacion.getWeaningMobs().getCropAllow().get(i)));
										
									}
								}
								
								NodeList submobs = nodoMobs.getChildNodes().item(11).getChildNodes();
								for(int i = 0; i < submobs.getLength();i++) {
									if(i%2 != 0) {
										Node nodoSubMob = submobs.item(i);
										nodoSubMob.getAttributes().getNamedItem("weaning").setNodeValue(String.valueOf(variacion.getSubmobs().get(i).getValores().get(0)));
										nodoSubMob.getAttributes().getNamedItem("startCountAnimals").setNodeValue(String.valueOf(variacion.getSubmobs().get(i).getValores().get(1)));
										nodoSubMob.getAttributes().getNamedItem("submobSwMax").setNodeValue(String.valueOf(variacion.getSubmobs().get(i).getValores().get(2)));
										nodoSubMob.getAttributes().getNamedItem("submobSwMean").setNodeValue(String.valueOf(variacion.getSubmobs().get(i).getValores().get(3)));
										nodoSubMob.getAttributes().getNamedItem("submobSwMin").setNodeValue(String.valueOf(variacion.getSubmobs().get(i).getValores().get(4)));
										
										NodeList nodoweaner = nodoSubMob.getChildNodes().item(1).getChildNodes();
										
										nodoweaner.item(1).getAttributes().getNamedItem("amount").setNodeValue(String.valueOf(variacion.getSubmobs().get(i).getValores().get(5)));
										nodoweaner.item(3).getAttributes().getNamedItem("amount").setNodeValue(String.valueOf(variacion.getSubmobs().get(i).getValores().get(6)));
			
									}
								}
								
								System.out.println("> > > " + nodeMobs.item(k).getChildNodes().item(1).getNodeName());
							}
						}
					}
				}
			}
	
		}
		//		try {
//			//System.out.println("INICIO DE LA TAREA TareaRastrojo ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");		
//			logger.debug("INICIO DE LA TAREA TareaMobs ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");
//			for(int indexVariaciones = 0; indexVariaciones < variaciones.getVariacion().size(); indexVariaciones++) {
//				Documento doc = new Documento(this.doc.getDocumento());			
//				//Por el tiempo que tardo en clonar el documento puede que queden los hilos 
//				//muertos en algun lado, por eso la generacion de los documentos por tareas la hago afuera
//				Document insertDoc = doc.clonarDocumento();
//				
//				doc.setDocumento(insertDoc);
//				
//				//Para cada tag dentro del tag <escenario> Busco los tags que tienen las variaciones
//				NodeList node = doc.getDocumento().getChildNodes().item(0).getChildNodes();		
		//----->
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
//							for(int indexPastura = 0; indexPastura < variaciones.getVariacion().size(); indexPastura++) {				
//								//Formula para obtener la pastura que va a variar
//								logger.debug("Variacion numero["+indexVariaciones+"] de la tarea numero ["+this.numero+"] con el Thread ["+Thread.currentThread().getName()+"]");								
//								Node nodoPastura = nodePastura.item(indexPastura+1);	
////										
////								nodoPastura.getAttributes().getNamedItem("calfUmbralLw").setNodeValue(String.valueOf(variaciones.getVariacion().get(indexPastura).getUltimaSeleccion().getUmbral()));
////								nodoPastura.getAttributes().getNamedItem("enableCalf").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getHabilitarCC()));
////								nodoPastura.getAttributes().getNamedItem("calfDestiny").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getCalfDestiny()));
////								nodoPastura.getAttributes().getNamedItem("calfDietBProtein").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getCalfDietBProtein()));
////								nodoPastura.getAttributes().getNamedItem("calfDietIntake").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getCalfDietIntake()));
////								nodoPastura.getAttributes().getNamedItem("calfDietDigest").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getCalfDietDigest()));
////								nodoPastura.getAttributes().getNamedItem("calfDietDRProtein").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getCalfDietDRProtein()));
////								nodoPastura.getAttributes().getNamedItem("umbralBcs").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getUmbralBcs()));
////								nodoPastura.getAttributes().getNamedItem("enable").setNodeValue(String.valueOf(variaciones.get(indexPastura).getUltimaSeleccion().getHabilitarPeso()));
////								
////								
////								if(indexPastura == variaciones.size()-1) {
////									//Reiniciamos el contador para las pasturas
////									System.err.println("Empezando a reiniciar las variaciones");
////									for(int index = 0; index < variaciones.size(); index++) {
////										variaciones.get(index).setUltimoIndex(0);
////									}
////								}else {
//									//variaciones.get(indexPastura).setUltimoIndex(variaciones.get(indexPastura).getUltimoIndex() + 1);
////								}
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
		return documentosGenerados;		
	}

}
