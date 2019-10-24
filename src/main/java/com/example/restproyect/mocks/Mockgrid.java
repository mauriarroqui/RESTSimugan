package com.example.restproyect.mocks;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Qualifier;
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
	
	public Mockgrid() {
		super();
		this.pool = Executors.newFixedThreadPool(CANTIDAD_NODOS);
		this.nodosDisponibles = CANTIDAD_NODOS;
		this.documentosProcesados = new ArrayList<Documento>();
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
		return 1 - (nodosDisponibles / CANTIDAD_NODOS);
	}
	
	public void procesarSimulacion(Documento documento, ColaPaquete paquetes) {
		if(this.ocuparNodo()) {
			documento.getTiempoEspera().setTiempoEspera(documento.getTiempoColaEspera());
			MockSimulacion simulacion = new MockSimulacion(documento,this);
			
			pool.submit(simulacion);
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
	
	

}
