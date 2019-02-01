package com.example.restproyect.service;



import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Transient;
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
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.AbsColaPrioridad;
import com.example.restproyect.dto.ColaUsuarios;
import com.example.restproyect.dto.Documento;
import com.example.restproyect.hilos.ThreadPool;
import com.example.restproyect.logicanegocio.GeneradorService;
import com.example.restproyect.logicanegocio.IGeneradorService;
import com.example.restproyect.states.Diferido;
import com.example.restproyect.states.RecursoForrajero;
import com.example.restproyect.states.VariacionesReact;

//Capa de servicios
@RestController
@RequestMapping(value = "/simugan")
public class GeneradorSimulaciones {
	
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
	@Qualifier("colaSimulacion")
	private AbsColaPrioridad colaSimulacion;
	
	@Autowired
	@Qualifier("colaExperimentacion")
	private AbsColaPrioridad colaExperimentacion;
	
	/*
	 * Colas de usuarios para almacenar los tiempos de computos que tuvo cada uno 
	 */
	@Autowired
	private ColaUsuarios colaUsuarios;
	

	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public HttpStatus createSimulaciones(@Valid @RequestBody VariacionesReact variacionesReact) {
		try {
			logger.debug("Nueva peticion de agregar simulaciones");
			System.out.println(variacionesReact.toString());
			
			generadorVariaciones.generarDocumento(variacionesReact);
			
			Hashtable<Integer,Documento> escenarios = generadorVariaciones.generarSimulaciones(variacionesReact);
			//Agregamos el usuario a la cola
			colaUsuarios.addUsuario(variacionesReact.getUsuario(), escenarios.size());
			
			//Si el usuario es de simulacion
			if(variacionesReact.getUsuario().getFiltro().cumple(variacionesReact.getUsuario().getTipoUsuario())) {
				colaSimulacion.agregarCola(escenarios);				
			}else {
				//Si el usuario es de experimentacion
				colaExperimentacion.agregarCola(escenarios);				
			}
			
			
			return HttpStatus.OK;
		}catch(Exception e) {
			logger.error("Fallo en la peticion de agregar simulaciones para el usuario "+variacionesReact.getUsuario());
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public HttpStatus getSimulaciones() {
		return HttpStatus.OK;
    }
	
	
	/*@RequestMapping(value = "/mob", method = RequestMethod.POST)
    public HttpStatus postMob(@Valid @RequestBody Mob variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		try {
			System.out.println(variacionesReact.toString());
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }
	
	@RequestMapping(value = "/destete", method = RequestMethod.POST)
    public HttpStatus postDestete(@Valid @RequestBody Destete variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		try {
			System.out.println(variacionesReact.toString());
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }
	
	@RequestMapping(value = "/engorde", method = RequestMethod.POST)
    public HttpStatus postEngorde(@Valid @RequestBody Engorde variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		try {
			System.out.println(variacionesReact.toString());
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }*/
}
