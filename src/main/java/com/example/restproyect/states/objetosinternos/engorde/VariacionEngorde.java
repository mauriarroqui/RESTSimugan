package com.example.restproyect.states.objetosinternos.engorde;


import java.io.Serializable;
import java.util.ArrayList;
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
public class VariacionEngorde implements Serializable,Cloneable{

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
    private List<Float> pasture = null;
    
    @JsonProperty("silage")
    private List<Float> silage = null;
    
    @JsonProperty("grain")
    private List<Float> grain = null;
    
    @JsonProperty("diferido")
    private List<Float> diferido = null;
    
    @JsonProperty("rastrojo")
    private List<Float> rastrojo = null;
    
    @JsonProperty("feedlotType")
    private String feedlotType;
    
    @JsonProperty("protein")
    private Float protein;
    
    @JsonProperty("intake")
    private Float intake;
    
    @JsonProperty("digest")
    private Float digest;
    
    @JsonProperty("DRPRotein")
    private Float dRPRotein;
    
    @JsonProperty("pesoVivo")
    private Float pesoVivo;
    
    @JsonProperty("cc")
    private Float cc;
    
    @Transient
    private int ultimaSeleccion;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();    
    
    public VariacionEngorde(String tipoEngorde, Boolean generalEnable, Boolean cutsEnable, Boolean vaciasEnable,
			Boolean diferidoEnable, Boolean rastrojoEnable, List<Float> pasture, List<Float> silage,
			List<Float> grain, List<Float> diferido, List<Float> rastrojo, String feedlotType, Float protein,
			Float intake, Float digest, Float dRPRotein, Float pesoVivo, Float cc, int ultimaSeleccion,
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
    public List<Float> getPasture() {
        return pasture;
    }

    @JsonProperty("pasture")
    public void setPasture(List<Float> pasture) {
        this.pasture = pasture;
    }

    @JsonProperty("silage")
    public List<Float> getSilage() {
        return silage;
    }

    @JsonProperty("silage")
    public void setSilage(List<Float> silage) {
        this.silage = silage;
    }

    @JsonProperty("grain")
    public List<Float> getGrain() {
        return grain;
    }

    @JsonProperty("grain")
    public void setGrain(List<Float> grain) {
        this.grain = grain;
    }

    @JsonProperty("diferido")
    public List<Float> getDiferido() {
        return diferido;
    }

    @JsonProperty("diferido")
    public void setDiferido(List<Float> diferido) {
        this.diferido = diferido;
    }

    @JsonProperty("rastrojo")
    public List<Float> getRastrojo() {
        return rastrojo;
    }

    @JsonProperty("rastrojo")
    public void setRastrojo(List<Float> rastrojo) {
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
    public Float getProtein() {
        return protein;
    }

    @JsonProperty("protein")
    public void setProtein(Float protein) {
        this.protein = protein;
    }

    @JsonProperty("intake")
    public Float getIntake() {
        return intake;
    }

    @JsonProperty("intake")
    public void setIntake(Float intake) {
        this.intake = intake;
    }

    @JsonProperty("digest")
    public Float getDigest() {
        return digest;
    }

    @JsonProperty("digest")
    public void setDigest(Float digest) {
        this.digest = digest;
    }

    @JsonProperty("DRPRotein")
    public Float getDRPRotein() {
        return dRPRotein;
    }

    @JsonProperty("DRPRotein")
    public void setDRPRotein(Float dRPRotein) {
        this.dRPRotein = dRPRotein;
    }

    @JsonProperty("pesoVivo")
    public Float getPesoVivo() {
        return pesoVivo;
    }

    @JsonProperty("pesoVivo")
    public void setPesoVivo(Float pesoVivo) {
        this.pesoVivo = pesoVivo;
    }

    @JsonProperty("cc")
    public Float getCc() {
        return cc;
    }

    @JsonProperty("cc")
    public void setCc(Float cc) {
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
	
	public VariacionEngorde clone(){
		// TODO Auto-generated method stub
		try {
			VariacionEngorde clonado = (VariacionEngorde) super.clone();
			clonado.setDiferido(new ArrayList<Float>(diferido));
		    clonado.setPasture(new ArrayList<Float>(pasture));
		    clonado.setSilage(new ArrayList<Float>(silage));
		    clonado.setGrain(new ArrayList<Float>(grain));
		    clonado.setRastrojo(new ArrayList<Float>(rastrojo));
			return clonado;//new VariacionEngorde(tipoEngorde, generalEnable, cutsEnable, vaciasEnable, diferidoEnable, rastrojoEnable, pasture, silage, grain, diferido, rastrojo, feedlotType, protein, intake, digest, dRPRotein, pesoVivo, cc, ultimaSeleccion, additionalProperties);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en el clonado de VariacionEngorde: "+e.getCause());
		}
		return null;
	}
    
    

}
