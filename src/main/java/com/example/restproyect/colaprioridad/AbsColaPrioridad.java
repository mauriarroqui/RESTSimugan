package com.example.restproyect.colaprioridad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;

import com.example.restproyect.dto.Documento;

public abstract class AbsColaPrioridad {
	
	protected SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	public abstract void agregarCola(Hashtable<Integer, Documento> escenarios);
	
	public abstract ArrayList<Documento> getEscenarios();
	
	public abstract void ponderarEscenarios();
}
