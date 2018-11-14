package com.example.restproyect.states.objetosinternos.recursosforrajeros;




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

public class ForrajeroPastura implements Serializable{

    @JsonProperty("ForrajeroVariacion")
    private List<ForrajeroVariacion> forrajeroVariacion = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ForrajeroVariacion")
    public List<ForrajeroVariacion> getForrajeroVariacion() {
        return forrajeroVariacion;
    }

    @JsonProperty("ForrajeroVariacion")
    public void setForrajeroVariacion(List<ForrajeroVariacion> forrajeroVariacion) {
        this.forrajeroVariacion = forrajeroVariacion;
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
		return "ForrajeroPastura [forrajeroVariacion=" + forrajeroVariacion + ", additionalProperties="
				+ additionalProperties + "]";
	}
    
    

}
