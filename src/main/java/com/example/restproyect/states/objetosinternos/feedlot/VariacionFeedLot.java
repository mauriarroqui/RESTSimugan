package com.example.restproyect.states.objetosinternos.feedlot;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Completion", "Fattening" })
public class VariacionFeedLot implements Serializable{

	@JsonProperty("Completion")
	private FeedLotCompletion completion;
	
	@JsonProperty("Fattening")
	private FeedLotFattening fattening;
	
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

	@Override
	public String toString() {
		return "VariacionFeedLot [completion=" + completion + ", fattening=" + fattening + "]";
	}

	public FeedLotCompletion getCompletion() {
		return completion;
	}

	public void setCompletion(FeedLotCompletion completion) {
		this.completion = completion;
	}

	public FeedLotFattening getFattening() {
		return fattening;
	}

	public void setFattening(FeedLotFattening fattening) {
		this.fattening = fattening;
	}
	

	
	

}