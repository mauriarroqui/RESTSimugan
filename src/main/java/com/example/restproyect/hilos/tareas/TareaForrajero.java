package com.example.restproyect.hilos.tareas;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.states.RecursoForrajero;
import com.example.restproyect.states.objetosinternos.recursosforrajeros.ForrajeroPastura;

public class TareaForrajero extends AbsTarea {

	private ArrayList<ForrajeroPastura> pasturas;
	
	public TareaForrajero(ArrayList<ForrajeroPastura> pasturas, FiltroAbs filtro,Documento documento, Integer numero) {		
		this.pasturas = pasturas;
		this.filtro = filtro;
		this.doc = documento;
		this.numero = numero;	
	}

	@Override
	public ArrayList<Documento> call() {
		ArrayList<Documento> documentosGenerados = new ArrayList<>();
		for(int indexVariaciones = 0; indexVariaciones < pasturas.get(0).getForrajeroVariacion().size(); indexVariaciones++) {
			//Generar para ese escenario, la variacion correspondiente			
			
			Documento doc = new Documento(this.doc.getDocumento());			
			Document insertDoc = doc.clonarDocumento();
			doc.setDocumento(insertDoc);
			
			//Para cada tag dentro del tag <escenario> Busco los tags que tienen las variaciones
			NodeList node = doc.getDocumento().getChildNodes().item(0).getChildNodes();		
			

			for(int j=0; j < node.getLength(); j++) {
				
//				 * indice par es un text dentro de los tags, solo 
//				 * se trabaja con los elementos impares
//				 * que son los TAGS
				 
				
				if(j%2 != 0) {
					Element nodo = (Element) node.item(j);
					if(filtro.cumple(nodo)) {
						//Obtengo la pastura a variar
						NodeList nodePastura = nodo.getChildNodes();
						for(int indexPasturas = 0; indexPasturas < pasturas.size(); indexPasturas++) {
							//Formula para obtener la pastura que va a variar
							Element nodoPastura = (Element) nodePastura.item(indexPasturas*2+1);
							
							//Obtengo los hijos de la pastura
							NodeList nodePasturaIndex = nodoPastura.getChildNodes();
							
							//Parametro que va a variar pastureAccumRateMean
							Element  nodoPasturaIndex = (Element) nodePasturaIndex.item(1);
							
							for(int month = 0; month < 12; month ++) {
								nodoPasturaIndex.setAttribute(RecursoForrajero.getMonth(month),String.valueOf(pasturas.get(indexPasturas).next()));
							}
							
							
						}
						documentosGenerados.add(documentosGenerados.size(),doc);
						
						
					}
					
				}
				
			}				
		
			for(int indexPastura = 0; indexPastura < this.pasturas.size(); indexPastura++) {								
				this.pasturas.get(indexPastura).resetUltimaSeleccion();
				
			}
		}
		return documentosGenerados;
	}

}
