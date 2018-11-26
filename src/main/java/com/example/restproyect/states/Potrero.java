package com.example.restproyect.states;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.example.restproyect.states.objetosinternos.Pastura;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "potreros" })
public class Potrero implements Serializable{

	@JsonProperty("pasturas")
	private List<Pastura> pasturas = null;
	
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

	public List<Pastura> getDigestibilidadVariaciones() {
		return pasturas;
	}

	public void setDigestibilidadVariaciones(List<Pastura> digestibilidadVariaciones) {
		this.pasturas = digestibilidadVariaciones;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Potrero [pasturas=" + pasturas + ", additionalProperties=" + additionalProperties + "]";
	}

	public HashMap<Integer, Documento> generarEscenarios(HashMap<Integer, Documento> escenarios) {
		HashMap<Integer, Documento> newEscenarios = new HashMap<>();
		
		//Por cada escenario que entre. Los escenarios arrancan en 1
		for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {
			//Generar para ese escenario, la variacion correspondiente
			for(int indexVariaciones = 0; indexVariaciones < pasturas.get(0).getPasturas().size(); indexVariaciones++) {
				
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
						Element nodo = (Element) node.item(j);
						if(nodo.getNodeName().equals("paddocks")) {
							//Obtengo la pastura a variar
							NodeList nodePastura = nodo.getChildNodes();
							for(int indexPastura = 0; indexPastura < pasturas.size(); indexPastura++) {				
								//Formula para obtener la pastura que va a variar
								Element nodoPastura = (Element) nodePastura.item(indexPastura*2+1);	
								nodoPastura.setAttribute("paddockHA", String.valueOf(pasturas.get(indexPastura).next()));
								
							}						
							newEscenarios.put(newEscenarios.size()+1,doc);
							
						}
						
					}
					
				}
				
				
			}
			for(int indexPastura = 0; indexPastura < pasturas.size(); indexPastura++) {								
				pasturas.get(indexPastura).resetUltimaSeleccion();
				
			}	
			
			
		}
		
		
		return newEscenarios;
	}

	

	
	
	

}