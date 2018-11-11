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
@JsonPropertyOrder({ "Completion", "Fattening" })
public class VariacionFeedLot implements Serializable{

	@JsonProperty("Completion")
	public List<Integer> completion = null;
	@JsonProperty("Fattening")
	public List<Integer> fattening = null;
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

	public List<Integer> getCompletion() {
		return completion;
	}

	public void setCompletion(List<Integer> completion) {
		this.completion = completion;
	}

	public List<Integer> getFattening() {
		return fattening;
	}

	public void setFattening(List<Integer> fattening) {
		this.fattening = fattening;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "VariacionFeedLot [completion=" + completion + ", fattening=" + fattening + ", additionalProperties="
				+ additionalProperties + "]";
	}

	
}