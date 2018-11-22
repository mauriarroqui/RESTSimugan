
package com.example.restproyect.states.objetosinternos.mobs;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.restproyect.states.objetosinternos.ValorMes;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "paramGenerales",
    "pastureAllow",
    "silageAllow",
    "grainAllow",
    "cropAllow",
    "stockAllow",
    "submobs",
    "weaningMobs"
})
public class VariacionMob implements Serializable{

    @JsonProperty("paramGenerales")
    private List<Integer> paramGenerales = null;
    
    @JsonProperty("pastureAllow")
    private List<ValorMes> pastureAllow = null;
    
    @JsonProperty("silageAllow")
    private List<ValorMes> silageAllow = null;
    
    @JsonProperty("grainAllow")
    private List<ValorMes> grainAllow = null;
    
    @JsonProperty("cropAllow")
    private List<ValorMes> cropAllow = null;
    
    @JsonProperty("stockAllow")
    private List<ValorMes> stockAllow = null;
    
    @JsonProperty("submobs")
    private List<Submob> submobs = null;
    
    @JsonProperty("weaningMobs")
    private WeaningMobs weaningMobs;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("paramGenerales")
    public List<Integer> getParamGenerales() {
        return paramGenerales;
    }

    @JsonProperty("paramGenerales")
    public void setParamGenerales(List<Integer> paramGenerales) {
        this.paramGenerales = paramGenerales;
    }

    @JsonProperty("pastureAllow")
    public List<ValorMes> getPastureAllow() {
        return pastureAllow;
    }

    @JsonProperty("pastureAllow")
    public void setPastureAllow(List<ValorMes> pastureAllow) {
        this.pastureAllow = pastureAllow;
    }

    @JsonProperty("silageAllow")
    public List<ValorMes> getSilageAllow() {
        return silageAllow;
    }

    @JsonProperty("silageAllow")
    public void setSilageAllow(List<ValorMes> silageAllow) {
        this.silageAllow = silageAllow;
    }

    @JsonProperty("grainAllow")
    public List<ValorMes> getGrainAllow() {
        return grainAllow;
    }

    @JsonProperty("grainAllow")
    public void setGrainAllow(List<ValorMes> grainAllow) {
        this.grainAllow = grainAllow;
    }

    @JsonProperty("cropAllow")
    public List<ValorMes> getCropAllow() {
        return cropAllow;
    }

    @JsonProperty("cropAllow")
    public void setCropAllow(List<ValorMes> cropAllow) {
        this.cropAllow = cropAllow;
    }

    @JsonProperty("stockAllow")
    public List<ValorMes> getStockAllow() {
        return stockAllow;
    }

    @JsonProperty("stockAllow")
    public void setStockAllow(List<ValorMes> stockAllow) {
        this.stockAllow = stockAllow;
    }

    @JsonProperty("submobs")
    public List<Submob> getSubmobs() {
        return submobs;
    }

    @JsonProperty("submobs")
    public void setSubmobs(List<Submob> submobs) {
        this.submobs = submobs;
    }

    @JsonProperty("weaningMobs")
    public WeaningMobs getWeaningMobs() {
        return weaningMobs;
    }

    @JsonProperty("weaningMobs")
    public void setWeaningMobs(WeaningMobs weaningMobs) {
        this.weaningMobs = weaningMobs;
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
		return "VariacionMob [paramGenerales=" + paramGenerales + ", pastureAllow=" + pastureAllow + ", silageAllow="
				+ silageAllow + ", grainAllow=" + grainAllow + ", cropAllow=" + cropAllow + ", stockAllow=" + stockAllow
				+ ", submobs=" + submobs + ", weaningMobs=" + weaningMobs + ", additionalProperties="
				+ additionalProperties + "]";
	}


    
}
