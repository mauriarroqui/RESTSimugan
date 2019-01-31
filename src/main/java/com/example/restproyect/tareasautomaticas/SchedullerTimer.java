package com.example.restproyect.tareasautomaticas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.restproyect.dto.AbsColaPrioridad;

@Component
public class SchedullerTimer {

	@Autowired
	@Qualifier("colaSimulacion")
	private AbsColaPrioridad colaSimulacion;
	
	@Autowired
	@Qualifier("colaExperimentacion")
	private AbsColaPrioridad colaExperimentacion;
	
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRateString = "${priorizar.tarea}")
    public void scheduleTaskWithInitialDelay() {
    	if(colaSimulacion.getEscenarios().size() == 0) {
    		System.err.println("Mirando la cola de simulacion para schedulear ["+this.colaSimulacion.getEscenarios().size()+"]"+ dateTimeFormatter.format(LocalDateTime.now()));    		
    	}
    	if(colaExperimentacion.getEscenarios().size() == 0) {
    		System.err.println("Mirando la cola de simulacion para schedulear ["+this.colaExperimentacion.getEscenarios().size()+"]"+ dateTimeFormatter.format(LocalDateTime.now()));
    	}
    }

}
