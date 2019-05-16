package com.example.restproyect.states;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "VaquillonaVariaciones", "nobillosVariaciones" })
public class Invernada implements Serializable{

	@JsonProperty("VaquillonaVariaciones")
	private List<Integer> vaquillonaVariaciones = null;
	
	@JsonProperty("nobillosVariaciones")
	private List<Integer> nobillosVariaciones = null;
	
	@Transient
    private FiltroAbs filtro = new FiltroNombre("sellRule");
	
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

	public List<Integer> getVaquillonaVariaciones() {
		return vaquillonaVariaciones;
	}

	public void setVaquillonaVariaciones(List<Integer> vaquillonaVariaciones) {
		this.vaquillonaVariaciones = vaquillonaVariaciones;
	}

	public List<Integer> getNobillosVariaciones() {
		return nobillosVariaciones;
	}

	public void setNobillosVariaciones(List<Integer> nobillosVariaciones) {
		this.nobillosVariaciones = nobillosVariaciones;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Invernada [vaquillonaVariaciones=" + vaquillonaVariaciones + ", nobillosVariaciones="
				+ nobillosVariaciones + ", additionalProperties=" + additionalProperties + "]"+"\n";
	}

	public Hashtable<Integer, Documento> generarEscenarios(Hashtable<Integer, Documento> escenarios) {
		System.out.println("-------------------------------------INVERNADA---------------------------------------");
		Hashtable<Integer, Documento> newEscenarios = new Hashtable<>();
		try {
			for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {
				if((escenarios.size()-1) == indexEscenarios) {
					System.out.println("Parar"); //????
				}
				for(int i = 0; i < vaquillonaVariaciones.size(); i++) {
					
					//Obtengo el documento base
					Document newDocument = escenarios.get(indexEscenarios).getDocumento();
					
					//Clono el documento base
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
							if(filtro.cumple(nodo)) {						
								nodo.setAttribute("lwValueFeme",  String.valueOf(vaquillonaVariaciones.get(i)));
								nodo.setAttribute("lwValue",      String.valueOf(nobillosVariaciones.get(i)));
								
								newEscenarios.put(newEscenarios.size(),doc);
								//System.out.println(nodo.toString());
							}
							
						}
						
					}
				}		
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return newEscenarios;
	}
	
	

}