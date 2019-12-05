package com.example.restproyect.mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAND;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroMayor;
import com.example.restproyect.filtros.FiltroMenor;
import com.example.restproyect.prioridades.ParametroYears;

public class MockSimulacion implements Runnable {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private Documento doc;
	private Mockgrid grid;
	private ParametroYears parametroYears;
	private boolean utilizarSimugan;
	
	

	public MockSimulacion(Documento doc, Mockgrid grid, boolean utilizarSimugan) {
		super();
		this.doc = doc;
		this.grid = grid;
		this.utilizarSimugan = utilizarSimugan;
		
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
		long tiempoSimulacion = 0;
		try {
			Random rand = new Random();
			int rango = (int) parametroYears.getPuntaje(this.doc)*60*1000;
			tiempoSimulacion = rand.nextInt(((rango+60000) - (rango-60000)) + 1) + (rango-60000);
			logger.info("Tiempo de procesamiento de la Tarea: " + tiempoSimulacion/1000 +"s para el documento id ["+this.doc.getId()+"] del paquete ["+this.doc.getIdPaquete()+"]" );
			Thread.sleep(tiempoSimulacion);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.doc.getTiempoEspera().setTiempoEjecucionGrid((int)tiempoSimulacion);
			this.grid.addDocumentoProcesado(this.doc);
			if(this.grid.getColaPaquetes() != null) {
				this.grid.getColaPaquetes().getPaquete(this.doc.getIdPaquete()).addCantidadProcesada();				
			}
			grid.liberarNodo();	
			logger.info("Finalizando el procesamiento de la Tarea del document id ["+this.doc.getId()+"] del paquete ["+this.doc.getIdPaquete()+"]");
			if(this.utilizarSimugan) {
				try {
//					for (int i = 0; i < this.grid.getDocumentosAProcesar().size()-1; i++) {
//						if(this.grid.getDocumentosAProcesar().get(i).getId() == this.doc.getId()) {
//							this.grid.getDocumentosAProcesar().remove(i);
//						}
//					}
					Documento documento = this.grid.getDocumentosAProcesar().get(0);
					grid.procesarSimulacion(documento);
					this.grid.getDocumentosAProcesar().remove(0);					
				} catch (Exception e2) {
					System.out.println("asdqwe");
				}
			}
		}
	}

}
