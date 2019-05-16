
package com.example.restproyect.states.objetosinternos.destete;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "habilitarPeso",
    "habilitarCC",
    "umbral",
    "calfDietBProtein",
    "calfDestiny",
    "calfDietIntake",
    "calfDietDigest",
    "calfDietDRProtein",
    "umbralBcs"
})
public class VariacionDestete implements Serializable{

    @JsonProperty("habilitarPeso")
    private Boolean habilitarPeso;
    
    @JsonProperty("habilitarCC")
    private Boolean habilitarCC;
    
    @JsonProperty("umbral")
    private Float umbral;
    
    @JsonProperty("calfDietBProtein")
    private Float calfDietBProtein;
    
    @JsonProperty("calfDestiny")
    private Float calfDestiny;
    
    @JsonProperty("calfDietIntake")
    private Float calfDietIntake;
    
    @JsonProperty("calfDietDigest")
    private Float calfDietDigest;
    
    @JsonProperty("calfDietDRProtein")
    private Float calfDietDRProtein;
    
    @JsonProperty("umbralBcs")
    private Float umbralBcs;
    
    
	public VariacionDestete(Boolean habilitarPeso, Boolean habilitarCC, Float umbral, Float calfDietBProtein,
			Float calfDestiny, Float calfDietIntake, Float calfDietDigest, Float calfDietDRProtein,
			Float umbralBcs) {
		super();
		this.habilitarPeso = habilitarPeso;
		this.habilitarCC = habilitarCC;
		this.umbral = umbral;
		this.calfDietBProtein = calfDietBProtein;
		this.calfDestiny = calfDestiny;
		this.calfDietIntake = calfDietIntake;
		this.calfDietDigest = calfDietDigest;
		this.calfDietDRProtein = calfDietDRProtein;
		this.umbralBcs = umbralBcs;
	}
	public Boolean getHabilitarPeso() {
		return habilitarPeso;
	}
	public void setHabilitarPeso(Boolean habilitarPeso) {
		this.habilitarPeso = habilitarPeso;
	}
	public Boolean getHabilitarCC() {
		return habilitarCC;
	}
	public void setHabilitarCC(Boolean habilitarCC) {
		this.habilitarCC = habilitarCC;
	}
	public Float getUmbral() {
		return umbral;
	}
	public void setUmbral(Float umbral) {
		this.umbral = umbral;
	}
	public Float getCalfDietBProtein() {
		return calfDietBProtein;
	}
	public void setCalfDietBProtein(Float calfDietBProtein) {
		this.calfDietBProtein = calfDietBProtein;
	}
	public Float getCalfDestiny() {
		return calfDestiny;
	}
	public void setCalfDestiny(Float calfDestiny) {
		this.calfDestiny = calfDestiny;
	}
	public Float getCalfDietIntake() {
		return calfDietIntake;
	}
	public void setCalfDietIntake(Float calfDietIntake) {
		this.calfDietIntake = calfDietIntake;
	}
	public Float getCalfDietDigest() {
		return calfDietDigest;
	}
	public void setCalfDietDigest(Float calfDietDigest) {
		this.calfDietDigest = calfDietDigest;
	}
	public Float getCalfDietDRProtein() {
		return calfDietDRProtein;
	}
	public void setCalfDietDRProtein(Float calfDietDRProtein) {
		this.calfDietDRProtein = calfDietDRProtein;
	}
	public Float getUmbralBcs() {
		return umbralBcs;
	}
	public void setUmbralBcs(Float umbralBcs) {
		this.umbralBcs = umbralBcs;
	}
	@Override
	public String toString() {
		return "VariacionDestete [habilitarPeso=" + habilitarPeso + ", habilitarCC=" + habilitarCC + ", umbral="
				+ umbral + ", calfDietBProtein=" + calfDietBProtein + ", calfDestiny=" + calfDestiny
				+ ", calfDietIntake=" + calfDietIntake + ", calfDietDigest=" + calfDietDigest + ", calfDietDRProtein="
				+ calfDietDRProtein + ", umbralBcs=" + umbralBcs + "]";
	}

    public VariacionDestete clone() {
    	return new VariacionDestete(habilitarPeso, habilitarCC, umbral, calfDietBProtein, calfDestiny, calfDietIntake, calfDietDigest, calfDietDRProtein, umbralBcs);
    }
  

}
