package com.example.restproyect.states.objetosinternos.engorde;




import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class VariacionEngorde implements Serializable{

    @JsonProperty("tipoEngorde")
    public String tipoEngorde;
    @JsonProperty("generalEnable")
    public Boolean generalEnable;
    @JsonProperty("cutsEnable")
    public Boolean cutsEnable;
    @JsonProperty("vaciasEnable")
    public Boolean vaciasEnable;
    @JsonProperty("diferidoEnable")
    public Boolean diferidoEnable;
    @JsonProperty("rastrojoEnable")
    public Boolean rastrojoEnable;
    @JsonProperty("pasture")
    public List<Integer> pasture = null;
    @JsonProperty("silage")
    public List<Integer> silage = null;
    @JsonProperty("grain")
    public List<Integer> grain = null;
    @JsonProperty("diferido")
    public List<Integer> diferido = null;
    @JsonProperty("rastrojo")
    public List<Integer> rastrojo = null;
    @JsonProperty("feedlotType")
    public String feedlotType;
    @JsonProperty("protein")
    public Integer protein;
    @JsonProperty("intake")
    public Integer intake;
    @JsonProperty("digest")
    public Integer digest;
    @JsonProperty("DRPRotein")
    public Integer dRPRotein;
    @JsonProperty("pesoVivo")
    public Integer pesoVivo;
    @JsonProperty("cc")
    public Integer cc;
    
    
    
    
	public VariacionEngorde(String tipoEngorde, Boolean generalEnable, Boolean cutsEnable, Boolean vaciasEnable,
			Boolean diferidoEnable, Boolean rastrojoEnable, List<Integer> pasture, List<Integer> silage,
			List<Integer> grain, List<Integer> diferido, List<Integer> rastrojo, String feedlotType, Integer protein,
			Integer intake, Integer digest, Integer dRPRotein, Integer pesoVivo, Integer cc) {
		super();
		this.tipoEngorde = tipoEngorde;
		this.generalEnable = generalEnable;
		this.cutsEnable = cutsEnable;
		this.vaciasEnable = vaciasEnable;
		this.diferidoEnable = diferidoEnable;
		this.rastrojoEnable = rastrojoEnable;
		this.pasture = pasture;
		this.silage = silage;
		this.grain = grain;
		this.diferido = diferido;
		this.rastrojo = rastrojo;
		this.feedlotType = feedlotType;
		this.protein = protein;
		this.intake = intake;
		this.digest = digest;
		this.dRPRotein = dRPRotein;
		this.pesoVivo = pesoVivo;
		this.cc = cc;
	}
	public String getTipoEngorde() {
		return tipoEngorde;
	}
	public void setTipoEngorde(String tipoEngorde) {
		this.tipoEngorde = tipoEngorde;
	}
	public Boolean getGeneralEnable() {
		return generalEnable;
	}
	public void setGeneralEnable(Boolean generalEnable) {
		this.generalEnable = generalEnable;
	}
	public Boolean getCutsEnable() {
		return cutsEnable;
	}
	public void setCutsEnable(Boolean cutsEnable) {
		this.cutsEnable = cutsEnable;
	}
	public Boolean getVaciasEnable() {
		return vaciasEnable;
	}
	public void setVaciasEnable(Boolean vaciasEnable) {
		this.vaciasEnable = vaciasEnable;
	}
	public Boolean getDiferidoEnable() {
		return diferidoEnable;
	}
	public void setDiferidoEnable(Boolean diferidoEnable) {
		this.diferidoEnable = diferidoEnable;
	}
	public Boolean getRastrojoEnable() {
		return rastrojoEnable;
	}
	public void setRastrojoEnable(Boolean rastrojoEnable) {
		this.rastrojoEnable = rastrojoEnable;
	}
	public List<Integer> getPasture() {
		return pasture;
	}
	public void setPasture(List<Integer> pasture) {
		this.pasture = pasture;
	}
	public List<Integer> getSilage() {
		return silage;
	}
	public void setSilage(List<Integer> silage) {
		this.silage = silage;
	}
	public List<Integer> getGrain() {
		return grain;
	}
	public void setGrain(List<Integer> grain) {
		this.grain = grain;
	}
	public List<Integer> getDiferido() {
		return diferido;
	}
	public void setDiferido(List<Integer> diferido) {
		this.diferido = diferido;
	}
	public List<Integer> getRastrojo() {
		return rastrojo;
	}
	public void setRastrojo(List<Integer> rastrojo) {
		this.rastrojo = rastrojo;
	}
	public String getFeedlotType() {
		return feedlotType;
	}
	public void setFeedlotType(String feedlotType) {
		this.feedlotType = feedlotType;
	}
	public Integer getProtein() {
		return protein;
	}
	public void setProtein(Integer protein) {
		this.protein = protein;
	}
	public Integer getIntake() {
		return intake;
	}
	public void setIntake(Integer intake) {
		this.intake = intake;
	}
	public Integer getDigest() {
		return digest;
	}
	public void setDigest(Integer digest) {
		this.digest = digest;
	}
	public Integer getdRPRotein() {
		return dRPRotein;
	}
	public void setdRPRotein(Integer dRPRotein) {
		this.dRPRotein = dRPRotein;
	}
	public Integer getPesoVivo() {
		return pesoVivo;
	}
	public void setPesoVivo(Integer pesoVivo) {
		this.pesoVivo = pesoVivo;
	}
	public Integer getCc() {
		return cc;
	}
	public void setCc(Integer cc) {
		this.cc = cc;
	}
	@Override
	public String toString() {
		return "VariacionEngorde [tipoEngorde=" + tipoEngorde + ", generalEnable=" + generalEnable + ", cutsEnable="
				+ cutsEnable + ", vaciasEnable=" + vaciasEnable + ", diferidoEnable=" + diferidoEnable
				+ ", rastrojoEnable=" + rastrojoEnable + ", pasture=" + pasture + ", silage=" + silage + ", grain="
				+ grain + ", diferido=" + diferido + ", rastrojo=" + rastrojo + ", feedlotType=" + feedlotType
				+ ", protein=" + protein + ", intake=" + intake + ", digest=" + digest + ", dRPRotein=" + dRPRotein
				+ ", pesoVivo=" + pesoVivo + ", cc=" + cc + "]";
	}
    
    
    

}
