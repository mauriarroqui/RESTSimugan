package com.example.restproyect.filtros;

public class FiltroMenor extends FiltroAbs{

	private double valor;
	
	
	public FiltroMenor(double valor) {
		super();
		this.valor = valor;
	}


	@Override
	public boolean cumple(Object valor) {
		if((double)valor <= this.valor) {
			return true;
		}
		return false;
	}


	@Override
	public String toString() {
		return "FiltroMenor [valor=" + valor + "]";
	}
	
	
}
