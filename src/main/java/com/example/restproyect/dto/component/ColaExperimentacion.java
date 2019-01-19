package com.example.restproyect.dto.component;

import java.util.Hashtable;

import org.springframework.stereotype.Controller;

import com.example.restproyect.dto.AbsColaPrioridad;
import com.example.restproyect.dto.Documento;

@Controller
public class ColaExperimentacion extends AbsColaPrioridad{

	private Hashtable<Integer, Documento> escenariosExpetimentacion;
	
	
	
	public ColaExperimentacion() {
		super();
		this.escenariosExpetimentacion = new Hashtable<>();
	}


	

	public Hashtable<Integer, Documento> getEscenariosExpetimentacion() {
		return escenariosExpetimentacion;
	}




	public void setEscenariosExpetimentacion(Hashtable<Integer, Documento> escenariosExpetimentacion) {
		this.escenariosExpetimentacion = escenariosExpetimentacion;
	}




	@Override
	public void agregarCola(Hashtable<Integer, Documento> escenarios) {
		for(int i = 0; i< escenarios.size(); i++) {
			this.escenariosExpetimentacion.put(this.escenariosExpetimentacion.size(),escenarios.get(i));
		}
		
	}

}
