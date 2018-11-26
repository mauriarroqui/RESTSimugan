package com.example.restproyect;

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
	
	
	public Documento(Document documento) {
		this.documento = documento;
	}


	public Document getDocumento() {
		return documento;
	}



	public void setDocumento(Document documento) {
		this.documento = documento;
	}



	public Document clonarDocumento() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
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
		}
		
		return documento;
		
	}
}
