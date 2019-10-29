package com.example.restproyect.dto;

public class Paquete {

	private int idPaquete;
	private int totalEscenarios;
	private int cantidadProcesados;
	
	public Paquete(int idPaquete) {
		super();
		this.idPaquete = idPaquete;
	}

	public int getIdPaquete() {
		return idPaquete;
	}

	public int getTotalEscenarios() {
		return totalEscenarios;
	}

	public void setTotalEscenarios(int totalEscenarios) {
		this.totalEscenarios = totalEscenarios;
	}

	public int getCantidadProcesados() {
		return cantidadProcesados;
	}

	public void setCantidadProcesados(int cantidadProcesados) {
		this.cantidadProcesados = cantidadProcesados;
	}
	
	public void addCantidadProcesada() {
		this.cantidadProcesados++;
	}
	
	public boolean completo() {
		return ((this.totalEscenarios - this.cantidadProcesados) == 0);
	}
	
	
	
	
}
