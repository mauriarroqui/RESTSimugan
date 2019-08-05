package com.example.restproyect.filtros;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class FiltroNombre extends FiltroAbs{

	private String nombre;
	
	
	public FiltroNombre(String nombre) {
		super();
		this.nombre = nombre;
	}


	@Override
	public boolean cumple(Object valor) {
		if(((Node) valor).getNodeName().equals(this.nombre)) {
			return true;
		}
		return false;
	}


	@Override
	public String toString() {
		return "FiltroNombre [nombre=" + nombre + "]";
	}

	

}
