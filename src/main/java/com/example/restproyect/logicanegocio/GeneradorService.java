package com.example.restproyect.logicanegocio;

import java.util.HashMap;
import java.util.Hashtable;

import javax.persistence.Transient;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.example.restproyect.Documento;
import com.example.restproyect.hilos.ThreadPool;
import com.example.restproyect.states.VariacionesReact;

//Capa Logica de negocio
@Service
public class GeneradorService {

	private Hashtable<Integer,Documento> escenarios;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private ThreadPool threadPool;
	
	
	public GeneradorService() {
		super();
		this.escenarios =  new Hashtable<>();
	}



	public Hashtable<Integer,Documento> generarSimulaciones(VariacionesReact variaciones){
		long t1 = 0;
		long t2 = 0;
		
		try {
			if(variaciones.getEnsilaje() != null) {
				
				escenarios = variaciones.getEnsilaje().generarEscenarios(variaciones);
				
			}
			logger.info("Terminando generacion de ensilaje");
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE ENSILAJE");
		}
		
		//------------------------------------------------------------------------------------
		
		try {
			if(variaciones.getPotreros() != null) {
				escenarios = variaciones.getPotreros().generarEscenarios(escenarios);			
			}
			
			logger.info("Terminando generacion de potreros");
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE POTREROS");
		}
		
//		------------------------------------------------------------------------------------
		
		try {
			if(variaciones.getInvernada() != null) {
				escenarios = variaciones.getInvernada().generarEscenarios(escenarios);					
			}
			logger.info("Terminando generacion de invernada");
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE INVERNADA");
		}
		
//		------------------------------------------------------------------------------------
		
		try {
			if(variaciones.getRecursosforrajeros() != null) {
				
				escenarios = variaciones.getRecursosforrajeros().generarEscenarios(escenarios);			
			}
			logger.info("Terminando generacion de forrajeros");
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE FORRAJEROS");
		}
	
//		------------------------------------------------------------------------------------
		
		try {
			if(variaciones.getDiferido() != null) {
				escenarios = variaciones.getDiferido().generarEscenarios(escenarios,threadPool);
			}
			
			logger.info("Terminando generacion de diferidos");
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE DIFERIDOS");
		}

//		------------------------------------------------------------------------------------
		
		
		try {
			t1 = System.currentTimeMillis();
			threadPool = new ThreadPool(15);		
			if(variaciones.getFeedlot() != null) {
				escenarios = variaciones.getFeedlot().generarEscenarios(escenarios,threadPool);			
			}
			t2 = System.currentTimeMillis();
			logger.info("Terminando generacion de feedlot ["+(t2-t1)+"]");
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE FEEDLOT");
		}
		
//		------------------------------------------------------------------------------------
		
		try {
			t1 = System.currentTimeMillis();
			threadPool = new ThreadPool(30);
			if(variaciones.getRastrojo() != null) {
				escenarios = variaciones.getRastrojo().generarEscenarios(escenarios,threadPool);			
				
			}
			logger.info("Terminando generacion de rastrojo ["+(t2-t1)+"]");
			t2 = System.currentTimeMillis();
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE RASTROJO");
		}
		


		return escenarios;
		
	}



	public void generarDocumento(@Valid VariacionesReact variacionesReact) {
		variacionesReact.generarDocumento();
		
	};
}
