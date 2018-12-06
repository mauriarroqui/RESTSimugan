package com.example.restproyect.states;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;
import com.example.restproyect.states.objetosinternos.feedlot.VariacionFeedLot;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "VariacionFeedLot" })
public class Feedlot implements Serializable{

	@JsonProperty("VariacionFeedLot")
	private List<VariacionFeedLot> variacionFeedLot = null;
	
	@Transient
    private FiltroAbs filtro = new FiltroNombre("feedlot");
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public List<VariacionFeedLot> getVariacionFeedLot() {
		return variacionFeedLot;
	}

	public void setVariacionFeedLot(List<VariacionFeedLot> variacionFeedLot) {
		this.variacionFeedLot = variacionFeedLot;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Feedlot [variacionFeedLot=" + variacionFeedLot + ", additionalProperties=" + additionalProperties + "]"+"\n";
	}

	public Hashtable<Integer, Documento> generarEscenarios(Hashtable<Integer, Documento> escenarios) {
		Hashtable<Integer, Documento> newEscenarios = new Hashtable<>();
		
		//Por cada escenario que entre. Los escenarios arrancan en 1
		for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {
			//Generar para ese escenario, la variacion correspondiente
			for(int indexVariaciones = 0; indexVariaciones <this.variacionFeedLot.size(); indexVariaciones++) {
				Document newDocument = escenarios.get(indexEscenarios+1).getDocumento();
				
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
							//Obtengo la pastura a variar
							NodeList nodeFeedLot = nodo.getChildNodes();		
								//Formula para obtener la pastura que va a variar
							Node nodoFeedLot = nodeFeedLot.item(1);	
							NodeList nodeVariar = nodoFeedLot.getChildNodes();
							
							Node nodoCompletion = nodeFeedLot.item(1);
							
							Node nodoFattening  = nodeFeedLot.item(3);
								
							
							nodoCompletion = this.variacionFeedLot.get(indexVariaciones).getCompletion().generarNodo(nodoCompletion);
							nodoFattening = this.variacionFeedLot.get(indexVariaciones).getFattening().generarNodo(nodoFattening);
						
					
							newEscenarios.put(newEscenarios.size()+1,doc);
						
						}
					
					}
				}
				
			}
			
		}
		
		return newEscenarios;
	}
	
	

}