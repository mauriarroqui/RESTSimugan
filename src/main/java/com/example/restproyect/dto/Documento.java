package com.example.restproyect.dto;

import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/*
 * CLASE PARA CLONAR LOS DOCUMENTOS
 * */
public class Documento {

	private Document documento;
	private Date fechaInicio;
	private Date fechaUltimoCalculo;
	
	
	public Documento(Document documento) {
		this.documento = documento;
		fechaInicio = new Date();
		fechaUltimoCalculo = new Date();
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


	@Override
	public String toString() {
		return "Documento [documento=" + documento + ", fechaInicio=" + fechaInicio + ", fechaUltimoCalculo="
				+ fechaUltimoCalculo + "]";
	}
	
	
}
