package com.example.restproyect.states.objetosinternos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "pasturas" })
public class Pastura implements Serializable{

	@JsonProperty("pastura")
	private List<Integer> pasturas = null;
	
	private int ultimaSeleccion = 0; 
	
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

	public List<Integer> getPasturas() {
		return pasturas;
	}

	public void setPasturas(List<Integer> pasturas) {
		this.pasturas = pasturas;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	
	public float next() {
		float valor = this.pasturas.get(this.ultimaSeleccion);
		this.ultimaSeleccion = this.ultimaSeleccion + 1;
		return valor;
	}
	
	

	public void resetUltimaSeleccion() {
		this.ultimaSeleccion = 0;
	}

	@Override
	public String toString() {
		return "Pastura [pasturas=" + pasturas + ", additionalProperties=" + additionalProperties + "]";
	}
	
	

}