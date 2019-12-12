package com.example.restproyect.tareasautomaticas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.restproyect.colaprioridad.ColaPaquete;
import com.example.restproyect.mocks.Mockgrid;
import com.example.restproyect.excel.ArchivoExcel;

@Service
public class TaskInfoPaquetes {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ColaPaquete colaPaquetes;
	
	@Autowired
	@Qualifier("mockgrid")
	private Mockgrid mockgrid;
	
	@Scheduled(fixedRateString = "${task.infopaquetes}")
	public void scheduleTaskWithInitialDelay() {
		ArrayList<String> header = new ArrayList<String>();
		header.add("Minuto");
		header.add("Cantidad Escenarios");
		header.add("Paquete 0");
		header.add("Paquete 1");
		header.add("Paquete 2");
		header.add("Paquete 3");
		header.add("Paquete 4");
		ArchivoExcel plantilla = ArchivoExcel.getSingletonInstance("Metricas Tesis", "Metrica Experimentacion", header);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		SimpleDateFormat formatExcel = new SimpleDateFormat("hh:mm:ss");
		logger.debug("-----------------------> Informacion de los estados de los paquetes a la hora: "+format.format(new Date())+" <------------------------------");

		logger.debug("Nodos disponibles: " + mockgrid.getNodosDisponibles());
		logger.debug("WORKLOAD de la GRID: " + mockgrid.getWorkload()*100 + "%");

		//Agregar la info al archivo excel
		ArrayList<String> filaExcel = new ArrayList<String>();
		filaExcel.add(String.valueOf(plantilla.getMinuto()));
		plantilla.agregarUnMinuto();
		filaExcel.add(this.colaPaquetes.getCantidadDocumentosProcesados());

		colaPaquetes.getPaquetes().forEach((key,value)->{
			logger.info("Estado del paquete ["+value.getIdPaquete()+"] para el usuario ["+value.getIdUsuario()+"]");
			logger.info("      * Documentos procesados ["+value.getCantidadProcesados()+"]  sobre ["+value.getTotalEscenarios()+"]");
			filaExcel.add(String.valueOf(value.getCantidadProcesados()));
		});
		plantilla.agregarFila(filaExcel);
		if(this.colaPaquetes.hasTodosCompletos() && !this.colaPaquetes.getPaquetes().isEmpty() && !plantilla.isGenerado()) {
			plantilla.generarArchivoExcel();
		}
		logger.info("-----------------------> Fin de los estados de los paquetes <------------------------------");

	}
}
