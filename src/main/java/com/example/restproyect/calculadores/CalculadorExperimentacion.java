package com.example.restproyect.calculadores;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restproyect.dto.Documento;

@Controller
@Qualifier("calculadorExperimentacion")
public class CalculadorExperimentacion extends AbsCalculador {
	private String name;
	
	
	
	public CalculadorExperimentacion() {
		super();
	}



	@Override
	public double Calcular(Documento doc) {
		// TODO Auto-generated method stub
		return 0;
	}

}
