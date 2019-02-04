package com.example.restproyect.colaprioridad;

import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restproyect.calculadores.AbsCalculador;
import com.example.restproyect.dto.Documento;

@Controller
@Qualifier("colaSimulacion")
public class ColaSimulacion implements AbsColaPrioridad{

	@Autowired
	@Qualifier("calculadorSimulacion")
	private AbsCalculador calculadorSimulacion;
	
	private ArrayList<Documento> escenariosSimulacion;//Hashtable<Integer, Documento> escenariosSimulacion;
	
	
	public ColaSimulacion() {
		super();
		this.escenariosSimulacion = new ArrayList<>();
	}

	

	public ArrayList<Documento> getEscenarios() {
		return escenariosSimulacion;
	}



	public void setEscenariosSimulacion(ArrayList<Documento> escenariosSimulacion) {
		this.escenariosSimulacion = escenariosSimulacion;
	}



	@Override
	public void agregarCola(Hashtable<Integer, Documento> escenarios) {
		for(int i = 0; i< escenarios.size(); i++) {
			
			//Le damos como se tiene que calcular
			escenarios.get(i).setCalculador(calculadorSimulacion);
			this.escenariosSimulacion.add(escenarios.get(i));
		}
		
	}

}
