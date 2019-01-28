package com.example.restproyect.states.objetosinternos.engorde;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariacionEngorde implements Serializable{

    @JsonProperty("tipoEngorde")
    private String tipoEngorde;
    
    @JsonProperty("generalEnable")
    private Boolean generalEnable;
    
    @JsonProperty("cutsEnable")
    private Boolean cutsEnable;
    
    @JsonProperty("vaciasEnable")
    private Boolean vaciasEnable;
    
    @JsonProperty("diferidoEnable")
    private Boolean diferidoEnable;
    
    @JsonProperty("rastrojoEnable")
    private Boolean rastrojoEnable;
    
    @JsonProperty("pasture")
    private List<Integer> pasture = null;
    
    @JsonProperty("silage")
    private List<Integer> silage = null;
    
    @JsonProperty("grain")
    private List<Integer> grain = null;
    
    @JsonProperty("diferido")
    private List<Integer> diferido = null;
    
    @JsonProperty("rastrojo")
    private List<Integer> rastrojo = null;
    
    @JsonProperty("feedlotType")
    private String feedlotType;
    
    @JsonProperty("protein")
    private Integer protein;
    
    @JsonProperty("intake")
    private Integer intake;
    
    @JsonProperty("digest")
    private Integer digest;
    
    @JsonProperty("DRPRotein")
    private Integer dRPRotein;
    
    @JsonProperty("pesoVivo")
    private Integer pesoVivo;
    
    @JsonProperty("cc")
    private Integer cc;
    
    @Transient
    private int ultimaSeleccion;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();    
    
    public VariacionEngorde(String tipoEngorde, Boolean generalEnable, Boolean cutsEnable, Boolean vaciasEnable,
			Boolean diferidoEnable, Boolean rastrojoEnable, List<Integer> pasture, List<Integer> silage,
			List<Integer> grain, List<Integer> diferido, List<Integer> rastrojo, String feedlotType, Integer protein,
			Integer intake, Integer digest, Integer dRPRotein, Integer pesoVivo, Integer cc, int ultimaSeleccion,
			Map<String, Object> additionalProperties) {
		super();
		this.tipoEngorde = tipoEngorde;
		this.generalEnable = generalEnable;
		this.cutsEnable = cutsEnable;
		this.vaciasEnable = vaciasEnable;
		this.diferidoEnable = diferidoEnable;
		this.rastrojoEnable = rastrojoEnable;
		this.pasture = pasture;
		this.silage = silage;
		this.grain = grain;
		this.diferido = diferido;
		this.rastrojo = rastrojo;
		this.feedlotType = feedlotType;
		this.protein = protein;
		this.intake = intake;
		this.digest = digest;
		this.dRPRotein = dRPRotein;
		this.pesoVivo = pesoVivo;
		this.cc = cc;
		this.ultimaSeleccion = ultimaSeleccion;
		this.additionalProperties = additionalProperties;
	}

	@JsonProperty("tipoEngorde")
    public String getTipoEngorde() {
        return tipoEngorde;
    }

    @JsonProperty("tipoEngorde")
    public void setTipoEngorde(String tipoEngorde) {
        this.tipoEngorde = tipoEngorde;
    }

    @JsonProperty("generalEnable")
    public Boolean getGeneralEnable() {
        return generalEnable;
    }

    @JsonProperty("generalEnable")
    public void setGeneralEnable(Boolean generalEnable) {
        this.generalEnable = generalEnable;
    }

    @JsonProperty("cutsEnable")
    public Boolean getCutsEnable() {
        return cutsEnable;
    }

    @JsonProperty("cutsEnable")
    public void setCutsEnable(Boolean cutsEnable) {
        this.cutsEnable = cutsEnable;
    }

    @JsonProperty("vaciasEnable")
    public Boolean getVaciasEnable() {
        return vaciasEnable;
    }

    @JsonProperty("vaciasEnable")
    public void setVaciasEnable(Boolean vaciasEnable) {
        this.vaciasEnable = vaciasEnable;
    }

    @JsonProperty("diferidoEnable")
    public Boolean getDiferidoEnable() {
        return diferidoEnable;
    }

    @JsonProperty("diferidoEnable")
    public void setDiferidoEnable(Boolean diferidoEnable) {
        this.diferidoEnable = diferidoEnable;
    }

    @JsonProperty("rastrojoEnable")
    public Boolean getRastrojoEnable() {
        return rastrojoEnable;
    }

    @JsonProperty("rastrojoEnable")
    public void setRastrojoEnable(Boolean rastrojoEnable) {
        this.rastrojoEnable = rastrojoEnable;
    }

    @JsonProperty("pasture")
    public List<Integer> getPasture() {
        return pasture;
    }

    @JsonProperty("pasture")
    public void setPasture(List<Integer> pasture) {
        this.pasture = pasture;
    }

    @JsonProperty("silage")
    public List<Integer> getSilage() {
        return silage;
    }

    @JsonProperty("silage")
    public void setSilage(List<Integer> silage) {
        this.silage = silage;
    }

    @JsonProperty("grain")
    public List<Integer> getGrain() {
        return grain;
    }

    @JsonProperty("grain")
    public void setGrain(List<Integer> grain) {
        this.grain = grain;
    }

    @JsonProperty("diferido")
    public List<Integer> getDiferido() {
        return diferido;
    }

    @JsonProperty("diferido")
    public void setDiferido(List<Integer> diferido) {
        this.diferido = diferido;
    }

    @JsonProperty("rastrojo")
    public List<Integer> getRastrojo() {
        return rastrojo;
    }

    @JsonProperty("rastrojo")
    public void setRastrojo(List<Integer> rastrojo) {
        this.rastrojo = rastrojo;
    }

    @JsonProperty("feedlotType")
    public String getFeedlotType() {
        return feedlotType;
    }

    @JsonProperty("feedlotType")
    public void setFeedlotType(String feedlotType) {
        this.feedlotType = feedlotType;
    }

    @JsonProperty("protein")
    public Integer getProtein() {
        return protein;
    }

    @JsonProperty("protein")
    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    @JsonProperty("intake")
    public Integer getIntake() {
        return intake;
    }

    @JsonProperty("intake")
    public void setIntake(Integer intake) {
        this.intake = intake;
    }

    @JsonProperty("digest")
    public Integer getDigest() {
        return digest;
    }

    @JsonProperty("digest")
    public void setDigest(Integer digest) {
        this.digest = digest;
    }

    @JsonProperty("DRPRotein")
    public Integer getDRPRotein() {
        return dRPRotein;
    }

    @JsonProperty("DRPRotein")
    public void setDRPRotein(Integer dRPRotein) {
        this.dRPRotein = dRPRotein;
    }

    @JsonProperty("pesoVivo")
    public Integer getPesoVivo() {
        return pesoVivo;
    }

    @JsonProperty("pesoVivo")
    public void setPesoVivo(Integer pesoVivo) {
        this.pesoVivo = pesoVivo;
    }

    @JsonProperty("cc")
    public Integer getCc() {
        return cc;
    }

    @JsonProperty("cc")
    public void setCc(Integer cc) {
        this.cc = cc;
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
		return "VariacionEngorde [tipoEngorde=" + tipoEngorde + ", generalEnable=" + generalEnable + ", cutsEnable="
				+ cutsEnable + ", vaciasEnable=" + vaciasEnable + ", diferidoEnable=" + diferidoEnable
				+ ", rastrojoEnable=" + rastrojoEnable + ", pasture=" + pasture + ", silage=" + silage + ", grain="
				+ grain + ", diferido=" + diferido + ", rastrojo=" + rastrojo + ", feedlotType=" + feedlotType
				+ ", protein=" + protein + ", intake=" + intake + ", digest=" + digest + ", dRPRotein=" + dRPRotein
				+ ", pesoVivo=" + pesoVivo + ", cc=" + cc + ", ultimaSeleccion=" + ultimaSeleccion
				+ ", additionalProperties=" + additionalProperties + "]";
	}
    
    

}
