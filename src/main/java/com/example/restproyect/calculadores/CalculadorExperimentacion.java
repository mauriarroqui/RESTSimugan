package com.example.restproyect.calculadores;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.prioridades.AbsParametro;

@Controller
@Qualifier("calculadorExperimentacion")
public class CalculadorExperimentacion extends AbsCalculador {
	private String name;
	

	
	private ArrayList<AbsParametro> parametros = new ArrayList<AbsParametro>(); 
	
	
	
	public CalculadorExperimentacion() {
		super();
	}



	@Override
	public double Calcular(Documento doc) {
		int resultado = 0;
		
		for(int i = 0; i< parametros.size();i++) {
			//R = P1*V1 + P2*V2 + … + Pn*Vn
			resultado += parametros.get(i).getValorDePrioridad()*parametros.get(i).getPuntaje(doc);
		}
		return resultado;
	}

}
