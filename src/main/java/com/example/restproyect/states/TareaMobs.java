package com.example.restproyect.states;

import java.util.ArrayList;
import java.util.List;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.hilos.tareas.AbsTarea;
import com.example.restproyect.states.objetosinternos.mobs.VariacionesMobs;

public class TareaMobs extends AbsTarea {
	private List<VariacionesMobs> variaciones;

	public TareaMobs(ArrayList<VariacionesMobs> cloneList, FiltroAbs filtro, Documento documento, Integer integer) {
		// TODO Auto-generated constructor stub
		this.variaciones = cloneList;
		this.filtro = filtro;
		this.doc = documento;
		this.numero = integer;
	}

	@Override
	public ArrayList<Documento> call() {
		// TODO Auto-generated method stub
		return null;
	}

}
