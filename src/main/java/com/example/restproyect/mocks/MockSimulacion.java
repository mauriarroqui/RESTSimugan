package com.example.restproyect.mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAND;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroMayor;
import com.example.restproyect.filtros.FiltroMenor;
import com.example.restproyect.prioridades.ParametroYears;

public class MockSimulacion implements Runnable {
	
	private Documento doc;
	private Mockgrid grid;
	private ParametroYears parametroYears;
	
	

	public MockSimulacion(Documento doc, Mockgrid grid) {
		super();
		this.doc = doc;
		this.grid = grid;
		
		FiltroAbs rango1 = new FiltroAND(new FiltroMayor(0),new FiltroMenor(10));
		FiltroAbs rango2 = new FiltroAND(new FiltroMayor(11),new FiltroMenor(20));
		FiltroAbs rango3 = new FiltroAND(new FiltroMayor(21),new FiltroMenor(40));
		FiltroAbs rango4 = new FiltroMayor(41);
		List<FiltroAbs> filtroYears = new ArrayList<FiltroAbs>();
		filtroYears.add(rango1);
		filtroYears.add(rango2);
		filtroYears.add(rango3);
		filtroYears.add(rango4);
		
		parametroYears = new ParametroYears(new double[] {8,6,4,2},filtroYears,0);
		
		
	}
	
	


	public Documento getDoc() {
		return doc;
	}



	public void setDoc(Documento doc) {
		this.doc = doc;
	}



	public Mockgrid getGrid() {
		return grid;
	}



	public void setGrid(Mockgrid grid) {
		this.grid = grid;
	}

	// FALTA REALIZAR LOS RANGOS POR LOS CUALES SE VA A DECIDIR CUANTO TIEMPO VA A TARDAR LA SIMULACION


	@Override
	public void run() {
		try {
			Random rand = new Random();
			int rango = (int) parametroYears.getPuntaje(this.doc)*60*1000;
			long tiempoSimulacion = rand.nextInt(((rango+60000) - (rango-60000)) + 1) + (rango-60000);
			
			Thread.sleep(tiempoSimulacion);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		grid.liberarNodo();
	}

}
