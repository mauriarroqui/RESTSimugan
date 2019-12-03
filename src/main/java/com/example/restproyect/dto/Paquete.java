package com.example.restproyect.dto;

import java.util.Date;

public class Paquete {

	private int idPaquete;
	private int totalEscenarios;
	private int cantidadProcesados;
	private Date fechaInicio;
	private Date fechaFin;
	private int idUsuario;
	
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
	
	public boolean isCompleto() {		
		return ((this.totalEscenarios - this.cantidadProcesados) == 0);
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setIdPaquete(int idPaquete) {
		this.idPaquete = idPaquete;
	}
	
	public long getDiferenciaHoraria() {
		return this.fechaFin.getTime() - this.fechaInicio.getTime();
	}
	
	
	
	
	
}
