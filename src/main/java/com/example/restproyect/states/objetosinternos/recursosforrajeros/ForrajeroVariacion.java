
package com.example.restproyect.states.objetosinternos.recursosforrajeros;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.restproyect.states.objetosinternos.ValorMes;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ForrajeroPastura"
})
public class ForrajeroVariacion implements Serializable{

    @JsonProperty("ForrajeroPastura")
    private List<ValorMes> forrajeroPastura = null;
    
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

	@Override
	public String toString() {
		return "ForrajeroVariacion [forrajeroPastura=" + forrajeroPastura + ", additionalProperties="
				+ additionalProperties + "]";
	}
    
    

}
