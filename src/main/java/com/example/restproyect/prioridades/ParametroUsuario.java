package com.example.restproyect.prioridades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.restproyect.colaprioridad.ColaUsuarios;
import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;

/*
 * Ponderacion por cantidad de escenarios restantes para enviar
 * por parte de cada usuario 
 */
public class ParametroUsuario extends AbsParametro{

	@Autowired
	private ColaUsuarios usuarios;
	
	public ParametroUsuario(double[] prioridades, List<FiltroAbs> filtroYears, int prioridad) {
		super(prioridad,prioridades);
		this.filtros = filtroYears;
	}
	
	@Override
	public double getPuntaje(Documento doc) {
		int cantidadEscenarios = doc.getUsuario().getCantidadEscenarios();		
		for(int index = 0; index < filtros.size(); index++) {
			if(filtros.get(index).cumple((double)cantidadEscenarios)) {
				System.out.println("Valoracion por Cantidad de Escenarios ["+this.valorDePrioridad*prioridades[index]+"]");
				return prioridades[index];
			}			
		}		
		//Si no cumple con ninguno, retorno 0 como valor de prioridad
		return 0;
	}

	
}
