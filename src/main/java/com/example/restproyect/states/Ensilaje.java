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
@JsonPropertyOrder({ "leftoverMass", "triggerMass" })

public class Ensilaje implements Serializable{

	@JsonProperty("leftoverMass")
	public List<Integer> leftoverMass = null;
	
	@JsonProperty("triggerMass")
	public List<Integer> triggerMass = null;
	
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

	

	
	
	

}
