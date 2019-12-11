package com.example.restproyect.mocks;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.restproyect.colaprioridad.ColaPaquete;
import com.example.restproyect.dto.Documento;

@Service
@Qualifier("mockgrid")
public class Mockgrid {
	
	private ExecutorService pool;
	private int nodosDisponibles;
	public static final int CANTIDAD_NODOS = 4;
	private ArrayList<Documento> documentosProcesados;
	private ColaPaquete colaPaquetes;	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ArrayList<Documento> documentosAProcesar;
	
	@Value("${utilizar.simugan}")
	private boolean utilizarSimugan;
	
	public Mockgrid() {
		super();
		this.pool = Executors.newFixedThreadPool(CANTIDAD_NODOS);
		this.nodosDisponibles = CANTIDAD_NODOS;
		this.documentosProcesados = new ArrayList<Documento>();
		this.documentosAProcesar = new ArrayList<Documento>();
	}
	
	public synchronized boolean ocuparNodo() {
		if(nodosDisponibles > 0) {
			nodosDisponibles--;
			return true;
		}
		return false;
	}
	
	public synchronized boolean liberarNodo() {
		if(nodosDisponibles < CANTIDAD_NODOS) {
			nodosDisponibles++;
			return true;
		}
		return false;
	}
	
	
	public ColaPaquete getColaPaquetes() {
		return colaPaquetes;
	}

	public void setColaPaquetes(ColaPaquete colaPaquetes) {
		this.colaPaquetes = colaPaquetes;
	}

	public double getWorkload() {
		return 1 - ((double)nodosDisponibles / (double)CANTIDAD_NODOS);
	}
	
	public void procesarSimulacion(Documento documento) {
		logger.info("Procesando el documento a la cola de simugan["+documento.getId()+"] del paquete ["+documento.getIdPaquete()+"]");
		if(this.ocuparNodo()) {
			MockSimulacion simulacion = null;
			if(this.utilizarSimugan) {
				//Si tengo documentos pendientes, los proceso
				if(this.documentosAProcesar.size()>0) {
					System.err.println("El documento a procesar sale de la cola de espera");
					simulacion = new MockSimulacion(documento,this,this.utilizarSimugan);
					documento.getTiempoEspera().setTiempoEspera(documento.getTiempoColaEspera());
					//this.documentosAProcesar.add(documento);
				}else {
					documento.getTiempoEspera().setTiempoEspera(documento.getTiempoColaEspera());
					simulacion = new MockSimulacion(documento,this,this.utilizarSimugan);
				}
			}else {
				documento.getTiempoEspera().setTiempoEspera(documento.getTiempoColaEspera());
				simulacion = new MockSimulacion(documento,this,this.utilizarSimugan);
			}
			pool.submit(simulacion);				
		}else {
			if(this.utilizarSimugan) {
				logger.info("Agregando el documento a la cola de simugan["+documento.getId()+"]");
				this.documentosAProcesar.add(documento);
			}
		}
		
	}
	
	public int getNodosDisponibles() {
		return nodosDisponibles;
	}
	public void setNodosDisponibles(int nodosDisponibles) {
		this.nodosDisponibles = nodosDisponibles;
	}
	
	public void addDocumentoProcesado(Documento doc) {
		this.documentosProcesados.add(doc);
	}

	public ArrayList<Documento> getDocumentosAProcesar() {
		return documentosAProcesar;
	}

	public void setDocumentosAProcesar(ArrayList<Documento> documentosAProcesar) {
		this.documentosAProcesar = documentosAProcesar;
	}

	public ArrayList<Documento> getDocumentosProcesados() {
		return documentosProcesados;
	}

	public void setDocumentosProcesados(ArrayList<Documento> documentosProcesados) {
		this.documentosProcesados = documentosProcesados;
	}
	
	

}
