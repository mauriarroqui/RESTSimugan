package com.example.restproyect.prioridades;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;

public abstract class AbsParametro {

	protected double[] prioridades;
	protected List<FiltroAbs> filtros;
	
	protected float valorDePrioridad;
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public float getValorDePrioridad() {
		return valorDePrioridad;
	}

	public AbsParametro(int valorDePrioridad, double[] prioridades) {
		this.valorDePrioridad = valorDePrioridad;
		this.prioridades = prioridades;
	}
	
	public abstract double getPuntaje(Documento doc);
}
