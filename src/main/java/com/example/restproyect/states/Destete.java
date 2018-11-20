package com.example.restproyect.states;
import java.io.Serializable;
import java.util.List;

import com.example.restproyect.states.objetosinternos.destete.EstadoDestete;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "variaciones"
})
public class Destete implements Serializable{

    @JsonProperty("variaciones")
    public List<EstadoDestete> variaciones = null;

    
	public List<EstadoDestete> getVariaciones() {
		return variaciones;
	}


	public void setVariaciones(List<EstadoDestete> variaciones) {
		this.variaciones = variaciones;
	}


	@Override
	public String toString() {
		return "Destete [variaciones=" + variaciones + "]";
	}

   

}
