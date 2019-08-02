package com.example.restproyect.calculadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.ponderacion.PonderacionAbs;
import com.example.restproyect.prioridades.AbsParametro;

@Controller
@Qualifier("calculadorExperimentacion")
public class CalculadorExperimentacion extends AbsCalculador {
	/*Inyectamos el tipo de ponderacion que se va a utilizar en la cola de experimentacion*/
	@Autowired
	@Qualifier("ponderarExperimentacion")
	private PonderacionAbs ponderacion;		
			
	
	public CalculadorExperimentacion() {
		super("CalculadorExperimentacion");
	}

	@Override
	public double Calcular(Documento doc) {
		return this.ponderacion.getValor(doc);
	}

}
