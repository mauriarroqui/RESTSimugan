package com.example.restproyect.filtros;

public class FiltroTipoUsuario extends FiltroAbs{
	private String valor;
	
	
	public FiltroTipoUsuario(String valor) {
		super();
		this.valor = valor;
	}


	@Override
	public boolean cumple(Object valor) {
		if(((String)valor).equals(this.valor)) {
			return true;
		}
		return false;
	}


	@Override
	public String toString() {
		return "FiltroTipoUsuario [valor=" + valor + "]";
	}

	
}
