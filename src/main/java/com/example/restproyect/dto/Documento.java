package com.example.restproyect.dto;

import static java.time.temporal.ChronoUnit.YEARS;

import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.calculadores.AbsCalculador;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;

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
	private int cantidadMobs;
	private int cantidadAnimales;
	private TemporalAccessor fechaInicioSimulacion;
	private TemporalAccessor fechaFinSimulacion;
	private int id;
	private int idPaquete;
	private boolean ultimo;
	//Filtro que busca por el nombre del tag de fecha
	private FiltroAbs filtroNombre;
	
	
	
	public Documento(Document documento, Usuario user) {
		this.documento = documento;
		this.fechaInicio = new Date();
		this.fechaUltimoCalculo = new Date();
		this.usuario = user;
		this.valorUltimaPronderacion = 0;
		this.cantidadMobs = 0;
		this.cantidadAnimales = 0;
		this.id = 0;
		this.filtroNombre = new FiltroNombre("simulation");
		this.setearFechasSimulacion();
		this.ultimo = false;
	}
	
	private void setearFechasSimulacion() {
		NodeList node = (NodeList) this.documento.getChildNodes().item(0).getChildNodes();
		for(int j=0; j < node.getLength(); j++) {
			if(j%2 != 0) {
				Node nodo =  node.item(j);
				if(this.filtroNombre.cumple(nodo)) {
					
					String diaInicio , mesInicio, anoInicio, diaFin, mesFin, anoFin = "";

					diaInicio = nodo.getAttributes().getNamedItem("startingDay").getNodeValue();
					mesInicio = nodo.getAttributes().getNamedItem("startingMonth").getNodeValue();
					anoInicio = nodo.getAttributes().getNamedItem("startingYear").getNodeValue();
					diaFin = nodo.getAttributes().getNamedItem("finishingDay").getNodeValue();
					mesFin = nodo.getAttributes().getNamedItem("finishingMonth").getNodeValue();
					anoFin = nodo.getAttributes().getNamedItem("finishingYear").getNodeValue();
					 
			        
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			        if(mesInicio.length()==1) {
			        	mesInicio="0"+mesInicio;
			        }
			        if(mesFin.length()==1) {
			        	mesFin="0"+mesFin;
			        }
			        if(diaInicio.length()==1) {
			        	diaInicio = "0"+diaInicio;
			        }
			        if(diaFin.length()==1) {
			        	diaFin = "0"+diaFin;
			        }
			        this.fechaInicioSimulacion = formatter.parse(diaInicio+"/"+mesInicio+"/"+anoInicio);
			        this.fechaFinSimulacion    = formatter.parse(diaFin+"/"+mesFin+"/"+anoFin);
			       
				}
			}
		}
	}
	
	public int getDiferenciaHoras() {
		long diffInMillies = getFechaUltimoCalculo().getTime() - getFechaInicio().getTime();
		//Reemplazar MINUTOS por horas
		double diferencia = (double)TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
		
		return (int)diferencia;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TemporalAccessor getFechaInicioSimulacion() {
		return fechaInicioSimulacion;
	}

	public void setFechaInicioSimulacion(TemporalAccessor fechaInicioSimulacion) {
		this.fechaInicioSimulacion = fechaInicioSimulacion;
	}

	public TemporalAccessor getFechaFinSimulacion() {
		return fechaFinSimulacion;
	}

	public void setFechaFinSimulacion(TemporalAccessor fechaFinSimulacion) {
		this.fechaFinSimulacion = fechaFinSimulacion;
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

	

	public int getCantidadMobs() {
		return cantidadMobs;
	}


	public void setCantidadMobs(int cantidadMobs) {
		this.cantidadMobs = cantidadMobs;
	}

	

	public int getCantidadAnimales() {
		return cantidadAnimales;
	}


	public void setCantidadAnimales(int cantidadAnimales) {
		this.cantidadAnimales = cantidadAnimales;
	}

	public int getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(int idPaquete) {
		this.idPaquete = idPaquete;
	}
	
	

	public boolean isUltimo() {
		return ultimo;
	}

	public void setUltimo(boolean ultimo) {
		this.ultimo = ultimo;
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


	@Override
	public String toString() {
		return "Documento [documento=" + documento + ", fechaInicio=" + fechaInicio + ", fechaUltimoCalculo="
				+ fechaUltimoCalculo + ", calculador=" + calculador + ", User=" + usuario + "]";
	}


	

	
	
	
}
