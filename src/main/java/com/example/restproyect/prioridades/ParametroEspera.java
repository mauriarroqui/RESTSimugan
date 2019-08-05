package com.example.restproyect.prioridades;


import java.util.List;
import java.util.concurrent.TimeUnit;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;

/*
 * Tiempo de espera que tienen los documentos en cola, mientras mas
 * tiempo de espera, mas prioridad de que salga hay que darle 
 */
public class ParametroEspera extends AbsParametro{

	
	public ParametroEspera(double[] prioridades, List<FiltroAbs> filtroEspera, int prioridad) {
		super(4,prioridades);	
		this.filtros = filtroEspera;
		
	}


	@Override
	public double getPuntaje(Documento doc) {

		long diffInMillies = doc.getFechaUltimoCalculo().getTime() - doc.getFechaInicio().getTime();
		//Cambiar minutos por horas
		double diferencia = (double)TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
		
		for(int index = 0; index < filtros.size(); index++) {
			if(filtros.get(index).cumple(diferencia)) {
//				System.out.println("Valoracion por Espera ["+this.valorDePrioridad*prioridades[index]+"]");
				return prioridades[index];
			}			
		}
		return 0;
	}

}
