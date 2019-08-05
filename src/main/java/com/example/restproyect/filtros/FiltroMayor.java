package com.example.restproyect.filtros;

public class FiltroMayor extends FiltroAbs{

	private double valor;
	
	
	public FiltroMayor(double valor) {
		super();
		this.valor = valor;
	}


	@Override
	public boolean cumple(Object valor) {
		if((double)valor >= this.valor) {
			return true;
		}
		return false;
	}


	@Override
	public String toString() {
		return "FiltroMayor [valor=" + valor + "]";
	}

	
}
