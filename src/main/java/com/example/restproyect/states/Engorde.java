package com.example.restproyect.states;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.example.restproyect.states.objetosinternos.engorde.PastoEngorde;
import com.example.restproyect.states.objetosinternos.engorde.VariacionEngorde;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PastoEngorde",
    "VariacionEngorde"
})
public class Engorde implements Serializable{

    @JsonProperty("PastoEngorde")
    private PastoEngorde pastoEngorde;
    
    @JsonProperty("VariacionEngorde")
    private VariacionEngorde variacionEngorde;
    
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

	public PastoEngorde getPastoEngorde() {
		return pastoEngorde;
	}

	public void setPastoEngorde(PastoEngorde pastoEngorde) {
		this.pastoEngorde = pastoEngorde;
	}

	public VariacionEngorde getVariacionEngorde() {
		return variacionEngorde;
	}

	public void setVariacionEngorde(VariacionEngorde variacionEngorde) {
		this.variacionEngorde = variacionEngorde;
	}

	@Override
	public String toString() {
		return "Engorde [pastoEngorde=" + pastoEngorde + ", variacionEngorde=" + variacionEngorde + "]";
	}
    
    

}
