package com.example.restproyect.states;

import java.io.StringReader;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.example.restproyect.dto.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Simulacion {

	@JsonProperty("xml")
	private String escenario;
	
	
	@JsonProperty("usuario")
	private Usuario usuario;
	

	@Transient
	private Document documento;

	public Simulacion(String escenario, Document documento) {
		super();
		this.escenario = escenario;
		this.documento = documento;
	}

	public String getEscenario() {
		return escenario;
	}

	public void setEscenario(String escenario) {
		this.escenario = escenario;
	}

	public Document getDocumento() {
		return documento;
	}

	public void setDocumento(Document documento) {
		this.documento = documento;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Document generarDocumento() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder;  
		try {  
		    builder = factory.newDocumentBuilder(); 		   
		    Document document = builder.parse(new InputSource(new StringReader(this.escenario)));
		    this.documento = document;
		} catch (Exception e) {  
		    e.printStackTrace();  
		}
		return null; 
		
	}
	
}
