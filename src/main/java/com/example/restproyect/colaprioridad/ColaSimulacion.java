package com.example.restproyect.colaprioridad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.example.restproyect.calculadores.AbsCalculador;
import com.example.restproyect.calculadores.CalculadorSimulacion;
import com.example.restproyect.dto.Documento;

@Service
@Qualifier("colaSimulacion")
public class ColaSimulacion extends AbsColaPrioridad{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Autowired
//	@Qualifier("calculadorSimulacion")
//	private AbsCalculador calculadorSimulacion;
	
	private ArrayList<Documento> escenariosSimulacion;
	
	
	
	
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
			escenarios.get(i).setCalculador(new CalculadorSimulacion());
			this.escenariosSimulacion.add(escenarios.get(i));
		}
		
	}



	@Override
	public void ponderarEscenarios(ColaUsuarios usuarios) {
		
		// TODO Auto-generated method stub
		Date fechaHora = new Date();
		try {
			logger.info("Ponderando la lista de escenarios de Simulacion a las: "+fecha.format(fechaHora));
			Collections.sort(this.escenariosSimulacion, new Comparator<Documento>() {
				@Override
				public int compare(Documento o1, Documento o2) {
					// TODO Auto-generated method stub
					 o1.getUsuario().setCantidadEscenarios(Integer.valueOf(usuarios.getUsuario(o1.getUsuario().getIdUser()).getIdUser()));
					 o2.getUsuario().setCantidadEscenarios(Integer.valueOf(usuarios.getUsuario(o2.getUsuario().getIdUser()).getIdUser())); 
					 double result1 = o1.getCalculador().Calcular(o1);
					 double result2 = o2.getCalculador().Calcular(o2);
					 Date now = new Date();
					 o1.setFechaUltimoCalculo(now);
					 o2.setFechaUltimoCalculo(now);
					 if (result1 < result2) 
						 return -1;
				     if (result1 > result2) 
				    	 return 1;
				     
				     return 0;					
				}
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			logger.info("Fin de ponderacion de la lista de escenarios de Simulacion a las: "+fecha.format(fechaHora));			
		}
	}



	@Override
	public void mostrarResultados() {
		// TODO Auto-generated method stub
		
	}

}
