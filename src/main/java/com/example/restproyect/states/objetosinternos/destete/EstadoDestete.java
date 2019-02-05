
package com.example.restproyect.states.objetosinternos.destete;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

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
    
    @Transient
    private int ultimaSeleccion;

    
    public EstadoDestete() {
		super();
		this.ultimaSeleccion = 0;
	}

    
	public EstadoDestete(ArrayList<VariacionDestete> arrayClonado) {
		this.variacion = arrayClonado;
	}


	public List<VariacionDestete> getVariacion() {
		return variacion;
	}

	public void setVariacion(List<VariacionDestete> variacion) {
		this.variacion = variacion;
	}

	
	public VariacionDestete getUltimaSeleccion() {
		return variacion.get(ultimaSeleccion);
	}

	public void setUltimaSeleccion(int ultimaSeleccion) {
		this.ultimaSeleccion = ultimaSeleccion;
	}
	
	public int getUltimoIndex() {
		return this.ultimaSeleccion;
	}
	
	public void setUltimoIndex(int valor) {
		this.ultimaSeleccion = valor;
		
	}
	public EstadoDestete clone(ArrayList<VariacionDestete> arrayClonado) {
		return new EstadoDestete(arrayClonado);
		
	}
	@Override
	public String toString() {
		return "EstadoDestete [variacion=" + variacion + "]";
	}

    
   

}
