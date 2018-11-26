package com.example.restproyect.states;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;

import org.springframework.cglib.core.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
	
	@JsonProperty("destete")
	private Destete destete;
	
	@JsonProperty("engorde")
	private Engorde engorde;

	@JsonProperty("xmloriginal")
	private String xml;
	
	@Transient
	private Document documento;
	
	
	public VariacionesReact(Long id, Ensilaje ensilaje, RecursoForrajero recursosforrajeros, Potrero potreros,
			Rastrojo rastrojo, Invernada invernada, Feedlot feedlot, Diferido diferido, Mob mobs, Destete destete,
			Engorde engorde, String xml) {
		super();
		this.id = id;
		this.ensilaje = ensilaje;
		this.recursosforrajeros = recursosforrajeros;
		this.potreros = potreros;
		this.rastrojo = rastrojo;
		this.invernada = invernada;
		this.feedlot = feedlot;
		this.diferido = diferido;
		this.mobs = mobs;
		this.destete = destete;
		this.engorde = engorde;
		this.xml = xml;
		//this.documento = this.generarDocumento();
	}

	public Document generarDocumento() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder;  
		try {  
		    builder = factory.newDocumentBuilder(); 		   
		    Document document = builder.parse(new InputSource(new StringReader(this.xml)));
		    this.documento = document;
		} catch (Exception e) {  
		    e.printStackTrace();  
		}
		return null; 
		
	}
	
	public Document clonarDocumento(Document originalDocument) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Node originalRoot = originalDocument.getDocumentElement();

	        Document copiedDocument = db.newDocument();
	        Node copiedRoot = copiedDocument.importNode(originalRoot, true);
	        copiedDocument.appendChild(copiedRoot);
	        return copiedDocument;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
        
        
	}
	
	

	public Engorde getEngorde() {
		return engorde;
	}

	public void setEngorde(Engorde engorde) {
		this.engorde = engorde;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}


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

	public Diferido getDiferido() {
		return diferido;
	}

	public void setDiferido(Diferido diferido) {
		this.diferido = diferido;
	}

	public Mob getMobs() {
		return mobs;
	}

	public void setMobs(Mob mobs) {
		this.mobs = mobs;
	}

	public Destete getDestete() {
		return destete;
	}

	public void setDestete(Destete destete) {
		this.destete = destete;
	}

	
	public Document getDocumento() {
		return documento;
	}

	public void setDocumento(Document documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "VariacionesReact [id=" + id + ", ensilaje=" + ensilaje + ", recursosforrajeros=" + recursosforrajeros
				+ ", potreros=" + potreros + ", rastrojo=" + rastrojo + ", invernada=" + invernada + ", feedlot="
				+ feedlot + ", diferido=" + diferido + ", mobs=" + mobs + ", destete=" + destete + ", engorde="
				+ engorde + ", xml=" + xml + "]";
	}

	

		
	
}
