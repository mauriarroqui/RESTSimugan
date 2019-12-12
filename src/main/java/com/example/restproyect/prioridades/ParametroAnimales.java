package com.example.restproyect.prioridades;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;

public class ParametroAnimales extends AbsParametro {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ParametroAnimales(double[] prioridades, List<FiltroAbs> filtroEspera, int prioridad) {
		super(prioridad, prioridades);
		this.filtros = filtroEspera;
	}

	@Override
	public double getPuntaje(Documento doc) {
		int cantidadAnimales = doc.getCantidadAnimales();
		for(int index = 0; index < filtros.size(); index++) {
			if(filtros.get(index).cumple((double)cantidadAnimales)) {
				logger.debug("Documento numero:["+doc.getId()+"] Valoracion por cantidad animales ["+this.valorDePrioridad*prioridades[index]+"] cantidad de animales["+cantidadAnimales+"]");
				return prioridades[index];
			}			
		}
		System.out.println("Return 0 de animales");
		return 0;
	}

}
