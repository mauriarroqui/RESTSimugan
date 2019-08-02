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

	private List<FiltroAbs> filtros;
	
	public ParametroEspera(double[] prioridades, List<FiltroAbs> filtroEspera) {
		super(1,prioridades);	
		this.filtros = filtroEspera;
		
	}


	@Override
	public double getPuntaje(Documento doc) {

		long diffInMillies = doc.getFechaUltimoCalculo().getTime() - doc.getFechaInicio().getTime();
		double diferencia = (double)TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
		
		for(int index = 0; index < filtros.size(); index++) {
			if(filtros.get(index).cumple(diferencia)) {
				return prioridades[index];
			}			
		}
		return 0;
	}

}
