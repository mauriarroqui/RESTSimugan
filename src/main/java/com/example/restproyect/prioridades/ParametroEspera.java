package com.example.restproyect.prioridades;

import java.util.List;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAND;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroMayor;
import com.example.restproyect.filtros.FiltroMenor;

import net.bytebuddy.dynamic.scaffold.MethodGraph.NodeList;

public class ParametroEspera extends AbsParametro{

	
	public ParametroEspera(double[] prioridades) {
		super(1,prioridades);		
		
	}
	
	// en caso de que los valores estan delimitado por rangos, es necesario usar esta funcion
	// para poder obtener el valor del arreglo
	private int getIndex(int valor) {
		return 0;
	}

	@Override
	public double getPuntaje(Documento doc) {		
		//cambiar el 0 por el valor del parametro obtenido del xml
		return prioridades[this.getIndex(0)];
	}

}
