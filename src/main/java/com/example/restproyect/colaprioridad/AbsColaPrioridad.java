package com.example.restproyect.colaprioridad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;

import com.example.restproyect.dto.Documento;

public abstract class AbsColaPrioridad {
	
	protected SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	public abstract void agregarCola(Hashtable<Integer, Documento> escenarios,int idPaquete);
	
	public abstract ArrayList<Documento> getEscenarios();
	
	public abstract void ponderarEscenarios(ColaUsuarios usuarios);

	public abstract void mostrarResultados(); 
	public boolean finalizoPaquete(Documento documento, AbsColaPrioridad lista) {
		for(Documento doc: lista.getEscenarios()) {
			if(doc.getIdPaquete() == documento.getIdPaquete()) {
				if(documento.getId() != doc.getId()) {
					System.out.println("Hay mas elementos, no finalizo");
					return false;
				}
				
			}
		}
		System.out.println("Finalizando");
		return true;
	}
	
	public void actualizarCantidadEscenarios(ColaUsuarios usuarios, AbsColaPrioridad lista) {
		for(Documento doc : lista.getEscenarios()) {
			int cantidad = usuarios.getUsuario(doc.getUsuario().getIdUser()).getCantidadEscenarios();
			doc.getUsuario().setCantidadEscenarios(cantidad);
		}
	}
	
}
