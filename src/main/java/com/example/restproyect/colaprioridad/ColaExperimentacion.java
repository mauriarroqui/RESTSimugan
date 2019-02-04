package com.example.restproyect.colaprioridad;

import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restproyect.calculadores.AbsCalculador;
import com.example.restproyect.dto.Documento;

@Controller
@Qualifier("colaExperimentacion")
public class ColaExperimentacion implements AbsColaPrioridad{

	@Autowired
	@Qualifier("calculadorExperimentacion")
	private AbsCalculador calculadorExperimentacion;
	
	private ArrayList<Documento> escenariosExpetimentacion;
	
	
	
	public ColaExperimentacion() {
		super();
		this.escenariosExpetimentacion = new ArrayList<>();
	}


	

	public ArrayList<Documento> getEscenarios() {
		return escenariosExpetimentacion;
	}




	public void setEscenariosExpetimentacion(ArrayList<Documento> escenariosExpetimentacion) {
		this.escenariosExpetimentacion = escenariosExpetimentacion;
	}




	@Override
	public void agregarCola(Hashtable<Integer, Documento> escenarios) {
		for(int i = 0; i< escenarios.size(); i++) {
			escenarios.get(i).setCalculador(calculadorExperimentacion);
			this.escenariosExpetimentacion.add(escenarios.get(i));
		}
		
	}

}
