package com.example.restproyect.prioridades;

import com.example.restproyect.dto.Documento;

public abstract class AbsParametro {

	protected double[] prioridades;
	
	protected float valorDePrioridad;
	
	
	
	public float getValorDePrioridad() {
		return valorDePrioridad;
	}

	public AbsParametro(int valorDePrioridad, double[] prioridades) {
		this.valorDePrioridad = valorDePrioridad;
		this.prioridades = prioridades;
	}
	
	public abstract double getPuntaje(Documento doc);
}
