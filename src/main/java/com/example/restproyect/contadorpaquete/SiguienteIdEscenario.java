package com.example.restproyect.contadorpaquete;

import org.springframework.stereotype.Component;

@Component
public class SiguienteIdEscenario {

	private int nextId;

	public SiguienteIdEscenario() {
		super();
		this.nextId = 0;
	}
	
	public int idSiguiente(){
		return this.nextId++;
	}
	
}
