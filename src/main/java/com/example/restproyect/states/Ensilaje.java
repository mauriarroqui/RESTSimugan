package com.example.restproyect.states;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.restproyect.states.objetosinternos.ValoresSimulacion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import antlr.collections.List;




public class Ensilaje implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JsonProperty("permitido")
	private boolean permitido;
	
	@JsonProperty("cantVariaciones")
	private int cantvariaciones;
	
	@JsonProperty("triggerVariaciones")
	private Vector<Integer> triggerVariaciones;
	
	@JsonProperty("leftoverVariaciones")
	private Vector<Integer> leftoverVariaciones;
    
	@JsonProperty("valoresSimulacion")
	private ValoresSimulacion valoresSimulacion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPermitido() {
		return permitido;
	}

	public void setPermitido(boolean permitido) {
		this.permitido = permitido;
	}

	public int getCantvariaciones() {
		return cantvariaciones;
	}

	public void setCantvariaciones(int cantvariaciones) {
		this.cantvariaciones = cantvariaciones;
	}

	public Vector<Integer> getTriggerVariaciones() {
		return triggerVariaciones;
	}

	public void setTriggerVariaciones(Vector<Integer> triggerVariaciones) {
		this.triggerVariaciones = triggerVariaciones;
	}

	public Vector<Integer> getLeftoverVariaciones() {
		return leftoverVariaciones;
	}

	public void setLeftoverVariaciones(Vector<Integer> leftoverVariaciones) {
		this.leftoverVariaciones = leftoverVariaciones;
	}

	
	public ValoresSimulacion getValores() {
		return valoresSimulacion;
	}

	public void setValores(ValoresSimulacion valores) {
		this.valoresSimulacion = valores;
	}

	@Override
	public String toString() {
		return "Ensilaje [id=" + id + ", permitido=" + permitido + ", cantvariaciones=" + cantvariaciones
				+ ", triggerVariaciones=" + triggerVariaciones + ", leftoverVariaciones=" + leftoverVariaciones
				+ ", valores=" + valoresSimulacion + "]";
	}

	
	
	
	
	
	
	
	
	

}
