package com.example.restproyect.ponderacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restproyect.colaprioridad.ColaUsuarios;
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
		 * Verificar los parametros en base a las estadisticas de la base 
		 * y estudiar cuales son los valores promedios de años para que
		 * las prioridades sean eficientes
		 */
		FiltroAbs rango1 = new FiltroAND(new FiltroMayor(0),new FiltroMenor(10));
		FiltroAbs rango2 = new FiltroAND(new FiltroMayor(11),new FiltroMenor(21));
		FiltroAbs rango3 = new FiltroAND(new FiltroMayor(21),new FiltroMenor(40));
		FiltroAbs rango4 = new FiltroMayor(21);
		List<FiltroAbs> filtroYears = new ArrayList<FiltroAbs>();
		filtroYears.add(rango1);
		filtroYears.add(rango2);
		filtroYears.add(rango3);
		filtroYears.add(rango4);
		this.parametros.add(new ParametroYears(new double[] {10.4,5.3,2.2,0.1},filtroYears));
		
		/*
		 * Los valores dentro del tiempo de espera son en horas
		 */
		FiltroAbs rangoEspera1 = new FiltroMayor(24);
		FiltroAbs rangoEspera2 = new FiltroAND(new FiltroMayor(13),new FiltroMenor(23));
		FiltroAbs rangoEspera3 = new FiltroAND(new FiltroMayor(7),new FiltroMenor(12));
		FiltroAbs rangoEspera4 = new FiltroAND(new FiltroMayor(0),new FiltroMenor(6));
		List<FiltroAbs> filtroEspera = new ArrayList<FiltroAbs>();
		filtroEspera.add(rangoEspera1);
		filtroEspera.add(rangoEspera2);
		filtroEspera.add(rangoEspera3);
		filtroEspera.add(rangoEspera4);
		
		this.parametros.add(new ParametroEspera(new double[] {10.4,5.3,2.2,0.1},filtroEspera));
		
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
