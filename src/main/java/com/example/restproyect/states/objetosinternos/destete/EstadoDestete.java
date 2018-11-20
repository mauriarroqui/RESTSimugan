
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
    public List<VariacionDestete> variacion = null;

	public List<VariacionDestete> getVariacion() {
		return variacion;
	}

	public void setVariacion(List<VariacionDestete> variacion) {
		this.variacion = variacion;
	}

	@Override
	public String toString() {
		return "EstadoDestete [variacion=" + variacion + "]";
	}

    
   

}
