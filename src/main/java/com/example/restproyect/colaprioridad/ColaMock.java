package com.example.restproyect.colaprioridad;

import java.util.ArrayList;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.restproyect.calculadores.AbsCalculador;
import com.example.restproyect.calculadores.CalculadorExperimentacion;
import com.example.restproyect.dto.Documento;

@Component
@Qualifier("colaMock")
public class ColaMock extends AbsColaPrioridad{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ArrayList<Documento> escenarios;

	public ColaMock() {
		super();
		this.escenarios = new ArrayList<Documento>();
	}
	
	@Override
	public synchronized void agregarCola(Hashtable<Integer, Documento> escenarios, int idPaquete) {
		AbsCalculador calculador = new CalculadorExperimentacion();
		for(int i = 0; i< escenarios.size(); i++) {
			escenarios.get(i).setCalculador(calculador);
			escenarios.get(i).setId(this.escenarios.size());
			this.escenarios.add(escenarios.get(i));
		}
		
	}
	
	@Override
	public synchronized void mostrarResultados() {
		// TODO Auto-generated method stub
		logger.debug("-----------------------------------------------------------------------------------------------");
		for(Documento doc: this.escenarios) {
			logger.debug("Escenario Nro ["+doc.getId()+"] Usuario: ["+doc.getUsuario().getIdUser()+"] Ponderacion ["+doc.getValorUltimaPronderacion()+"]");
		}
		logger.debug("-----------------------------------------------------------------------------------------------");
	}

	@Override
	public ArrayList<Documento> getEscenarios() {
		// TODO Auto-generated method stub
		return this.escenarios;
	}

	@Deprecated
	public void ponderarEscenarios(ColaUsuarios usuarios) {
		// TODO Auto-generated method stub
		
	}
	
	
}
