package com.example.restproyect.prioridades;

import java.util.List;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;

public class ParametroMob extends AbsParametro {

	public ParametroMob(double[] prioridades, List<FiltroAbs> filtroEspera, int prioridad) {
		super(prioridad,prioridades);	
		this.filtros = filtroEspera;
		
	}

	@Override
	public double getPuntaje(Documento doc) {
		int cantidadMobs = doc.getCantidadMobs();
		for(int index = 0; index < filtros.size(); index++) {
			if(filtros.get(index).cumple((double)cantidadMobs)) {
				System.out.println("Valoracion por Mobs ["+this.valorDePrioridad*prioridades[index]+"]");
				return prioridades[index];
			}			
		}
		return 0;
	}

}
