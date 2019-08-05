package com.example.restproyect.filtros;

public class FiltroAND extends FiltroAbs {

	private FiltroAbs filtro1;
	private FiltroAbs filtro2;
	
	
	public FiltroAND(FiltroAbs filtro1, FiltroAbs filtro2) {
		super();
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}


	@Override
	public boolean cumple(Object valor) {
		if(this.filtro1.cumple(valor)&& filtro2.cumple(valor)) {
			return true;
		}
		return false;
	}


	public FiltroAbs getFiltro1() {
		return filtro1;
	}


	public void setFiltro1(FiltroAbs filtro1) {
		this.filtro1 = filtro1;
	}


	public FiltroAbs getFiltro2() {
		return filtro2;
	}


	public void setFiltro2(FiltroAbs filtro2) {
		this.filtro2 = filtro2;
	}


	@Override
	public String toString() {
		return "FiltroAND [filtro1=" + filtro1 + ", filtro2=" + filtro2 + "]";
	}
	
	

}
