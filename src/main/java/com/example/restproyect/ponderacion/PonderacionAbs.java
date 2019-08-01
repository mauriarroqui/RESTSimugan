package com.example.restproyect.ponderacion;

import java.util.ArrayList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.prioridades.AbsParametro;

public abstract class PonderacionAbs {
	
	protected ArrayList<AbsParametro> parametros = new ArrayList<AbsParametro>(); 
	
	public abstract double getValor(Documento doc);

}
