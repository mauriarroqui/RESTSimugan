package com.example.restproyect.states.objetosinternos.engorde;

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
    "grainAllow",
    "silageAllow",
    "stockPilledAllow",
    "cropStubbleAllow"
})
public class PastoEngorde implements Serializable{

    @JsonProperty("pastureAllow")
    public List<List<ValorMes>> pastureAllow = null;
    @JsonProperty("grainAllow")
    public List<List<ValorMes>> grainAllow = null;
    @JsonProperty("silageAllow")
    public List<List<ValorMes>> silageAllow = null;
    @JsonProperty("stockPilledAllow")
    public List<List<ValorMes>> stockPilledAllow = null;
    @JsonProperty("cropStubbleAllow")
    public List<List<ValorMes>> cropStubbleAllow = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public PastoEngorde(List<List<ValorMes>> pastureAllow, List<List<ValorMes>> grainAllow,
			List<List<ValorMes>> silageAllow, List<List<ValorMes>> stockPilledAllow,
			List<List<ValorMes>> cropStubbleAllow) {
		super();
		this.pastureAllow = pastureAllow;
		this.grainAllow = grainAllow;
		this.silageAllow = silageAllow;
		this.stockPilledAllow = stockPilledAllow;
		this.cropStubbleAllow = cropStubbleAllow;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public List<List<ValorMes>> getPastureAllow() {
		return pastureAllow;
	}

	public void setPastureAllow(List<List<ValorMes>> pastureAllow) {
		this.pastureAllow = pastureAllow;
	}

	public List<List<ValorMes>> getGrainAllow() {
		return grainAllow;
	}

	public void setGrainAllow(List<List<ValorMes>> grainAllow) {
		this.grainAllow = grainAllow;
	}

	public List<List<ValorMes>> getSilageAllow() {
		return silageAllow;
	}

	public void setSilageAllow(List<List<ValorMes>> silageAllow) {
		this.silageAllow = silageAllow;
	}

	public List<List<ValorMes>> getStockPilledAllow() {
		return stockPilledAllow;
	}

	public void setStockPilledAllow(List<List<ValorMes>> stockPilledAllow) {
		this.stockPilledAllow = stockPilledAllow;
	}

	public List<List<ValorMes>> getCropStubbleAllow() {
		return cropStubbleAllow;
	}

	public void setCropStubbleAllow(List<List<ValorMes>> cropStubbleAllow) {
		this.cropStubbleAllow = cropStubbleAllow;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "PastoEngorde [pastureAllow=" + pastureAllow + ", grainAllow=" + grainAllow + ", silageAllow="
				+ silageAllow + ", stockPilledAllow=" + stockPilledAllow + ", cropStubbleAllow=" + cropStubbleAllow
				+ ", additionalProperties=" + additionalProperties + "]";
	}
    
    

}
