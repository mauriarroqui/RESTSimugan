package com.example.restproyect.colaprioridad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.example.restproyect.calculadores.AbsCalculador;
import com.example.restproyect.calculadores.CalculadorExperimentacion;
import com.example.restproyect.dto.Documento;
import com.example.restproyect.dto.Paquete;

@Service
@Qualifier("colaExperimentacion")
public class ColaExperimentacion extends AbsColaPrioridad{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
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
	public synchronized void agregarCola(Hashtable<Integer, Documento> escenarios, int idPaquete) {
		AbsCalculador calculador = new CalculadorExperimentacion();

		for(int i = 0; i< escenarios.size(); i++) {
			escenarios.get(i).setCalculador(calculador);
			escenarios.get(i).setId(this.escenariosExpetimentacion.size());
			escenarios.get(i).setIdPaquete(idPaquete);
			this.escenariosExpetimentacion.add(escenarios.get(i));
		}		
	}
	
	@Override
	public synchronized void ponderarEscenarios(ColaUsuarios usuarios) {
		Date fechaHora = new Date();
		try {
			logger.info("Ponderando la lista de escenarios de Experimentaciones a las: "+fecha.format(fechaHora));
			
			Collections.sort(this.escenariosExpetimentacion, new Comparator<Documento>() {
				@Override
				public int compare(Documento o1, Documento o2) {
					// TODO Auto-generated method stub
//					 o1.getUsuario().setCantidadEscenarios(Integer.valueOf(usuarios.getUsuario(o1.getUsuario().getIdUser()).getIdUser()));
//					 o2.getUsuario().setCantidadEscenarios(Integer.valueOf(usuarios.getUsuario(o2.getUsuario().getIdUser()).getIdUser())); 
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
	public synchronized void mostrarResultados() {
		// TODO Auto-generated method stub
		logger.debug("-----------------------------------------------------------------------------------------------");
		for(Documento doc: this.escenariosExpetimentacion) {
			logger.debug("Escenario Nro ["+doc.getId()+"] Usuario: ["+doc.getUsuario().getIdUser()+"] Ponderacion ["+doc.getValorUltimaPronderacion()+"]");
		}
		logger.debug("-----------------------------------------------------------------------------------------------");
	}

}
