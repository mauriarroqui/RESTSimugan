package com.example.restproyect.service;

import java.util.HashMap;


import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.example.restproyect.Documento;
import com.example.restproyect.states.Ensilaje;
import com.example.restproyect.states.VariacionesReact;

@Service
public class GeneradorService {

	private HashMap<Integer,Documento> escenarios;
	
	
	
	public GeneradorService() {
		super();
		this.escenarios =  new HashMap<>();
	}



	public HashMap<Integer,Documento> generarSimulaciones(VariacionesReact variaciones){

		escenarios = variaciones.getEnsilaje().generarEscenarios(variaciones);
		//FORRAJEROS TIENE PROBLEMAS
		//escenarios = variaciones.getRecursosforrajeros().generarEscenarios(escenarios);
		escenarios = variaciones.getPotreros().generarEscenarios(escenarios);
		escenarios = variaciones.getInvernada().generarEscenarios(escenarios);
		return escenarios;
		
	};
}
