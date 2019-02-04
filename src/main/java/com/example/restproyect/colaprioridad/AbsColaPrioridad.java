package com.example.restproyect.colaprioridad;

import java.util.ArrayList;
import java.util.Hashtable;

import com.example.restproyect.dto.Documento;

public interface AbsColaPrioridad {
	public abstract void agregarCola(Hashtable<Integer, Documento> escenarios);
	
	public abstract ArrayList<Documento> getEscenarios();
}
