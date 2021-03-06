package com.example.restproyect.states.objetosinternos.feedlot;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "pesominimo", "pesomaximo", "pesovivo", "proteinabruta", "digestibilidad", "consumo",
		"proteinadegradable" })
public class FeedLotFattening implements Serializable{

	@JsonProperty("pesominimo")
	private Float pesominimo;
	
	@JsonProperty("pesomaximo")
	private Float pesomaximo;
	
	@JsonProperty("pesovivo")
	private Float pesovivo;
	
	@JsonProperty("proteinabruta")
	private Float proteinabruta;
	
	@JsonProperty("digestibilidad")
	private Float digestibilidad;
	
	@JsonProperty("consumo")
	private Float consumo;
	
	@JsonProperty("proteinadegradable")
	private Float proteinadegradable;
	
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

	public Float getPesominimo() {
		return pesominimo;
	}

	public void setPesominimo(Float pesominimo) {
		this.pesominimo = pesominimo;
	}

	public Float getPesomaximo() {
		return pesomaximo;
	}

	public void setPesomaximo(Float pesomaximo) {
		this.pesomaximo = pesomaximo;
	}

	public Float getPesovivo() {
		return pesovivo;
	}

	public void setPesovivo(Float pesovivo) {
		this.pesovivo = pesovivo;
	}

	public Float getProteinabruta() {
		return proteinabruta;
	}

	public void setProteinabruta(Float proteinabruta) {
		this.proteinabruta = proteinabruta;
	}

	public Float getDigestibilidad() {
		return digestibilidad;
	}

	public void setDigestibilidad(Float digestibilidad) {
		this.digestibilidad = digestibilidad;
	}

	public Float getConsumo() {
		return consumo;
	}

	public void setConsumo(Float consumo) {
		this.consumo = consumo;
	}

	public Float getProteinadegradable() {
		return proteinadegradable;
	}

	public void setProteinadegradable(Float proteinadegradable) {
		this.proteinadegradable = proteinadegradable;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "FeedLotFattening [pesominimo=" + pesominimo + ", pesomaximo=" + pesomaximo + ", pesovivo=" + pesovivo
				+ ", proteinabruta=" + proteinabruta + ", digestibilidad=" + digestibilidad + ", consumo=" + consumo
				+ ", proteinadegradable=" + proteinadegradable + ", additionalProperties=" + additionalProperties + "]";
	}

	public Node generarNodo(Node nodoFattening) {

		NodeList nodeChildrens = nodoFattening.getChildNodes();
		
		
		for(int i = 0; i < nodeChildrens.getLength(); i++) {
			if(nodeChildrens.item(i).getNodeName().equals("cef")) {
				(nodeChildrens.item(i)).getAttributes().getNamedItem("pmax").setNodeValue(String.valueOf(this.pesomaximo));
				(nodeChildrens.item(i)).getAttributes().getNamedItem("pmin").setNodeValue(String.valueOf(this.pesominimo));
			}
			if(nodeChildrens.item(i).getNodeName().equals("csf")) {		
				(nodeChildrens.item(i)).getAttributes().getNamedItem("pout").setNodeValue(String.valueOf(this.pesovivo));
			}
			if(nodeChildrens.item(i).getNodeName().equals("diet")) {
				(nodeChildrens.item(i)).getAttributes().getNamedItem("feedlotDRProtein").setNodeValue(String.valueOf(this.proteinadegradable));
				(nodeChildrens.item(i)).getAttributes().getNamedItem("feedlotDigest").setNodeValue(String.valueOf(this.digestibilidad));
				(nodeChildrens.item(i)).getAttributes().getNamedItem("feedlotIntake").setNodeValue(String.valueOf(this.consumo));
				(nodeChildrens.item(i)).getAttributes().getNamedItem("feedlotBProtein").setNodeValue(String.valueOf(this.proteinabruta));

			}
			
		}		
		
		
		return nodoFattening;
	}
	
	

}