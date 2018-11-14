package com.example.restproyect.states.objetosinternos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "pesominimo", "pesomaximo", "pesovivo", "proteinabruta", "digestibilidad", "consumo",
		"proteinadegradable" })
public class FeedLotCompletion implements Serializable{

	@JsonProperty("pesominimo")
	public Integer pesominimo;
	
	@JsonProperty("pesomaximo")
	public Integer pesomaximo;
	
	@JsonProperty("pesovivo")
	public Integer pesovivo;
	
	@JsonProperty("proteinabruta")
	public Integer proteinabruta;
	
	@JsonProperty("digestibilidad")
	public Integer digestibilidad;
	
	@JsonProperty("consumo")
	public Integer consumo;
	
	@JsonProperty("proteinadegradable")
	public Integer proteinadegradable;
	
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

	public Integer getPesominimo() {
		return pesominimo;
	}

	public void setPesominimo(Integer pesominimo) {
		this.pesominimo = pesominimo;
	}

	public Integer getPesomaximo() {
		return pesomaximo;
	}

	public void setPesomaximo(Integer pesomaximo) {
		this.pesomaximo = pesomaximo;
	}

	public Integer getPesovivo() {
		return pesovivo;
	}

	public void setPesovivo(Integer pesovivo) {
		this.pesovivo = pesovivo;
	}

	public Integer getProteinabruta() {
		return proteinabruta;
	}

	public void setProteinabruta(Integer proteinabruta) {
		this.proteinabruta = proteinabruta;
	}

	public Integer getDigestibilidad() {
		return digestibilidad;
	}

	public void setDigestibilidad(Integer digestibilidad) {
		this.digestibilidad = digestibilidad;
	}

	public Integer getConsumo() {
		return consumo;
	}

	public void setConsumo(Integer consumo) {
		this.consumo = consumo;
	}

	public Integer getProteinadegradable() {
		return proteinadegradable;
	}

	public void setProteinadegradable(Integer proteinadegradable) {
		this.proteinadegradable = proteinadegradable;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "FeedLotCompletion [pesominimo=" + pesominimo + ", pesomaximo=" + pesomaximo + ", pesovivo=" + pesovivo
				+ ", proteinabruta=" + proteinabruta + ", digestibilidad=" + digestibilidad + ", consumo=" + consumo
				+ ", proteinadegradable=" + proteinadegradable + ", additionalProperties=" + additionalProperties + "]";
	}
	
	

}