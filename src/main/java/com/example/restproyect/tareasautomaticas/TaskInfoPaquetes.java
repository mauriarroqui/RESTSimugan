package com.example.restproyect.tareasautomaticas;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.restproyect.colaprioridad.ColaPaquete;
import com.example.restproyect.mocks.Mockgrid;

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
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		logger.info("-----------------------> Informacion de los estados de los paquetes a la hora: "+format.format(new Date())+" <------------------------------");
		logger.info("Nodos disponibles: " + mockgrid.getNodosDisponibles());
		logger.info("WORKLOAD de la GRID: " + mockgrid.getWorkload()*100 + "%");
		colaPaquetes.getPaquetes().forEach((key,value)->{
			logger.info("Estado del paquete ["+value.getIdPaquete()+"] para el usuario ["+value.getIdUsuario()+"]");
			logger.info("      * Documentos procesados ["+value.getCantidadProcesados()+"]  sobre ["+value.getTotalEscenarios()+"]");
		});
		
		logger.info("-----------------------> Fin de los estados de los paquetes <------------------------------");

	}
}
