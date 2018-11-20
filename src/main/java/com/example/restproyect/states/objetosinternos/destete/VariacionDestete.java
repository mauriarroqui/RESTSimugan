
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
    public Boolean habilitarPeso;
    @JsonProperty("habilitarCC")
    public Boolean habilitarCC;
    @JsonProperty("umbral")
    public Integer umbral;
    @JsonProperty("calfDietBProtein")
    public Integer calfDietBProtein;
    @JsonProperty("calfDestiny")
    public Integer calfDestiny;
    @JsonProperty("calfDietIntake")
    public Integer calfDietIntake;
    @JsonProperty("calfDietDigest")
    public Integer calfDietDigest;
    @JsonProperty("calfDietDRProtein")
    public Integer calfDietDRProtein;
    @JsonProperty("umbralBcs")
    public Integer umbralBcs;
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
	public Integer getUmbral() {
		return umbral;
	}
	public void setUmbral(Integer umbral) {
		this.umbral = umbral;
	}
	public Integer getCalfDietBProtein() {
		return calfDietBProtein;
	}
	public void setCalfDietBProtein(Integer calfDietBProtein) {
		this.calfDietBProtein = calfDietBProtein;
	}
	public Integer getCalfDestiny() {
		return calfDestiny;
	}
	public void setCalfDestiny(Integer calfDestiny) {
		this.calfDestiny = calfDestiny;
	}
	public Integer getCalfDietIntake() {
		return calfDietIntake;
	}
	public void setCalfDietIntake(Integer calfDietIntake) {
		this.calfDietIntake = calfDietIntake;
	}
	public Integer getCalfDietDigest() {
		return calfDietDigest;
	}
	public void setCalfDietDigest(Integer calfDietDigest) {
		this.calfDietDigest = calfDietDigest;
	}
	public Integer getCalfDietDRProtein() {
		return calfDietDRProtein;
	}
	public void setCalfDietDRProtein(Integer calfDietDRProtein) {
		this.calfDietDRProtein = calfDietDRProtein;
	}
	public Integer getUmbralBcs() {
		return umbralBcs;
	}
	public void setUmbralBcs(Integer umbralBcs) {
		this.umbralBcs = umbralBcs;
	}
	@Override
	public String toString() {
		return "VariacionDestete [habilitarPeso=" + habilitarPeso + ", habilitarCC=" + habilitarCC + ", umbral="
				+ umbral + ", calfDietBProtein=" + calfDietBProtein + ", calfDestiny=" + calfDestiny
				+ ", calfDietIntake=" + calfDietIntake + ", calfDietDigest=" + calfDietDigest + ", calfDietDRProtein="
				+ calfDietDRProtein + ", umbralBcs=" + umbralBcs + "]";
	}

    
  

}
