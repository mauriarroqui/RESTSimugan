package com.example.restproyect.states;



import java.io.Serializable;
import java.util.List;

import com.example.restproyect.states.objetosinternos.engorde.VariacionEngorde;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "variaciones"
})
public class Engorde implements Serializable{

    @JsonProperty("variaciones")
    public List<VariacionEngorde> variaciones = null;

	public List<VariacionEngorde> getVariaciones() {
		return variaciones;
	}

	public void setVariaciones(List<VariacionEngorde> variaciones) {
		this.variaciones = variaciones;
	}

	@Override
	public String toString() {
		return "Engorde [variaciones=" + variaciones + "]";
	}
    
    

}
