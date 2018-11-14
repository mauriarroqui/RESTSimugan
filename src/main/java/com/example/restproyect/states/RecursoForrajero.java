package com.example.restproyect.states;



import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.restproyect.states.objetosinternos.recursosforrajeros.VariacionesForrajero;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class RecursoForrajero implements Serializable{

    @JsonProperty("ForrajeroVariaciones")
    private List<VariacionesForrajero> variacionesForrajero = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ForrajeroVariaciones")
    public List<VariacionesForrajero> getVariacionesForrajero() {
        return variacionesForrajero;
    }

    @JsonProperty("ForrajeroVariaciones")
    public void setVariacionesForrajero(List<VariacionesForrajero> variacionesForrajero) {
        this.variacionesForrajero = variacionesForrajero;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    
	@Override
	public String toString() {
		return "RecursoForrajero [variacionesForrajero=" + variacionesForrajero + ", additionalProperties="
				+ additionalProperties + "]";
	}

	
    
    

}
