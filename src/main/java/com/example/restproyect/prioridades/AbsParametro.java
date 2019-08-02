package com.example.restproyect.prioridades;

import java.util.List;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;

public abstract class AbsParametro {

	protected double[] prioridades;
	protected List<FiltroAbs> filtros;
	
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
