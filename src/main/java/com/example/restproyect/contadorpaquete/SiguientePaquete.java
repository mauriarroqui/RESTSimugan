package com.example.restproyect.contadorpaquete;

import org.springframework.stereotype.Component;

@Component
public class SiguientePaquete {

	private int idPaquete;

	public SiguientePaquete() {
		super();
		this.idPaquete = 0;
	}
	
	public int idSiguiente(){
		return this.idPaquete++;
	}
	
	
}
