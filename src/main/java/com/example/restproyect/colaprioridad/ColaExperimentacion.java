package com.example.restproyect.colaprioridad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.example.restproyect.calculadores.AbsCalculador;
import com.example.restproyect.dto.Documento;

@Service
@Qualifier("colaExperimentacion")
public class ColaExperimentacion extends AbsColaPrioridad{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
	
	@Override
	public void ponderarEscenarios() {
		Date fechaHora = new Date();
		try {
			logger.info("Ponderando la lista de escenarios de Experimentaciones a las: "+fecha.format(fechaHora));
			
			Collections.sort(this.escenariosExpetimentacion, new Comparator<Documento>() {
				@Override
				public int compare(Documento o1, Documento o2) {
					// TODO Auto-generated method stub
					 double result1 = o1.getCalculador().Calcular(o1);
					 double result2 = o2.getCalculador().Calcular(o2);
					 o1.setValorUltimaPronderacion(result1);
					 o2.setValorUltimaPronderacion(result2);
					 Date now = new Date();
					 o1.setFechaUltimoCalculo(now);
					 o2.setFechaUltimoCalculo(now);
					 
					 if (result1 > result2) 
						 return -1;
				     if (result1 < result2) 
				    	 return 1;
				     
				     return 0;				
				}
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			logger.info("Fin de ponderacion de la lista de escenarios de Experimentaciones a las: "+fecha.format(fechaHora));			
		}
		
	}
	
	@Override
	public void mostrarResultados() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------------------------------------------------------");
		for(Documento doc: this.escenariosExpetimentacion) {
			System.out.println("Usuario: ["+doc.getUsuario().getIdUser()+"] Ponderacion ["+doc.getValorUltimaPronderacion()+"] Diferencia de fecha ["+doc.getDiferenciaHoras()+"]");
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
	}

}
