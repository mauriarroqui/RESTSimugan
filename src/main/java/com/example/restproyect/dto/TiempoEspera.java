package com.example.restproyect.dto;

public class TiempoEspera {

	private int tiempoGeneracion;
	private int tiempoEspera;
	private int tiempoEjecucionGrid;
	private int tiempoConexionGrid;
	
	public TiempoEspera() {
		super();
		this.tiempoConexionGrid = 0;
		this.tiempoEjecucionGrid = 0;
		this.tiempoEspera = 0;
		this.tiempoGeneracion = 0;
	}
	
	public int getTiempoGeneracion() {
		return tiempoGeneracion;
	}
	
	public void setTiempoGeneracion(int tiempoGeneracion) {
		this.tiempoGeneracion = tiempoGeneracion;
	}
	
	public int getTiempoEspera() {
		return tiempoEspera;
	}
	
	public void setTiempoEspera(int tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}
	
	public int getTiempoEjecucionGrid() {
		return tiempoEjecucionGrid;
	}
	
	public void setTiempoEjecucionGrid(int tiempoEjecucionGrid) {
		this.tiempoEjecucionGrid = tiempoEjecucionGrid;
	}
	
	public int getTiempoConexionGrid() {
		return tiempoConexionGrid;
	}
	
	public void setTiempoConexionGrid(int tiempoConexionGrid) {
		this.tiempoConexionGrid = tiempoConexionGrid;
	}

	@Override
	public String toString() {
		return "TiempoEspera [tiempoGeneracion=" + tiempoGeneracion + ", tiempoEspera=" + tiempoEspera
				+ ", tiempoEjecucionGrid=" + tiempoEjecucionGrid + ", tiempoConexionGrid=" + tiempoConexionGrid + "]";
	}
	
	
}
