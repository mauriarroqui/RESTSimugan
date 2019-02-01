package com.example.restproyect.dto;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restproyect.calculadores.AbsCalculador;

@Controller
@Qualifier("colaExperimentacion")
public class ColaExperimentacion implements AbsColaPrioridad{

	@Autowired
	@Qualifier("calculadorExperimentacion")
	private AbsCalculador calculadorExperimentacion;
	
	private Hashtable<Integer, Documento> escenariosExpetimentacion;
	
	
	
	public ColaExperimentacion() {
		super();
		this.escenariosExpetimentacion = new Hashtable<>();
	}


	

	public Hashtable<Integer, Documento> getEscenarios() {
		return escenariosExpetimentacion;
	}




	public void setEscenariosExpetimentacion(Hashtable<Integer, Documento> escenariosExpetimentacion) {
		this.escenariosExpetimentacion = escenariosExpetimentacion;
	}




	@Override
	public void agregarCola(Hashtable<Integer, Documento> escenarios) {
		for(int i = 0; i< escenarios.size(); i++) {
			escenarios.get(i).setCalculador(calculadorExperimentacion);
			this.escenariosExpetimentacion.put(this.escenariosExpetimentacion.size(),escenarios.get(i));
		}
		
	}

}
