package com.example.restproyect.dto;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restproyect.calculadores.AbsCalculador;

@Controller
@Qualifier("colaSimulacion")
public class ColaSimulacion implements AbsColaPrioridad{

	@Autowired
	@Qualifier("calculadorSimulacion")
	private AbsCalculador calculadorSimulacion;
	
	private Hashtable<Integer, Documento> escenariosSimulacion;
	
	
	public ColaSimulacion() {
		super();
		this.escenariosSimulacion = new Hashtable<>();
	}

	

	public Hashtable<Integer, Documento> getEscenarios() {
		return escenariosSimulacion;
	}



	public void setEscenariosSimulacion(Hashtable<Integer, Documento> escenariosSimulacion) {
		this.escenariosSimulacion = escenariosSimulacion;
	}



	@Override
	public void agregarCola(Hashtable<Integer, Documento> escenarios) {
		for(int i = 0; i< escenarios.size(); i++) {
			
			//Le damos como se tiene que calcular
			escenarios.get(i).setCalculador(calculadorSimulacion);
			
			this.escenariosSimulacion.put(this.escenariosSimulacion.size(),escenarios.get(i));
		}
		
	}

}
