package com.example.restproyect.tareasautomaticas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.restproyect.dto.AbsColaPrioridad;
import com.example.restproyect.dto.ColaUsuarios;
import com.example.restproyect.dto.Usuario;

@Component
public class SchedullerTimer {

	@Autowired
	@Qualifier("colaSimulacion")
	private AbsColaPrioridad colaSimulacion;
	
	@Autowired
	@Qualifier("colaExperimentacion")
	private AbsColaPrioridad colaExperimentacion;
	
	@Autowired
	private ColaUsuarios usuarios;
	
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRateString = "${priorizar.tarea}")
    public void scheduleTaskWithInitialDelay() {
    	/*
    	 * Ejecutar cada X minutos el calculo de las prioridades. Siempre el orden esta dado
    	 * por la cola de simulaciones primero. Si la cola de simulacion no tiene nada
    	 * empezamos a ordenar la cola de experimentacion para enviar al simulador. Queda
    	 * configurado para ejecutar el orden cada 30 minutos. El tiempo esta en el archivo
    	 * 
    	 *               application.properties --> src/main/resources
    	 */
    	
    	if(colaSimulacion.getEscenarios().size() > 0) {
    		System.err.println("Mirando la cola de simulacion para schedulear ["+this.colaSimulacion.getEscenarios().size()+"]"+ dateTimeFormatter.format(LocalDateTime.now()));    		
    	}else{
    		if(colaExperimentacion.getEscenarios().size() == 0) {
    			System.err.println("Mirando la cola de simulacion para schedulear ["+this.colaExperimentacion.getEscenarios().size()+"]"+ dateTimeFormatter.format(LocalDateTime.now()));
    		}    		
    	}
    }
    
    @Scheduled(fixedRateString = "${monitorear.usuario}")
    public void scheduleTaskWithInitialDelay2() {
    	/*
    	 * Cada X minutos vemos si hay usuarios en la lista que no tengan simulaciones para
    	 * ejecutar, por lo tanto los eliminamos para no tenerlos en cuenta en los calculos
    	 * de las prioridades.
    	 * 
    	 *               application.properties --> src/main/resources
    	 */
    	
    	this.usuarios.eliminarUsuarios();
    }

}
