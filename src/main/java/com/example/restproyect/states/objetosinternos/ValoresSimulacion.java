package com.example.restproyect.states.objetosinternos;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class ValoresSimulacion implements Serializable {
	
	@JsonProperty("digestValue")
	private int digestValue;
	
	@JsonProperty("yieldValue")
	private int yieldValue;
	

	public int getDigestValue() {
		return digestValue;
	}

	public void setDigestValue(int digestValue) {
		this.digestValue = digestValue;
	}

	public int getYieldValue() {
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
