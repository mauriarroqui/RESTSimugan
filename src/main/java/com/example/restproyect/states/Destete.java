package com.example.restproyect.states;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Transient;

import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;
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
    private List<EstadoDestete> variaciones = null;

    @Transient
    private FiltroAbs filtro = new FiltroNombre("");
    
	public List<EstadoDestete> getVariaciones() {
		return variaciones;
	}


	public void setVariaciones(List<EstadoDestete> variaciones) {
		this.variaciones = variaciones;
	}


	@Override
	public String toString() {
		return "Destete [variaciones=" + variaciones + "]"+"\n";
	}

   

}
