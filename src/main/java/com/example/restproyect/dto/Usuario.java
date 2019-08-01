package com.example.restproyect.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;
import com.example.restproyect.filtros.FiltroTipoUsuario;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idUser", "name" })
public class Usuario implements Serializable{

	/*
	 * Campos que mapean el JSON a memoria 
	 */
	@JsonProperty("idUser")
	private String idUser;
	
	@JsonProperty("name")
	private String name;
	
	/*
	 * Campos para ver a donde se agrega el usuario y que tipo tiene
	 */
	@Transient
	private String tipoUsuario;
		
	@Transient
    private FiltroAbs filtro = new FiltroTipoUsuario("Simulacion");
	
	/*
	 * Campos para almacenar informacion del usuario para ver parametros 
	 * de calculo para priorizar las simulaciones
	 */
	@Transient
	private int cantidadEscenarios;
	
	@Transient
	private int miliSegundosDeUso;
	
	/*
	 * Fin de campos de almacenamiento para priorizar
	 */
	
	@JsonIgnore	
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	
	
	public Usuario(String idUser, String name, Map<String, Object> additionalProperties) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.tipoUsuario = "Experimentacion";
		this.additionalProperties = additionalProperties;
		this.cantidadEscenarios = 0;
		miliSegundosDeUso = 0;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	
	public FiltroAbs getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroAbs filtro) {
		this.filtro = filtro;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	
	
	public int getCantidadEscenarios() {
		return cantidadEscenarios;
	}

	public void setCantidadEscenarios(int cantidadEscenarios) {
		this.cantidadEscenarios = cantidadEscenarios;
	}

	public int getMiliSegundosDeUso() {
		return miliSegundosDeUso;
	}

	public void setMiliSegundosDeUso(int miliSegundosDeUso) {
		this.miliSegundosDeUso = miliSegundosDeUso;
	}

	@Override
	public String toString() {
		return "Usuario [idUser=" + idUser + ", name=" + name + ", tipoUsuario=" + tipoUsuario + ", filtro=" + filtro
				+ ", cantidadEscenarios=" + cantidadEscenarios + ", miliSegundosDeUso=" + miliSegundosDeUso
				+ ", additionalProperties=" + additionalProperties + "]";
	}

	

	
	
	

}