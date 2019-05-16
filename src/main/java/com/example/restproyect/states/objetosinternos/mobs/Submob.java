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
    "nombre",
    "variables",
    "valores"
})
public class Submob implements Serializable{

    @JsonProperty("nombre")
    private String nombre;
    
    @JsonProperty("variables")
    private List<String> variables = null;
    
    @JsonProperty("valores")
    private List<Float> valores = null;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("variables")
    public List<String> getVariables() {
        return variables;
    }

    @JsonProperty("variables")
    public void setVariables(List<String> variables) {
        this.variables = variables;
    }

    @JsonProperty("valores")
    public List<Float> getValores() {
        return valores;
    }

    @JsonProperty("valores")
    public void setValores(List<Float> valores) {
        this.valores = valores;
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
		return "Submob [nombre=" + nombre + ", variables=" + variables + ", valores=" + valores
				+ ", additionalProperties=" + additionalProperties + "]";
	}


    
}
