package com.example.restproyect.dto;

import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.example.restproyect.calculadores.AbsCalculador;

/*
 * CLASE PARA CLONAR LOS DOCUMENTOS
 * */
public class Documento {

	private Document documento;
	private Date fechaInicio;
	private Date fechaUltimoCalculo;
	private AbsCalculador calculador;
	private String idUser;
	
	
	public Documento(Document documento) {
		this.documento = documento;
		fechaInicio = new Date();
		fechaUltimoCalculo = new Date();
		idUser = this.getIdentificadorUsuario();
	}


	public Document getDocumento() {
		return documento;
	}



	public void setDocumento(Document documento) {
		this.documento = documento;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaUltimoCalculo() {
		return fechaUltimoCalculo;
	}


	public void setFechaUltimoCalculo(Date fechaUltimoCalculo) {
		this.fechaUltimoCalculo = fechaUltimoCalculo;
	}


	
	public AbsCalculador getCalculador() {
		return calculador;
	}


	public void setCalculador(AbsCalculador calculador) {
		this.calculador = calculador;
	}

	

	public String getIdUser() {
		return idUser;
	}


	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}


	public Document clonarDocumento() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
			Node originalRoot = documento.getDocumentElement();

	        Document copiedDocument = db.newDocument();
	        Node copiedRoot = copiedDocument.importNode(originalRoot, true);
	        copiedDocument.appendChild(copiedRoot);
	        return copiedDocument;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.reset();
		}
		
		return documento;
		
	}


	/*
	 * Obtener el identificador del usuario del documento 
	 */
	private String getIdentificadorUsuario() {
		
		return this.documento.getChildNodes().item(0).getAttributes().getNamedItem("userId").getNodeName();
		
		
	}


	@Override
	public String toString() {
		return "Documento [documento=" + documento + ", fechaInicio=" + fechaInicio + ", fechaUltimoCalculo="
				+ fechaUltimoCalculo + ", calculador=" + calculador + ", idUser=" + idUser + "]";
	}


	

	
	
	
}
