package com.example.restproyect.logicanegocio;

import java.util.HashMap;
import java.util.Hashtable;

import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.example.restproyect.Documento;
import com.example.restproyect.ThreadPool;
import com.example.restproyect.states.Ensilaje;
import com.example.restproyect.states.VariacionesReact;

//Capa Logica de negocio
@Service
public class GeneradorService {

	private Hashtable<Integer,Documento> escenarios;
	

	private ThreadPool threadPool;
	
	
	public GeneradorService() {
		super();
		this.escenarios =  new Hashtable<>();
	}



	public Hashtable<Integer,Documento> generarSimulaciones(VariacionesReact variaciones){
		
		if(variaciones.getEnsilaje() != null) {
			
			escenarios = variaciones.getEnsilaje().generarEscenarios(variaciones);
			
		}
		
		if(variaciones.getPotreros() != null) {
			escenarios = variaciones.getPotreros().generarEscenarios(escenarios);			
		}
//		
//		
		if(variaciones.getInvernada() != null) {
			escenarios = variaciones.getInvernada().generarEscenarios(escenarios);					
		}
//		
		if(variaciones.getRecursosforrajeros() != null) {
			
			escenarios = variaciones.getRecursosforrajeros().generarEscenarios(escenarios);			
		}
		
		//threadPool.limpiarPool();
		if(variaciones.getDiferido() != null) {
			escenarios = variaciones.getDiferido().generarEscenarios(escenarios,threadPool);
		}
		
		
		long t1 = System.currentTimeMillis();
		//Con 10 termina
		threadPool = new ThreadPool(15);		
		if(variaciones.getFeedlot() != null) {
			escenarios = variaciones.getFeedlot().generarEscenarios(escenarios,threadPool);			
		}
		long t2 = System.currentTimeMillis();

		t1 = System.currentTimeMillis();
		threadPool = new ThreadPool(30);
		if(variaciones.getRastrojo() != null) {
			escenarios = variaciones.getRastrojo().generarEscenarios(escenarios,threadPool);			
			
		}
		t2 = System.currentTimeMillis();
		System.out.println("Tiempo que tardo Rastrojo="+(t2-t1));
		System.out.println("Tiempo que tardo FeedLot="+(t2-t1));

		//FORRAJEROS TIENE PROBLEMAS
		return escenarios;
		
	}



	public void generarDocumento(@Valid VariacionesReact variacionesReact) {
		variacionesReact.generarDocumento();
		
	};
}
