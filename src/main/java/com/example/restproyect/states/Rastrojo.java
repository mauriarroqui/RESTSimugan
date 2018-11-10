package com.example.restproyect.states;

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
@JsonPropertyOrder({ "permitido", "cantVariaciones", "dropdownSelected", "digestibilidadVariaciones",
		"rindeVariaciones", "nombreRastrojos", "valoresSimulacion" })
public class Rastrojo {

	@JsonProperty("permitido")
	public Boolean permitido;
	
	@JsonProperty("cantVariaciones")
	public Integer cantVariaciones;
	
	@JsonProperty("dropdownSelected")
	public Integer dropdownSelected;
	
	@JsonProperty("digestibilidadVariaciones")
	public List<List<String>> digestibilidadVariaciones = null;
	
	@JsonProperty("rindeVariaciones")
	public List<List<String>> rindeVariaciones = null;
	
	@JsonProperty("nombreRastrojos")
	public List<String> nombreRastrojos = null;
	
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

	public Integer getDropdownSelected() {
		return dropdownSelected;
	}

	public void setDropdownSelected(Integer dropdownSelected) {
		this.dropdownSelected = dropdownSelected;
	}

	public List<List<String>> getDigestibilidadVariaciones() {
		return digestibilidadVariaciones;
	}

	public void setDigestibilidadVariaciones(List<List<String>> digestibilidadVariaciones) {
		this.digestibilidadVariaciones = digestibilidadVariaciones;
	}

	public List<List<String>> getRindeVariaciones() {
		return rindeVariaciones;
	}

	public void setRindeVariaciones(List<List<String>> rindeVariaciones) {
		this.rindeVariaciones = rindeVariaciones;
	}

	public List<String> getNombreRastrojos() {
		return nombreRastrojos;
	}

	public void setNombreRastrojos(List<String> nombreRastrojos) {
		this.nombreRastrojos = nombreRastrojos;
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
		return "Rastrojo [permitido=" + permitido + ", cantVariaciones=" + cantVariaciones + ", dropdownSelected="
				+ dropdownSelected + ", digestibilidadVariaciones=" + digestibilidadVariaciones + ", rindeVariaciones="
				+ rindeVariaciones + ", nombreRastrojos=" + nombreRastrojos + ", valoresSimulacion=" + valoresSimulacion
				+ ", additionalProperties=" + additionalProperties + "]";
	}

	
}