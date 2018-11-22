package com.example.restproyect.states;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.restproyect.states.objetosinternos.Pastura;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "digestibilidadVariaciones", "rindeVariaciones" })
public class Diferido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("digestibilidadVariaciones")
	private List<Pastura> digestibilidadVariaciones = null;
	
	@JsonProperty("rindeVariaciones")
	private List<Pastura> rindeVariaciones = null;
	
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
		return digestibilidadVariaciones;
	}

	public void setDigestibilidadVariaciones(List<Pastura> digestibilidadVariaciones) {
		this.digestibilidadVariaciones = digestibilidadVariaciones;
	}

	public List<Pastura> getRindeVariaciones() {
		return rindeVariaciones;
	}

	public void setRindeVariaciones(List<Pastura> rindeVariaciones) {
		this.rindeVariaciones = rindeVariaciones;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Diferido [digestibilidadVariaciones=" + digestibilidadVariaciones + ", rindeVariaciones="
				+ rindeVariaciones + ", additionalProperties=" + additionalProperties + "]";
	}

	
	
	
	
	

}