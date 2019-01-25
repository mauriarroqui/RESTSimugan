package com.example.restproyect.dto.component;

import java.util.Hashtable;

import org.springframework.stereotype.Controller;

import com.example.restproyect.dto.AbsColaPrioridad;
import com.example.restproyect.dto.Documento;

@Controller
public class ColaSimulacion extends AbsColaPrioridad{

	private Hashtable<Integer, Documento> escenariosSimulacion;
	
	
	public ColaSimulacion() {
		super();
		this.escenariosSimulacion = new Hashtable<>();
	}

	

	public Hashtable<Integer, Documento> getEscenariosSimulacion() {
		return escenariosSimulacion;
	}



	public void setEscenariosSimulacion(Hashtable<Integer, Documento> escenariosSimulacion) {
		this.escenariosSimulacion = escenariosSimulacion;
	}



	@Override
	public void agregarCola(Hashtable<Integer, Documento> escenarios) {
		for(int i = 0; i< escenarios.size(); i++) {
			this.escenariosSimulacion.put(this.escenariosSimulacion.size(),escenarios.get(i));
		}
		
	}

}
