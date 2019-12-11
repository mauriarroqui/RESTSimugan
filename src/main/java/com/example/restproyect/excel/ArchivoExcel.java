package com.example.restproyect.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

public class ArchivoExcel {
	private final static String NOMBRE_ARCHIVO = "reporte.xlsx";
	private String nombre;
	private String nombre_hoja;
	private ArrayList<String> HEADER;
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private int rowNumero;
	private static ArchivoExcel archivo;
	private int minutos;
	private ArrayList<String> ultimaFila;
	
	//Constructor si no es un bean y son clases que se general
	private ArchivoExcel(String nombre, String nombre_hoja, ArrayList<String> header) {
		super();
		this.minutos = 0;
		this.nombre = nombre;
		this.nombre_hoja = nombre_hoja;
		this.HEADER = header;
		this.ultimaFila = new ArrayList<String>();
		this.workbook = new XSSFWorkbook();
		this.sheet = workbook.createSheet(this.nombre_hoja);
		this.rowNumero = 0;
		this.agregarFila(this.HEADER);
	}

	public static ArchivoExcel getSingletonInstance(String nombre, String nombre_hoja, ArrayList<String> header) {
        if (archivo == null){
        	archivo = new ArchivoExcel(nombre, nombre_hoja, header);
        }        
        return archivo;
    }

	public void agregarFila(ArrayList<String> valores) {
		this.ultimaFila = valores;
		Row row = sheet.createRow(rowNumero++);
		for(int colNumero=0; colNumero < valores.size(); colNumero++) {
			Cell cell = row.createCell(colNumero);
			cell.setCellValue(valores.get(colNumero));
		}
	}
	
	public void generarArchivoExcel() {      
        try {
            FileOutputStream outputStream = new FileOutputStream(this.NOMBRE_ARCHIVO);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }       
       
	};
	
	public void agregarUnMinuto() {
		this.minutos++;
	}
}
