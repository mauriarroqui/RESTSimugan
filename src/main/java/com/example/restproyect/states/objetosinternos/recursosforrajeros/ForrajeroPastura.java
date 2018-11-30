
package com.example.restproyect.states.objetosinternos.recursosforrajeros;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Transient;

import com.example.restproyect.states.objetosinternos.ValorMes;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ForrajeroVariacion"
})
public class ForrajeroPastura implements Serializable {

    @JsonProperty("ForrajeroVariacion")
    public List<List<ValorMes>> forrajeroVariacion = null;

    @Transient
    private int ultimoValor = 0;
    
    @Transient
    private int ultimaVariacion = 0;
    
	public List<List<ValorMes>> getForrajeroVariacion() {
		return forrajeroVariacion;
	}

	public void setForrajeroVariacion(List<List<ValorMes>> forrajeroVariacion) {
		this.forrajeroVariacion = forrajeroVariacion;
	}

	@Override
	public String toString() {
		return "ForrajeroPastura [forrajeroVariacion=" + forrajeroVariacion + "]";
	}

	public int getUltimoValor() {
		return ultimoValor;
	}

	public void setUltimoValor() {
		this.ultimoValor = 0;
	}

	public int getUltimaVariacion() {
		return ultimaVariacion;
	}

	public void setUltimaVariacion() {
		this.ultimaVariacion = 0;
	}
    
	public float next(){
		float valor = this.forrajeroVariacion.get(this.ultimaVariacion).get(this.ultimoValor).getValue();
		this.ultimoValor = this.ultimoValor + 1;
		if(this.ultimoValor > 11) {
			this.ultimaVariacion = this.ultimaVariacion + 1;
		}
		return valor;
	}


	public void resetUltimaSeleccion() {
		this.ultimaVariacion = 0;
		this.ultimoValor = 0;
		
	}
}
