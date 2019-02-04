package com.example.restproyect.calculadores;

import com.example.restproyect.dto.Documento;

public abstract class AbsCalculador {
	/*
	 * Valores que se usan para calcular la prioridad de los documentos
	 */
	protected int valorTiempoComputo = 5;
	
	/*
	 * Fin valores que se usan para calcular la prioridad de los documentos
	 */
	public abstract double Calcular(Documento doc);
}
