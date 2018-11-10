package com.example.restproyect.states;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ensilaje", "recursosforrajeros", "potreros"})
@Entity
public class VariacionesReact {

	//private Usuario user;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JsonProperty("ensilaje")
	private Ensilaje ensilaje;
	
	@JsonProperty("recursosforrajeros")
	private RecursosForrajeros recursosforrajeros;
	
	@JsonProperty("potreros")
	private Potreros potreros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ensilaje getEnsilaje() {
		return ensilaje;
	}

	public void setEnsilaje(Ensilaje ensilaje) {
		this.ensilaje = ensilaje;
	}

	public RecursosForrajeros getRecursosforrajeros() {
		return recursosforrajeros;
	}

	public void setRecursosforrajeros(RecursosForrajeros recursosforrajeros) {
		this.recursosforrajeros = recursosforrajeros;
	}

	@Override
	public String toString() {
		return "VariacionesReact [id=" + id + ", ensilaje=" + ensilaje + ", recursosforrajeros=" + recursosforrajeros
				+ ", potreros=" + potreros + "]";
	}


	
	
}
