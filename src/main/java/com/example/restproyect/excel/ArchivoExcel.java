package com.example.restproyect.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.LineChartSeries;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;

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
			if(rowNumero == 1 || colNumero == 0) {
				cell.setCellValue(valores.get(colNumero));
			}else {
				cell.setCellValue(Double.valueOf(valores.get(colNumero)));				
			}
		}
	}
	
//	private void generarChart() {
//		Drawing drawing = this.sheet.createDrawingPatriarch();
//        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, this.HEADER.size() + 2, 3, this.HEADER.size() + 15, 20);
//
//        Chart chart = drawing.createChart(anchor);
//        ChartLegend legend = chart.getOrCreateLegend();
//        legend.setPosition(LegendPosition.RIGHT);
//        
//        LineChartData data = chart.getChartDataFactory().createLineChartData();
//
//        ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
//        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
//        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
//
//        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(this.sheet, new CellRangeAddress(0, this.rowNumero - 1, 0, 0));
//        ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(this.sheet, new CellRangeAddress(0, this.rowNumero - 1, 1, 1));
//        ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(this.sheet, new CellRangeAddress(0, this.rowNumero - 1, 2, 2));
//        ChartDataSource<Number> ys3 = DataSources.fromNumericCellRange(this.sheet, new CellRangeAddress(0, this.rowNumero - 1, 3, 3));
//        ChartDataSource<Number> ys4 = DataSources.fromNumericCellRange(this.sheet, new CellRangeAddress(0, this.rowNumero - 1, 4, 4));
//        ChartDataSource<Number> ys5 = DataSources.fromNumericCellRange(this.sheet, new CellRangeAddress(0, this.rowNumero - 1, 5, 5));
//        ChartDataSource<Number> ys6 = DataSources.fromNumericCellRange(this.sheet, new CellRangeAddress(0, this.rowNumero - 1, 6, 6));
//
//        LineChartSeries series1 = data.addSeries(xs, ys1);
//        series1.setTitle(this.HEADER.get(1));
//        LineChartSeries series2 = data.addSeries(xs, ys2);
//        series2.setTitle(this.HEADER.get(2));
//        LineChartSeries series3 = data.addSeries(xs, ys3);
//        series3.setTitle(this.HEADER.get(3));
//        LineChartSeries series4 = data.addSeries(xs, ys4);
//        series4.setTitle(this.HEADER.get(4));
//        LineChartSeries series5 = data.addSeries(xs, ys5);
//        series5.setTitle(this.HEADER.get(5));
//        LineChartSeries series6 = data.addSeries(xs, ys6);
//        series6.setTitle(this.HEADER.get(6));
//
//        chart.plot(data, bottomAxis, leftAxis);
//
//        XSSFChart xssfChart = (XSSFChart) chart;
//        CTPlotArea plotArea = xssfChart.getCTChart().getPlotArea();
//        plotArea.getLineChartArray()[0].getSmooth();
//        CTBoolean ctBool = CTBoolean.Factory.newInstance();
//        ctBool.setVal(false);
//        plotArea.getLineChartArray()[0].setSmooth(ctBool);
//        for (CTLineSer ser : plotArea.getLineChartArray()[0].getSerArray()) {
//            ser.setSmooth(ctBool);
//        }
//	}
	
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
	
	public int getMinuto() {
		return this.minutos;
	}
}
