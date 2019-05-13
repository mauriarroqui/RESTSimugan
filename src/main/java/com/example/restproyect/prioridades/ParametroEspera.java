package com.example.restproyect.prioridades;

import com.example.restproyect.dto.Documento;

public class ParametroEspera extends AbsParametro{

	
	public ParametroEspera(int[] prioridades) {
		super(1,prioridades);
	}
	
	// en caso de que los valores estan delimitado por rangos, es necesario usar esta funcion
	// para poder obtener el valor del arreglo
	private int getIndex(int valor) {
		return 0;
	}

	@Override
	public int getPuntaje(Documento doc) {
		//cambiar el 0 por el valor del parametro obtenido del xml
		return prioridades[this.getIndex(0)];
	}

}
