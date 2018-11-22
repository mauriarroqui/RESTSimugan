package com.example.restproyect.states.objetosinternos.engorde;

import java.io.Serializable;
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
public class VariacionEngorde implements Serializable{

	@JsonProperty("arrayCC")
	public List<Integer> arrayCC = null;
	
	@JsonProperty("arrayDRProtein")
	public List<Integer> arrayDRProtein = null;
	
	@JsonProperty("arrayDigest")
	public List<Integer> arrayDigest = null;
	
	@JsonProperty("arrayIntake")
	public List<Integer> arrayIntake = null;
	
	@JsonProperty("arrayPesoVivo")
	public List<Integer> arrayPesoVivo = null;
	
	@JsonProperty("arrayProtein")
	public List<Integer> arrayProtein = null;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public List<Integer> getArrayCC() {
		return arrayCC;
	}

	public void setArrayCC(List<Integer> arrayCC) {
		this.arrayCC = arrayCC;
	}

	public List<Integer> getArrayDRProtein() {
		return arrayDRProtein;
	}

	public void setArrayDRProtein(List<Integer> arrayDRProtein) {
		this.arrayDRProtein = arrayDRProtein;
	}

	public List<Integer> getArrayDigest() {
		return arrayDigest;
	}

	public void setArrayDigest(List<Integer> arrayDigest) {
		this.arrayDigest = arrayDigest;
	}

	public List<Integer> getArrayIntake() {
		return arrayIntake;
	}

	public void setArrayIntake(List<Integer> arrayIntake) {
		this.arrayIntake = arrayIntake;
	}

	public List<Integer> getArrayPesoVivo() {
		return arrayPesoVivo;
	}

	public void setArrayPesoVivo(List<Integer> arrayPesoVivo) {
		this.arrayPesoVivo = arrayPesoVivo;
	}

	public List<Integer> getArrayProtein() {
		return arrayProtein;
	}

	public void setArrayProtein(List<Integer> arrayProtein) {
		this.arrayProtein = arrayProtein;
	}

	@Override
	public String toString() {
		return "VariacionEngorde [arrayCC=" + arrayCC + ", arrayDRProtein=" + arrayDRProtein + ", arrayDigest="
				+ arrayDigest + ", arrayIntake=" + arrayIntake + ", arrayPesoVivo=" + arrayPesoVivo + ", arrayProtein="
				+ arrayProtein + ", additionalProperties=" + additionalProperties + "]";
	}
	
	

}
