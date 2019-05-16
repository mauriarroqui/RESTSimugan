package com.example.restproyect.states.objetosinternos;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ValoresSimulacion implements Serializable {
	
	@JsonProperty("digestValue")
	private float digestValue;
	
	@JsonProperty("yieldValue")	
	private float yieldValue;
	

	public float getDigestValue() {
		return digestValue;
	}

	public void setDigestValue(float digestValue) {
		this.digestValue = digestValue;
	}

	public float getYieldValue() {
		return yieldValue;
	}

	public void setYieldValue(int yieldValue) {
		this.yieldValue = yieldValue;
	}

	@Override
	public String toString() {
		return "ValoresSimulacion [digestValue=" + digestValue + ", yieldValue=" + yieldValue + "]";
	}

	
	
}
