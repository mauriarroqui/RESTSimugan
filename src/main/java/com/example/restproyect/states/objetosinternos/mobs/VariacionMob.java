
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
	"diferidosEnable",
	"rastrojoEnable",
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

	@JsonProperty("diferidosEnable")
	private boolean diferidosEnable = false;
	
	@JsonProperty("rastrojoEnable")
	private boolean rastrojoEnable = false;
	
    @JsonProperty("paramGenerales")
    private List<Float> paramGenerales = null;
    
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

    
    
    public VariacionMob(List<Float> paramGenerales, List<ValorMes> pastureAllow, List<ValorMes> silageAllow,
			List<ValorMes> grainAllow, List<ValorMes> cropAllow, List<ValorMes> stockAllow, List<Submob> submobs,
			WeaningMobs weaningMobs) {
		super();
		this.paramGenerales = paramGenerales;
		this.pastureAllow = pastureAllow;
		this.silageAllow = silageAllow;
		this.grainAllow = grainAllow;
		this.cropAllow = cropAllow;
		this.stockAllow = stockAllow;
		this.submobs = submobs;
		this.weaningMobs = weaningMobs;
	}

    
    @JsonProperty("diferidosEnable")
	public boolean isDiferidosEnable() {
		return diferidosEnable;
	}


    @JsonProperty("diferidosEnable")
	public void setDiferidosEnable(boolean diferidosEnable) {
		this.diferidosEnable = diferidosEnable;
	}


    @JsonProperty("rastrojoEnable")
	public boolean isRastrojoEnable() {
		return rastrojoEnable;
	}


    @JsonProperty("rastrojoEnable")
	public void setRastrojoEnable(boolean rastrojoEnable) {
		this.rastrojoEnable = rastrojoEnable;
	}



	@JsonProperty("paramGenerales")
    public List<Float> getParamGenerales() {
        return paramGenerales;
    }

    @JsonProperty("paramGenerales")
    public void setParamGenerales(List<Float> paramGenerales) {
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


    public VariacionMob clone() {
    	return new VariacionMob(paramGenerales,pastureAllow,silageAllow,grainAllow,cropAllow,stockAllow,submobs,weaningMobs);
    }
	

    
}
