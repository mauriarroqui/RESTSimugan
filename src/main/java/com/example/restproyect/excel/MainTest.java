package com.example.restproyect.excel;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> header = new ArrayList<String>();
		header.add("Escenario Numero");
		header.add("Paquete 0");
		header.add("Paquete 1");
		header.add("Paquete 2");
		header.add("Paquete 3");
		header.add("Paquete 4");
		ArchivoExcel archivo = new ArchivoExcel();
		archivo.iniciarHojaExcel("Metricas Tesis", "Metrica Experimentacion",header);
		ArrayList<String> fila1 = new ArrayList<String>();
		fila1.add("0");
		fila1.add("");
		fila1.add("");
		fila1.add("");
		fila1.add("2");
		fila1.add("10:12:25");
		archivo.agregarFila(fila1);
		
		archivo.generarArchivoExcel();
	}

}
