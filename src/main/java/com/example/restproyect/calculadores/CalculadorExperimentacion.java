package com.example.restproyect.calculadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.ponderacion.PonderacionAbs;
import com.example.restproyect.ponderacion.PonderacionExperimentacion;
public class CalculadorExperimentacion extends AbsCalculador {
	/*Inyectamos el tipo de ponderacion que se va a utilizar en la cola de experimentacion*/

	private PonderacionAbs ponderacion;		
			
	
	public CalculadorExperimentacion() {
		super("CalculadorExperimentacion");
		this.ponderacion = new PonderacionExperimentacion();
	}

	@Override
	public double Calcular(Documento doc) {
		return this.ponderacion.getValor(doc);
	}

}
