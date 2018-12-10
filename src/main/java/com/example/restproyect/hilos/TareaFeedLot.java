package com.example.restproyect.hilos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.states.objetosinternos.feedlot.VariacionFeedLot;

public class TareaFeedLot extends Tarea{

//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<VariacionFeedLot> variacionFeedLot;
//	private Documento doc;
//    private FiltroAbs filtro;
//    private int numero; 
    
	
	public TareaFeedLot(List<VariacionFeedLot> variacionFeedLot, Documento doc, FiltroAbs filtro, int numero) {
		super();
		this.variacionFeedLot = variacionFeedLot;
		this.doc = doc;
		this.filtro = filtro;
		this.numero = numero;
	}
	
	public List<VariacionFeedLot> getVariacionFeedLot() {
		return variacionFeedLot;
	}
	public void setVariacionFeedLot(List<VariacionFeedLot> variacionFeedLot) {
		this.variacionFeedLot = variacionFeedLot;
	}
	public FiltroAbs getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroAbs filtro) {
		this.filtro = filtro;
	}
	
	
	
	@Override
	public ArrayList<Documento> call() {
		ArrayList<Documento> documentosGenerados = new ArrayList<>();
		try {
			logger.debug("INICIO DE LA TAREA TareaFeedLot ["+this.numero+"] DEL THREAD ["+Thread.currentThread().getName()+"]");
			//Generar para ese escenario, la variacion correspondiente
			Document newDocument = this.doc.getDocumento();
			for(int indexVariaciones = 0; indexVariaciones <this.variacionFeedLot.size(); indexVariaciones++) {
				
				Documento doc = new Documento(newDocument);			
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
						Node nodo = node.item(j);
						if(filtro.cumple(nodo)) {
							logger.debug("Variacion numero["+indexVariaciones+"] de la tarea numero ["+this.numero+"]");
							//Obtengo la pastura a variar
							NodeList nodeFeedLot = nodo.getChildNodes();		
							//Formula para obtener la pastura que va a variar
							Node nodoFeedLot = nodeFeedLot.item(1);	
							NodeList nodeVariar = nodoFeedLot.getChildNodes();
							
							Node nodoCompletion = nodeFeedLot.item(1);
							
							Node nodoFattening  = nodeFeedLot.item(3);
							
							
							nodoCompletion = this.variacionFeedLot.get(indexVariaciones).getCompletion().generarNodo(nodoCompletion);
							nodoFattening = this.variacionFeedLot.get(indexVariaciones).getFattening().generarNodo(nodoFattening);
							
							
							documentosGenerados.add(documentosGenerados.size(),doc);
							
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
