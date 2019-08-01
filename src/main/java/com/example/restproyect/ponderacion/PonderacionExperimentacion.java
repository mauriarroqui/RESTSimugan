package com.example.restproyect.ponderacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAND;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroMayor;
import com.example.restproyect.filtros.FiltroMenor;
import com.example.restproyect.prioridades.ParametroEspera;
import com.example.restproyect.prioridades.ParametroYears;

@Controller
@Qualifier("ponderarExperimentacion")
public class PonderacionExperimentacion extends PonderacionAbs{

	public PonderacionExperimentacion() {
		super();	
		/*
		 * agrego las ponderaciones para cada uno de los parametros
		 */
		FiltroAbs rango1 = new FiltroAND(new FiltroMayor(0),new FiltroMenor(10));
		FiltroAbs rango2 = new FiltroAND(new FiltroMayor(11),new FiltroMenor(21));
		FiltroAbs rango3 = new FiltroAND(new FiltroMayor(21),new FiltroMenor(1000));
		List<FiltroAbs> filtroYears = new ArrayList<FiltroAbs>();
		filtroYears.add(rango1);
		filtroYears.add(rango2);
		filtroYears.add(rango3);
		this.parametros.add(new ParametroYears(new double[] {0.4,0.3,0.2,0.1},filtroYears));
		System.out.print("asdqwe");
		//this.parametros.add(new ParametroEspera(new double[] {0.4,0.3,0.2,0.1}));
	}
	
	@Override
	public double getValor(Documento doc) {
		double resultado = 0;
		
		for(int i = 0; i< parametros.size();i++) {
			//R = P1*V1 + P2*V2 + … + Pn*Vn
			resultado += parametros.get(i).getValorDePrioridad()*parametros.get(i).getPuntaje(doc);
		}
		return resultado;
	}


	
}
