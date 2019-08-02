package com.example.restproyect.dto;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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
	private Usuario usuario;
	private double valorUltimaPronderacion;
	
	
	public Documento(Document documento, Usuario user) {
		this.documento = documento;
		fechaInicio = new Date();
		fechaUltimoCalculo = new Date();
		this.usuario = user;
		this.valorUltimaPronderacion = 0;
	}
	

	public int getDiferenciaHoras() {
		long diffInMillies = getFechaUltimoCalculo().getTime() - getFechaInicio().getTime();
		//Reemplazar MINUTOS por horas
		double diferencia = (double)TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
		
		return (int)diferencia;
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

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getValorUltimaPronderacion() {
		return valorUltimaPronderacion;
	}


	public void setValorUltimaPronderacion(double valorUltimaPronderacion) {
		this.valorUltimaPronderacion = valorUltimaPronderacion;
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
//		String idUser = this.documento.getChildNodes().item(0).getAttributes().getNamedItem("userId").getNodeValue();
//		String name   = this.documento.getChildNodes().item(0).getAttributes().getNamedItem("name").getNodeValue();
//		return new Usuario(idUser, name);
		return this.documento.getChildNodes().item(0).getAttributes().getNamedItem("userId").getNodeValue();
		
		
	}


	@Override
	public String toString() {
		return "Documento [documento=" + documento + ", fechaInicio=" + fechaInicio + ", fechaUltimoCalculo="
				+ fechaUltimoCalculo + ", calculador=" + calculador + ", User=" + usuario + "]";
	}


	

	
	
	
}
