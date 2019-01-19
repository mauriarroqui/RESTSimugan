package com.example.restproyect.logicanegocio;

import java.util.Hashtable;

import javax.validation.Valid;

import com.example.restproyect.dto.AbsColaPrioridad;
import com.example.restproyect.dto.Documento;
import com.example.restproyect.states.VariacionesReact;

public interface IGeneradorService {
	

	public Hashtable<Integer,Documento> generarSimulaciones(VariacionesReact variaciones);
	
	public void generarDocumento(@Valid VariacionesReact variacionesReact);
	
}
