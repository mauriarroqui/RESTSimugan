package com.example.restproyect.calculadores;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.ponderacion.PonderacionAbs;
import com.example.restproyect.ponderacion.PonderacionExperimentacion;

@Controller
@Qualifier("calculadorSimulacion")
public class CalculadorSimulacion extends AbsCalculador{

	private PonderacionAbs ponderacion;
	
	public CalculadorSimulacion() {
		super("CalculadorSimulacion");
		this.ponderacion = new PonderacionExperimentacion();
	}



	@Override
	public double Calcular(Documento doc) {
	
		return this.ponderacion.getValor(doc);
	}

}
