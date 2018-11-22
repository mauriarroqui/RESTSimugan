
package com.example.restproyect.states.objetosinternos.destete;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Variacion"
})
public class EstadoDestete implements Serializable{

    @JsonProperty("Variacion")
    private List<VariacionDestete> variacion = null;

    private int ultimaSeleccion;
    
	public List<VariacionDestete> getVariacion() {
		return variacion;
	}

	public void setVariacion(List<VariacionDestete> variacion) {
		this.variacion = variacion;
	}

	
	public int getUltimaSeleccion() {
		return ultimaSeleccion;
	}

	public void setUltimaSeleccion(int ultimaSeleccion) {
		this.ultimaSeleccion = ultimaSeleccion;
	}

	@Override
	public String toString() {
		return "EstadoDestete [variacion=" + variacion + "]";
	}

    
   

}
