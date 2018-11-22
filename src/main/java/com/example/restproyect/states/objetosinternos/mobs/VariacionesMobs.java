package com.example.restproyect.states.objetosinternos.mobs;




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
@JsonPropertyOrder({
    "Variacion"
})
public class VariacionesMobs implements Serializable{

    @JsonProperty("Variacion")
    private List<VariacionMob> variacion = null;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Variacion")
    public List<VariacionMob> getVariacion() {
        return variacion;
    }

    @JsonProperty("Variacion")
    public void setVariacion(List<VariacionMob> variacion) {
        this.variacion = variacion;
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
		return "VariacionesMobs [variacion=" + variacion + ", additionalProperties=" + additionalProperties + "]";
	}


    
}
