package com.example.restproyect.hilos.tareas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.states.objetosinternos.feedlot.VariacionFeedLot;

public abstract class AbsTarea implements Callable<ArrayList<Documento>>{

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected Documento doc;
	protected FiltroAbs filtro;	
    protected int numero; 
    
	public abstract ArrayList<Documento> call();


}
