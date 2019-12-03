package com.example.restproyect.tareasautomaticas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.restproyect.colaprioridad.ColaPaquete;
import com.example.restproyect.colaprioridad.ColaUsuarios;
import com.example.restproyect.dto.Paquete;
import com.example.restproyect.mocks.Mockgrid;

import antlr.collections.List;

@Service
public class TaskTiempoPorUsuarioCompleto {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ColaPaquete colaPaquetes;
	
	@Autowired
	@Qualifier("mockgrid")
	private Mockgrid mockgrid;
	
	@Autowired
	private ColaUsuarios usuarios;
	
	@Scheduled(fixedRateString = "${task.tiempoporusuariocompleto}")
	public void scheduleTaskWithInitialDelay() {

		HashMap<Integer, Long> tiempoUsuarios = new HashMap<Integer, Long>();
		ArrayList<Integer> usuariosIncompletos = new ArrayList<>();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		logger.info("-----------------------> Comenzando a tomar las metricas a la hora: "+format.format(new Date())+" <------------------------------");
		
		this.usuarios.getUsuarios().forEach((idUsuario, usuario) -> {
			int id_usuario = Integer.parseInt(idUsuario);
			ArrayList<Paquete> paquetes = this.colaPaquetes.getPaquetesPorUsuario(id_usuario);
			if(paquetes.size() > 0) {
				long tiempoTotalPorUsuario = 0;
				int completos = 0;
				int total = paquetes.size();
				for (Paquete paquete : paquetes) {
					if(paquete.isCompleto()) {
						completos++;
						tiempoTotalPorUsuario += paquete.getDiferenciaHoraria();						
					}else {
						this.logger.info("Usuario ["+id_usuario+"] no tiene todos los paquetes completos");
						usuariosIncompletos.add(id_usuario);
					}
				}
				if((total-completos)==0) {
					//Agregamos el paquete porque ya esta listo para procesar el tiempo
					tiempoUsuarios.put(id_usuario, tiempoTotalPorUsuario);		
					this.logger.info("Usuario ["+id_usuario+"] completo todos sus paquetes");
				}
				
			}
		});
		
		if(usuariosIncompletos.size() > 0) {
//			logger.info("Los usuarios faltantes ["+usuariosIncompletos.size()+"] de finalizar paquetes son los siguientes: ");
//			for (Integer integer : usuariosIncompletos) {
//				logger.info("    * Usuario numero: ["+integer+"]");
//			}
		}else {
			tiempoUsuarios.forEach((idUsuario,valor)->{
				logger.info(" El usuario ["+idUsuario+"] tardo ["+valor/1000+"] segundos en procesar todos los paquetes");
			});			
		}
//		
		
		

	}
}
