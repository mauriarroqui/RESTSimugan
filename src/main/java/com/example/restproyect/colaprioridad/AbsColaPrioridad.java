package com.example.restproyect.colaprioridad;

import java.util.Hashtable;

import com.example.restproyect.dto.Documento;

public interface AbsColaPrioridad {
	public abstract void agregarCola(Hashtable<Integer, Documento> escenarios);
}
