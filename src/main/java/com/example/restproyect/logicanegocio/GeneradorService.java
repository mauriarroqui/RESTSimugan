package com.example.restproyect.logicanegocio;

import java.util.HashMap;
import java.util.Hashtable;

import javax.persistence.Transient;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.example.restproyect.colaprioridad.AbsColaPrioridad;
import com.example.restproyect.dto.Documento;
import com.example.restproyect.hilos.ThreadPool;
import com.example.restproyect.states.VariacionesReact;

//Capa Logica de negocio
@Service
public class GeneradorService implements IGeneradorService{

	private Hashtable<Integer,Documento> escenarios;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Value("${threadpool}")
	private int cantidadHilos;
	
	private ThreadPool threadPool;
	
	
	public GeneradorService() {
		super();
		this.escenarios =  new Hashtable<>();
	}


	
	public Hashtable<Integer,Documento> generarSimulaciones(VariacionesReact variaciones, int idPaquete){
		this.escenarios =  new Hashtable<>();
		long t1 = 0;
		long t2 = 0;
		int tiempoInicio = 0;
		int tiempoFin = 0;
		float result = 0;
		tiempoInicio = (int) System.currentTimeMillis();
		Documento documento = new Documento(variaciones.getDocumento(),variaciones.getUsuario());
		documento.setIdPaquete(idPaquete);
		escenarios.put(0, documento);
		try {
			if(variaciones.getEnsilaje() != null) {
				
				escenarios = variaciones.getEnsilaje().generarEscenarios(variaciones);
				logger.debug("Terminando generacion de ensilaje");
				logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
				
			}
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE ENSILAJE"+e.getMessage().toString());
		}
		
		//------------------------------------------------------------------------------------
		
		try {
			if(variaciones.getPotreros() != null) {
				escenarios = variaciones.getPotreros().generarEscenarios(escenarios);			
				logger.debug("Terminando generacion de potreros");
				logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
			}
			
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE POTREROS");
		}
		
//		------------------------------------------------------------------------------------
		
		try {
			if(variaciones.getInvernada() != null) {
				escenarios = variaciones.getInvernada().generarEscenarios(escenarios);					
				logger.debug("Terminando generacion de invernada");
				logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
			}
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE INVERNADA");
		}
		
//		------------------------------------------------------------------------------------
		
		try {
			if(variaciones.getRecursosforrajeros() != null) {
				t1 = System.currentTimeMillis();
				threadPool = new ThreadPool(this.cantidadHilos);
				
				escenarios = variaciones.getRecursosforrajeros().generarEscenarios(escenarios, threadPool);			
				t2 = System.currentTimeMillis();
				result = ((t2-t1)/1000);
				logger.debug("Terminando generacion de Forrajeros en["+result+"] segundos");
				logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
			}
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE FORRAJEROS");
		}
	
//		------------------------------------------------------------------------------------
		
		try {
			if(variaciones.getDiferido() != null) {
				t1 = System.currentTimeMillis();
				threadPool = new ThreadPool(this.cantidadHilos);
				escenarios = variaciones.getDiferido().generarEscenarios(escenarios,threadPool);
				t2 = System.currentTimeMillis();
				result = ((t2-t1)/1000);
				logger.debug("Terminando generacion de Diferido en["+result+"] segundos");
				logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
				
			}
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE DIFERIDOS");
		}

//		------------------------------------------------------------------------------------
		
		
		try {
			if(variaciones.getFeedlot() != null) {
				t1 = System.currentTimeMillis();
				threadPool = new ThreadPool(this.cantidadHilos);	
				escenarios = variaciones.getFeedlot().generarEscenarios(escenarios,threadPool);			
				t2 = System.currentTimeMillis();
				result = ((t2-t1)/1000);
				logger.debug("Terminando generacion de feedlot ["+result+"] segundos");
				logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
			}
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE FEEDLOT");
		}
		
//		------------------------------------------------------------------------------------
		
		try {
			if(variaciones.getRastrojo() != null) {
				t1 = System.currentTimeMillis();
				threadPool = new ThreadPool(this.cantidadHilos);
				escenarios = variaciones.getRastrojo().generarEscenarios(escenarios,threadPool);			
				t2 = System.currentTimeMillis();
				result = ((t2-t1)/1000);
				logger.debug("Terminando generacion de rastrojo ["+result+"] segundos");
				logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
			}
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE RASTROJO");
		}
		//------------------------------------------------------------------------------------------
		try {
			
			if(variaciones.getEngorde() != null) {
				t1 = System.currentTimeMillis();
				threadPool = new ThreadPool(this.cantidadHilos);
				escenarios = variaciones.getEngorde().generarEscenarios(escenarios,threadPool);			
				
				t2 = System.currentTimeMillis();
				result = ((t2-t1)/1000);
				logger.debug("Terminando generacion de engorde ["+result+"] segundos");
				logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
			}
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE ENGORDE");
		}
		//-------------------------------------------------------------------------------------------
		try {
			if(variaciones.getDestete() != null) {
				t1 = System.currentTimeMillis();
				threadPool = new ThreadPool(this.cantidadHilos);
				escenarios = variaciones.getDestete().generarEscenarios(escenarios,threadPool);			
				
				t2 = System.currentTimeMillis();
				result = ((t2-t1)/1000);
				logger.debug("Terminando generacion de destete ["+result+"] segundos");
				logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
			}
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE DESTETE");
		}
		
		//-------------------------------------------------------------------------------------------
		try {
			if(variaciones.getMobs() != null) {
				t1 = System.currentTimeMillis();
				threadPool = new ThreadPool(this.cantidadHilos);
				escenarios = variaciones.getMobs().generarEscenarios(escenarios,threadPool);			
				
				t2 = System.currentTimeMillis();
				result = ((t2-t1)/1000);
				logger.debug("Terminando generacion de mobs ["+result+"] segundos");
				logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
			}
			
		} catch (Exception e) {
			logger.error("FALLA EN LA GENERACION DE MOBS");
		}
		logger.debug("Terminando la generacion de ["+escenarios.size()+"] escenarios");
		tiempoFin = (int) System.currentTimeMillis();
		for(Documento doc : this.escenarios.values()) {
			doc.getTiempoEspera().setTiempoGeneracion(tiempoFin - tiempoInicio);
		}
		
		return escenarios;
		
	}



	public void generarDocumento(@Valid VariacionesReact variacionesReact) {
		variacionesReact.generarDocumento();
		
	}


}
