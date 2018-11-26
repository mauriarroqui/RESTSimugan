
package com.example.restproyect.states.objetosinternos.recursosforrajeros;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import com.example.restproyect.states.objetosinternos.ValorMes;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ForrajeroPastura"
})
public class ForrajeroVariacion implements Serializable{

    @JsonProperty("ForrajeroPastura")
    private List<ValorMes> forrajeroPastura = null;
    
    @Transient
    private int ultimoValor = 0;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    
    
    public ForrajeroVariacion(List<ValorMes> forrajeroPastura, int ultimoValor,
			Map<String, Object> additionalProperties) {
		super();
		this.forrajeroPastura = forrajeroPastura;
		this.ultimoValor = ultimoValor;
		this.additionalProperties = additionalProperties;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


	public int getUltimoValor() {
		return ultimoValor;
	}

	public void nextUltimoValor() {
		this.ultimoValor = this.ultimoValor + 1;
	}
	
	public void setUltimoValor() {
		this.ultimoValor = 0;
	}
	
	public float next(){
		float valor = this.forrajeroPastura.get(this.ultimoValor).getValue();
		this.ultimoValor = this.ultimoValor + 1;
		return valor;
	}


	@Override
	public String toString() {
		return "ForrajeroVariacion [forrajeroPastura=" + forrajeroPastura + ", additionalProperties="
				+ additionalProperties + "]";
	}
	
	
    
    

}
