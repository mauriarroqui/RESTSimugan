package com.example.restproyect.dto;

import java.util.Date;

public class Paquete {

	private int idPaquete;
	private int totalEscenarios;
	private int cantidadProcesados;
	private Date fechaInicio;
	private Date fechaFin;
	
	public Paquete(int idPaquete) {
		super();
		this.idPaquete = idPaquete;
		this.fechaInicio = new Date();
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
		if((this.totalEscenarios - this.cantidadProcesados) == 0) {
			this.fechaFin = new Date();
		}
	}
	
	public boolean completo() {		
		return ((this.totalEscenarios - this.cantidadProcesados) == 0);
	}
	
	
	
	
}
