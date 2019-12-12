package com.example.restproyect.prioridades;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;

public class ParametroMob extends AbsParametro {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ParametroMob(double[] prioridades, List<FiltroAbs> filtroEspera, int prioridad) {
		super(prioridad,prioridades);	
		this.filtros = filtroEspera;
		
	}

	@Override
	public double getPuntaje(Documento doc) {
		int cantidadMobs = doc.getCantidadMobs();
		for(int index = 0; index < filtros.size(); index++) {
			if(filtros.get(index).cumple((double)cantidadMobs)) {
				logger.debug("Documento numero:["+doc.getId()+"] Valoracion por cantidad mobs ["+this.valorDePrioridad*prioridades[index]+"] cantidad de mobs["+cantidadMobs+"]");
				return prioridades[index];
			}			
		}
		return 0;
	}

}
