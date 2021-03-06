package com.example.restproyect.tareasautomaticas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.restproyect.colaprioridad.AbsColaPrioridad;
import com.example.restproyect.colaprioridad.ColaPaquete;
import com.example.restproyect.colaprioridad.ColaUsuarios;
import com.example.restproyect.dto.Documento;
import com.example.restproyect.dto.Usuario;
import com.example.restproyect.mocks.Mockgrid;

@Service
public class TaskScheduler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("colaSimulacion")
	private AbsColaPrioridad colaSimulacion;

	@Autowired
	@Qualifier("colaExperimentacion")
	private AbsColaPrioridad colaExperimentacion;
	
	@Autowired
	private ColaUsuarios usuarios;
	
	@Autowired
	private ColaPaquete colaPaquetes;
	
	@Autowired
	@Qualifier("mockgrid")
	private Mockgrid mockgrid;
	
	@Value("${utilizar.simugan}")
	private boolean utilizarSimugan;

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Scheduled(fixedRateString = "${task.scheduler}")
	public void scheduleTaskWithInitialDelay() {
		/*
		 * Ejecutar cada X minutos el calculo de las prioridades. Siempre el orden esta
		 * dado por la cola de simulaciones primero. Si la cola de simulacion no tiene
		 * nada empezamos a ordenar la cola de experimentacion para enviar al simulador.
		 * Queda configurado para ejecutar el orden cada 30 minutos. El tiempo esta en
		 * el archivo
		 * 
		 * application.properties --> src/main/resources
		 */
		/*
		 * Esta variable representa la carga de trabajo de la grid. cuando se pueda
		 * consumir el servicio que diga el workload del grid, la idea seria calcular
		 * cuantas simulaciones juntas se pueden enviar a la grid. y si esa variable es
		 * 0, no enviar ninguna.
		 * 
		 * Si no se utiliza la cola de espera de simugan se usa el scheduler
		 */
		if(!this.utilizarSimugan) {
			logger.debug("comenzando a planificar...");
			int cantidadEscenariosAProcesar = mockgrid.getNodosDisponibles();
			logger.info("-----------------------> COMIENZA LA TAREA DE PONDERACION DE ESCENARIOS <------------------------------");
			logger.debug("Escenarios en la cola de experimentacion: " + this.colaExperimentacion.getEscenarios().size());
			logger.debug("Escenarios en la cola de simulacion: " + this.colaSimulacion.getEscenarios().size());
			logger.debug("Nodos disponibles: " + mockgrid.getNodosDisponibles());
			logger.debug("WORKLOAD de la GRID: " + mockgrid.getWorkload()*100 + "%");
			this.mockgrid.setColaPaquetes(colaPaquetes);
			if ( mockgrid.getWorkload() < 1 ) {
				if (colaSimulacion.getEscenarios().size() > 0) {
					colaSimulacion.actualizarCantidadEscenarios(this.usuarios, this.colaSimulacion);
					colaSimulacion.ponderarEscenarios(this.usuarios);
					colaSimulacion.mostrarResultados();
					ArrayList<Documento> escenarios = colaSimulacion.getEscenarios();
					
					for (int i = 0; i < cantidadEscenariosAProcesar; i++) {
						if (escenarios.size() == 0) {
							break;
						}
						mockgrid.procesarSimulacion(escenarios.get(0));		
						this.usuarios.getUsuario(escenarios.get(0).getUsuario().getIdUser()).decrementarEscenarios();
						escenarios.remove(0);
					}
					logger.debug(
							"Mirando la cola de simulacion para schedulear [" + this.colaSimulacion.getEscenarios().size()
									+ "]" + dateTimeFormatter.format(LocalDateTime.now()));
				} else {
					if (colaExperimentacion.getEscenarios().size() > 0) {
						colaExperimentacion.actualizarCantidadEscenarios(this.usuarios, this.colaExperimentacion);
						logger.debug("Mirando la cola de experimentacion para schedulear ["
								+ this.colaExperimentacion.getEscenarios().size() + "]"
								+ dateTimeFormatter.format(LocalDateTime.now()));
						colaExperimentacion.ponderarEscenarios(this.usuarios);
						colaExperimentacion.mostrarResultados();
						ArrayList<Documento> escenarios = colaExperimentacion.getEscenarios();
						for (int i = 0; i < cantidadEscenariosAProcesar; i++) {
							if (escenarios.size() == 0) {
								break;
							}
							mockgrid.procesarSimulacion(escenarios.get(0));	
							this.usuarios.getUsuario(escenarios.get(0).getUsuario().getIdUser()).decrementarEscenarios();
							escenarios.remove(0);
						}

					}
				}
			}
		}
		

	}

	@Scheduled(fixedRateString = "${monitorear.usuario}")
	public void scheduleTaskWithInitialDelay2() {
		/*
		 * Cada X minutos vemos si hay usuarios en la lista que no tengan simulaciones
		 * para ejecutar, por lo tanto los eliminamos para no tenerlos en cuenta en los
		 * calculos de las prioridades.
		 * 
		 * application.properties --> src/main/resources
		 */

//		this.usuarios.eliminarUsuarios();
	}

}
