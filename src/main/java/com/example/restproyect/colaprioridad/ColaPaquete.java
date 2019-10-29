package com.example.restproyect.colaprioridad;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.example.restproyect.dto.Paquete;

@Component
public class ColaPaquete {
	
	private HashMap<Integer,Paquete> paquetes;

	public ColaPaquete() {
		super();
		this.paquetes = new HashMap<Integer, Paquete>();
	}	
	
	public void addPaquete(Paquete nuevoPaquete){
		this.paquetes.put(nuevoPaquete.getIdPaquete(), nuevoPaquete);
	}
	
	public Paquete getPaquete(int idPaquete) {
		return this.paquetes.get(idPaquete);
	}
	
	public void setPaquete(Paquete paquete) {
		System.out.println("Probando el set del paquete");
	}
	

}
