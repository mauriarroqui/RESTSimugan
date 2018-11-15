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
    "pastureAllow",
    "silageAllow",
    "grainAllow",
    "cropAllow",
    "stockAllow"
})
public class WeaningMobs implements Serializable{

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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
		return "WeaningMobs [pastureAllow=" + pastureAllow + ", silageAllow=" + silageAllow + ", grainAllow="
				+ grainAllow + ", cropAllow=" + cropAllow + ", stockAllow=" + stockAllow + ", additionalProperties="
				+ additionalProperties + "]";
	}

    

}
