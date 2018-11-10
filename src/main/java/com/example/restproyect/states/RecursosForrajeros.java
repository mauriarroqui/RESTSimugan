package com.example.restproyect.states;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import com.example.restproyect.states.objetosinternos.PagVariacion;
import com.example.restproyect.states.objetosinternos.ValoresMeses;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "permitido", "cantVariaciones", "inputsPorVariacion", "paginaActual", "dropDownSelected",
		"pagvariaciones", "nombrePasturas", "valoresMeses" })


public class RecursosForrajeros implements Serializable{

	@JsonProperty("permitido")
	public Boolean permitido;
	
	@JsonProperty("cantVariaciones")
	public Integer cantVariaciones;
	
	@JsonProperty("inputsPorVariacion")
	public Integer inputsPorVariacion;
	
	@JsonProperty("paginaActual")
	public Integer paginaActual;
	
	@JsonProperty("dropDownSelected")
	public Integer dropDownSelected;
	
	@JsonProperty("pagvariaciones")
	public List<List<List<PagVariacion>>> pagvariaciones = null;
	
	@JsonProperty("nombrePasturas")
	public List<String> nombrePasturas = null;
	
	@JsonProperty("valoresMeses")
	public List<ValoresMeses> valoresMeses = null;
	
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

	public Integer getInputsPorVariacion() {
		return inputsPorVariacion;
	}

	public void setInputsPorVariacion(Integer inputsPorVariacion) {
		this.inputsPorVariacion = inputsPorVariacion;
	}

	public Integer getPaginaActual() {
		return paginaActual;
	}

	public void setPaginaActual(Integer paginaActual) {
		this.paginaActual = paginaActual;
	}

	public Integer getDropDownSelected() {
		return dropDownSelected;
	}

	public void setDropDownSelected(Integer dropDownSelected) {
		this.dropDownSelected = dropDownSelected;
	}

	public List<List<List<PagVariacion>>> getPagvariaciones() {
		return pagvariaciones;
	}

	public void setPagvariaciones(List<List<List<PagVariacion>>> pagvariaciones) {
		this.pagvariaciones = pagvariaciones;
	}

	public List<String> getNombrePasturas() {
		return nombrePasturas;
	}

	public void setNombrePasturas(List<String> nombrePasturas) {
		this.nombrePasturas = nombrePasturas;
	}

	public List<ValoresMeses> getValoresMeses() {
		return valoresMeses;
	}

	public void setValoresMeses(List<ValoresMeses> valoresMeses) {
		this.valoresMeses = valoresMeses;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "RecursosForrajeros [permitido=" + permitido + ", cantVariaciones=" + cantVariaciones
				+ ", inputsPorVariacion=" + inputsPorVariacion + ", paginaActual=" + paginaActual
				+ ", dropDownSelected=" + dropDownSelected + ", pagvariaciones=" + pagvariaciones + ", nombrePasturas="
				+ nombrePasturas + ", valoresMeses=" + valoresMeses + ", additionalProperties=" + additionalProperties
				+ "]";
	}

	
}