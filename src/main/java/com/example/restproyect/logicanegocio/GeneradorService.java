package com.example.restproyect.logicanegocio;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.example.restproyect.Documento;
import com.example.restproyect.states.Ensilaje;
import com.example.restproyect.states.VariacionesReact;

//Capa Logica de negocio
@Service
public class GeneradorService {

	private HashMap<Integer,Documento> escenarios;
	
	
	
	public GeneradorService() {
		super();
		this.escenarios =  new HashMap<>();
	}



	public HashMap<Integer,Documento> generarSimulaciones(VariacionesReact variaciones){
		
		if(variaciones.getEnsilaje() != null) {
			escenarios = variaciones.getEnsilaje().generarEscenarios(variaciones);
			
		}
		
		if(variaciones.getPotreros() != null) {
			escenarios = variaciones.getPotreros().generarEscenarios(escenarios);			
		}
		
		if(variaciones.getInvernada() != null) {
			escenarios = variaciones.getInvernada().generarEscenarios(escenarios);					
		}
		
		if(variaciones.getRecursosforrajeros() != null) {
			escenarios = variaciones.getRecursosforrajeros().generarEscenarios(escenarios);			
		}
		if(variaciones.getDiferido() != null) {
			escenarios = variaciones.getDiferido().generarEscenarios(escenarios);
			variaciones.setDiferido(null);
		}
		
		if(variaciones.getFeedlot() != null) {
			escenarios = variaciones.getFeedlot().generarEscenarios(escenarios);			
		}
		
		System.gc();
		
		if(variaciones.getRastrojo() != null) {
			escenarios = variaciones.getRastrojo().generarEscenarios(escenarios);			
		}
		
		//FORRAJEROS TIENE PROBLEMAS
		return escenarios;
		
	}



	public void generarDocumento(@Valid VariacionesReact variacionesReact) {
		variacionesReact.generarDocumento();
		
	};
}
