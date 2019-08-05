package com.example.restproyect.prioridades;

import java.util.List;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;

public class ParametroAnimales extends AbsParametro {

	
	public ParametroAnimales(double[] prioridades, List<FiltroAbs> filtroEspera, int prioridad) {
		super(prioridad, prioridades);
		this.filtros = filtroEspera;
	}

	@Override
	public double getPuntaje(Documento doc) {
		int cantidadAnimales = doc.getCantidadAnimales();
		for(int index = 0; index < filtros.size(); index++) {
			if(filtros.get(index).cumple((double)cantidadAnimales)) {
				System.err.println(filtros.get(index).toString());
				System.out.println("Valoracion por Animales ["+this.valorDePrioridad*prioridades[index]+"]+ cantidad animales["+cantidadAnimales+"]");
				return prioridades[index];
			}			
		}
		return 0;
	}

}
