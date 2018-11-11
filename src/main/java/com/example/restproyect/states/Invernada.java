package com.example.restproyect.states;

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
@JsonPropertyOrder({ "VaquillonaVariaciones", "nobillosVariaciones" })
public class Invernada implements Serializable{

	@JsonProperty("VaquillonaVariaciones")
	public List<Integer> vaquillonaVariaciones = null;
	
	@JsonProperty("nobillosVariaciones")
	public List<Integer> nobillosVariaciones = null;
	
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
				+ nobillosVariaciones + ", additionalProperties=" + additionalProperties + "]";
	}
	
	

}