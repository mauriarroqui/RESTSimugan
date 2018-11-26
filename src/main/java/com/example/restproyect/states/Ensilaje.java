package com.example.restproyect.states;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "leftoverMass", "triggerMass" })

public class Ensilaje implements Serializable{

	@JsonProperty("leftoverMass")
	private List<Integer> leftoverMass = null;
	
	@JsonProperty("triggerMass")
	private List<Integer> triggerMass = null;
	
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

	public List<Integer> getLeftoverMass() {
		return leftoverMass;
	}

	public void setLeftoverMass(List<Integer> leftoverMass) {
		this.leftoverMass = leftoverMass;
	}

	public List<Integer> getTriggerMass() {
		return triggerMass;
	}

	public void setTriggerMass(List<Integer> triggerMass) {
		this.triggerMass = triggerMass;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Ensilaje [leftoverMass=" + leftoverMass + ", triggerMass=" + triggerMass + ", additionalProperties="
				+ additionalProperties + "]";
	}

	public HashMap<Integer, Documento> generarEscenarios(VariacionesReact variacion) {
		HashMap<Integer, Documento> escenarios = new HashMap<>();
		for(int i = 0; i < triggerMass.size(); i++) {
			//Document newDocument = variacion.clonarDocumento(variacion.getDocumento());
			Document newDocument = variacion.getDocumento();
			
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
					if(nodo.getNodeName().equals("makeSilage")) {						
						nodo.setAttribute("triggerMass",  String.valueOf(triggerMass.get(i)));
						nodo.setAttribute("leftoverMass", String.valueOf(leftoverMass.get(i)));
						
						escenarios.put(escenarios.size()+1,doc);
						System.out.println(nodo.toString());
					}
					
				}
				
			}
		}		
		
		return escenarios;
	}

	

	

	
	
	

}
