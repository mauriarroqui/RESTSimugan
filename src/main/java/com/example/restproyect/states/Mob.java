
package com.example.restproyect.states;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.restproyect.states.objetosinternos.mobs.VariacionesMobs;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Variaciones"
})
public class Mob implements Serializable{

    @JsonProperty("Variaciones")
    private List<VariacionesMobs> variaciones = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Variaciones")
    public List<VariacionesMobs> getVariaciones() {
        return variaciones;
    }

    @JsonProperty("Variaciones")
    public void setVariaciones(List<VariacionesMobs> variaciones) {
        this.variaciones = variaciones;
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
		return "Mob [variaciones=" + variaciones + ", additionalProperties=" + additionalProperties + "]";
	}

	

   

}
