package com.example.restproyect.states;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.restproyect.states.objetosinternos.ValoresSimulacion;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "permitido", "cantVariaciones", "dropDownSelected", "digestibilidadVariaciones", "nombrePotreros",
		"valoresSimulacion" })

public class Potreros implements Serializable{

	@JsonProperty("permitido")
	public Boolean permitido;
	
	@JsonProperty("cantVariaciones")
	public Integer cantVariaciones;
	
	@JsonProperty("dropDownSelected")
	public Integer dropDownSelected;
	
	@JsonProperty("digestibilidadVariaciones")
	public List<List<Integer>> digestibilidadVariaciones = null;
	
	@JsonProperty("nombrePotreros")
	public List<String> nombrePotreros = null;
	
	@JsonProperty("valoresSimulacion")
	public List<ValoresSimulacion> valoresSimulacion = null;
	
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

	public Boolean getPermitido() {
		return permitido;
	}

	public void setPermitido(Boolean permitido) {
		this.permitido = permitido;
	}

	public Integer getCantVariaciones() {
		return cantVariaciones;
	}

	public void setCantVariaciones(Integer cantVariaciones) {
		this.cantVariaciones = cantVariaciones;
	}

	public Integer getDropDownSelected() {
		return dropDownSelected;
	}

	public void setDropDownSelected(Integer dropDownSelected) {
		this.dropDownSelected = dropDownSelected;
	}

	public List<List<Integer>> getDigestibilidadVariaciones() {
		return digestibilidadVariaciones;
	}

	public void setDigestibilidadVariaciones(List<List<Integer>> digestibilidadVariaciones) {
		this.digestibilidadVariaciones = digestibilidadVariaciones;
	}

	public List<String> getNombrePotreros() {
		return nombrePotreros;
	}

	public void setNombrePotreros(List<String> nombrePotreros) {
		this.nombrePotreros = nombrePotreros;
	}

	public List<ValoresSimulacion> getValoresSimulacion() {
		return valoresSimulacion;
	}

	public void setValoresSimulacion(List<ValoresSimulacion> valoresSimulacion) {
		this.valoresSimulacion = valoresSimulacion;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Potreros [permitido=" + permitido + ", cantVariaciones=" + cantVariaciones + ", dropDownSelected="
				+ dropDownSelected + ", digestibilidadVariaciones=" + digestibilidadVariaciones + ", nombrePotreros="
				+ nombrePotreros + ", valoresSimulacion=" + valoresSimulacion + ", additionalProperties="
				+ additionalProperties + "]";
	}

	
}
