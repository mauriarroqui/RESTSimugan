package com.example.restproyect.states.objetosinternos.recursosforrajeros;




import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.example.restproyect.states.objetosinternos.ValorMes;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ForrajeroVariacion implements Serializable{

    @JsonProperty("ValorMes")
    private ValorMes valorMes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ValorMes")
    public ValorMes getValorMes() {
        return valorMes;
    }

    @JsonProperty("ValorMes")
    public void setValorMes(ValorMes valorMes) {
        this.valorMes = valorMes;
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
		return "ForrajeroVariacion [valorMes=" + valorMes + ", additionalProperties=" + additionalProperties + "]";
	}
    
    

}
