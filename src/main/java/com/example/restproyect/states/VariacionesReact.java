package com.example.restproyect.states;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "ensilaje", "recursosforrajeros", "potreros","rastrojos","invernada","feedlot","diferido"})
@Entity
public class VariacionesReact {

	//private Usuario user;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JsonProperty("ensilaje")
	private Ensilaje ensilaje;
	
	@JsonProperty("recursosforrajeros")
	private RecursoForrajero recursosforrajeros;
	
	@JsonProperty("potreros")
	private Potrero potreros;
	
	@JsonProperty("rastrojos")
	private Rastrojo rastrojo;
	
	@JsonProperty("invernada")
	private Invernada invernada;
	
	@JsonProperty("feedlot")
	private Feedlot feedlot;
	
	@JsonProperty("diferido")
	private Diferido diferido;
	
	@JsonProperty("mobs")
	private Mob mobs;

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

	public RecursoForrajero getRecursosforrajeros() {
		return recursosforrajeros;
	}

	public void setRecursosforrajeros(RecursoForrajero recursosforrajeros) {
		this.recursosforrajeros = recursosforrajeros;
	}

	public Potrero getPotreros() {
		return potreros;
	}

	public void setPotreros(Potrero potreros) {
		this.potreros = potreros;
	}

	public Rastrojo getRastrojo() {
		return rastrojo;
	}

	public void setRastrojo(Rastrojo rastrojo) {
		this.rastrojo = rastrojo;
	}

	public Invernada getInvernada() {
		return invernada;
	}

	public void setInvernada(Invernada invernada) {
		this.invernada = invernada;
	}

	public Feedlot getFeedlot() {
		return feedlot;
	}

	public void setFeedlot(Feedlot feedlot) {
		this.feedlot = feedlot;
	}

	@Override
	public String toString() {
		return "VariacionesReact [id=" + id + ", ensilaje=" + ensilaje + ", recursosforrajeros=" + recursosforrajeros
				+ ", potreros=" + potreros + ", rastrojo=" + rastrojo + ", invernada=" + invernada + ", feedlot="
				+ feedlot + "]";
	}

	


	

	




	
	
}
