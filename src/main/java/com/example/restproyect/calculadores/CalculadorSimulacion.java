package com.example.restproyect.calculadores;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restproyect.dto.Documento;

@Controller
@Qualifier("calculadorSimulacion")
public class CalculadorSimulacion extends AbsCalculador{

	
	
	public CalculadorSimulacion() {
		super();
		
	}



	@Override
	public double Calcular(Documento doc) {
	
		return Math.random();
	}

}
