package com.example.restproyect.prioridades;

import java.time.chrono.ChronoLocalDate;
import static java.time.temporal.ChronoUnit.*;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;

/*
 * Mientras mas AÑOS de simulación tiene, menos prioridad
 * tiene que tener, porque mas tiempo tarda en calcular 
 */
public class ParametroYears extends AbsParametro {

	private FiltroAbs filtroNombre;
	
	public ParametroYears(double[] prioridades, List<FiltroAbs> filtroYears, int prioridad) {
		super(prioridad,prioridades);
		this.filtros = filtroYears;
		this.filtroNombre = new FiltroNombre("simulation");
	}
	
	@Override
	public double getPuntaje(Documento doc) {
		
		ChronoLocalDate from = ChronoLocalDate.from(doc.getFechaInicioSimulacion());
        ChronoLocalDate to   = ChronoLocalDate.from(doc.getFechaFinSimulacion());
        ChronoPeriod period  = ChronoPeriod.between(from, to);
        double diferencia = period.get(YEARS);
		for(int index = 0; index < filtros.size(); index++) {
			if(filtros.get(index).cumple(diferencia)) {
				return prioridades[index];
			}			
		}		
		//Si no cumple con ninguno, retorno 0 como valor de prioridad
		return 0;
	}

}
