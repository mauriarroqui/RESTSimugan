package com.example.restproyect.service;

import java.util.Hashtable;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restproyect.colaprioridad.AbsColaPrioridad;
import com.example.restproyect.colaprioridad.ColaUsuarios;
import com.example.restproyect.contadorpaquete.SiguientePaquete;
import com.example.restproyect.dto.Documento;
import com.example.restproyect.logicanegocio.DocumentadorService;
import com.example.restproyect.logicanegocio.IGeneradorService;
import com.example.restproyect.states.Simulacion;
import com.example.restproyect.states.VariacionesReact;

@RestController
@RequestMapping(value = "/mockear")
public class GeneradorMock {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * Interfaz que controla los metodos que se puedan hacer para la
	 * generacion de escenarios. Permite agregar nuevas clases o
	 * tipos de generacion en un futuro 
	 */
	@Autowired
	private IGeneradorService generadorVariaciones;
	
	/*
	 * Colas de escenarios a ser ponderadas. Estan inyectadas porque
	 * siempre es la misma instancia que se va a correr mientras este
	 * el servicio rest funcionando
	 */
	
	@Autowired
	@Qualifier("colaMock")
	private AbsColaPrioridad colaMock;
	
	@Autowired
	private DocumentadorService documentadorSimulaciones;

	/*
	 * Colas de usuarios para almacenar los tiempos de computos que tuvo cada uno 
	 */
	@Autowired
	private ColaUsuarios colaUsuarios;
	
	@Autowired
	private SiguientePaquete siguientePaquete;
	
	@RequestMapping(value = "/mockSimulation", method = RequestMethod.POST)
    public HttpStatus createSimulacion(@Valid @RequestBody Simulacion simulacion) {
		try {
			logger.debug("------------------------------AGREGAR SIMULACION de USUARIO ------------------------------");
			System.out.println("------------------------------AGREGAR SIMULACION USUARIO"+ simulacion.getUsuario().isExperimental()+ "------------------------------");
			simulacion.generarDocumento();
			Documento nuevo = new Documento(simulacion.getDocumento(),simulacion.getUsuario());
			int idPaquete = siguientePaquete.idSiguiente();
			nuevo.setIdPaquete(idPaquete);
			Hashtable<Integer,Documento> escenario = new Hashtable<Integer, Documento>();
			escenario.put(nuevo.getId(), nuevo);
			colaUsuarios.addUsuario(simulacion.getUsuario(), 1);
			colaMock.agregarCola(escenario,idPaquete);	
			return HttpStatus.OK;
				
		}catch(Exception e) {
			logger.error("Fallo en la peticion de agregar simulacion para el usuario ");
			System.out.println(e);
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public HttpStatus createSimulaciones(@Valid @RequestBody VariacionesReact variacionesReact) {
		try {
			logger.debug("------------------------------COMIENZA LA GENERACION DE SIMULACIONES MOCK USUARIO ["+variacionesReact.getUsuario().getIdUser()+"]------------------------------");
			System.out.println("------------------------------COMIENZA LA GENERACION DE SIMULACIONES MOCK USUARIO ["+variacionesReact.getUsuario().getIdUser()+"]------------------------------");
			
			int idPaquete = siguientePaquete.idSiguiente();
			
			generadorVariaciones.generarDocumento(variacionesReact,idPaquete);
			
			Hashtable<Integer,Documento> escenarios = generadorVariaciones.generarSimulaciones(variacionesReact);
			//Agregamos el usuario a la cola
			colaUsuarios.addUsuario(variacionesReact.getUsuario(), escenarios.size());
			
			System.out.println("------> cantidad de escenarios MOCK generados : "+ escenarios.size());

			colaMock.agregarCola(escenarios, idPaquete);
			
			System.out.println("------------------------------FIN LA GENERACION DE SIMULACIONES MOCK USUARIO ["+variacionesReact.getUsuario().getIdUser()+"]------------------------------");
			return HttpStatus.OK;
		}catch(Exception e) {
			logger.error("Fallo en la peticion de agregar simulaciones para el usuario "+variacionesReact.getUsuario());
			System.out.println(e);
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }

}
