package com.example.restproyect.states.objetosinternos.mobs;




import java.io.Serializable;
import java.util.ArrayList;
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
    "Variacion"
})
public class VariacionesMobs implements Serializable,Cloneable{

    @JsonProperty("Variacion")
    private List<VariacionMob> variacion = null;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Variacion")
    public List<VariacionMob> getVariacion() {
        return variacion;
    }

    @JsonProperty("Variacion")
    public void setVariacion(List<VariacionMob> variacion) {
        this.variacion = variacion;
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
		return "VariacionesMobs [variacion=" + variacion + ", additionalProperties=" + additionalProperties + "]";
	}
	
	public VariacionesMobs clone() {
		VariacionesMobs clonado = null;
		try {
			clonado= (VariacionesMobs) super.clone();
			List<VariacionMob> arrayClonado = new ArrayList<VariacionMob>();
			for(VariacionMob item : this.variacion) {
				arrayClonado.add(item.clone());
				
			}
			clonado.setVariacion(arrayClonado);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return clonado;
	}


    
}
