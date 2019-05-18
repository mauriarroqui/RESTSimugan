package com.example.restproyect.prioridades;

import com.example.restproyect.dto.Documento;

public abstract class AbsParametro {

	protected int[] prioridades;
	
	protected float valorDePrioridad;
	
	
	
	public float getValorDePrioridad() {
		return valorDePrioridad;
	}

	public AbsParametro(int valorDePrioridad, int[] prioridades) {
		this.valorDePrioridad = valorDePrioridad;
		this.prioridades = prioridades;
	}
	
	public abstract int getPuntaje(Documento doc);
}
