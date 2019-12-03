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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.colaprioridad.AbsColaPrioridad;
import com.example.restproyect.colaprioridad.ColaPaquete;
import com.example.restproyect.colaprioridad.ColaUsuarios;
import com.example.restproyect.contadorpaquete.SiguienteIdEscenario;
import com.example.restproyect.contadorpaquete.SiguientePaquete;
import com.example.restproyect.dto.Documento;
import com.example.restproyect.dto.Paquete;
import com.example.restproyect.hilos.ThreadPool;
import com.example.restproyect.logicanegocio.DocumentadorService;
import com.example.restproyect.logicanegocio.GeneradorService;
import com.example.restproyect.logicanegocio.IGeneradorService;
import com.example.restproyect.mocks.Mockgrid;
import com.example.restproyect.states.Diferido;
import com.example.restproyect.states.RecursoForrajero;
import com.example.restproyect.states.Simulacion;
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
	
	@Autowired
	private ColaPaquete colaPaquetes;
	
	@Autowired
	private DocumentadorService documentadorSimulaciones;
	
	@Autowired
	private SiguientePaquete siguientePaquete;
	
	@Autowired
	private SiguienteIdEscenario nextId;
	
	@Value("${utilizar.simugan}")
	private boolean utilizarSimugan;
	
	@Autowired
	@Qualifier("mockgrid")
	private Mockgrid mockgrid;

	@RequestMapping(value = "/createSimulation", method = RequestMethod.POST)
    public HttpStatus createSimulacion(@Valid @RequestBody Simulacion simulacion) {
		try {
			logger.debug("------------------------------AGREGAR SIMULACION de USUARIO ------------------------------");
			logger.debug("------------------------------AGREGAR SIMULACION USUARIO"+ "------------------------------");
			int idPaquete = siguientePaquete.idSiguiente();
			Paquete nuevoPaquete = new Paquete(idPaquete);
			
			simulacion.generarDocumento();
			
			Documento nuevo = new Documento(simulacion.getDocumento(),simulacion.getUsuario());
			nuevo.setIdPaquete(idPaquete);
			
			nuevo.getTiempoEspera().setTiempoGeneracion(0);
			nuevoPaquete.setIdUsuario(Integer.parseInt(nuevo.getUsuario().getIdUser()));
			
			documentadorSimulaciones.completarDocumento(nuevo);
			
			Hashtable<Integer,Documento> escenario = new Hashtable<Integer, Documento>();
			escenario.put(nuevo.getId(), nuevo);
			
			nuevoPaquete.setTotalEscenarios(1);
			colaPaquetes.addPaquete(nuevoPaquete);
			colaUsuarios.addUsuario(simulacion.getUsuario(), 1);
			
			if(this.utilizarSimugan) {
				this.mockgrid.setColaPaquetes(colaPaquetes);
				//Agregamos el elemento a la cola de mockgrid
				nuevo.setId(nextId.idSiguiente());
				this.mockgrid.procesarSimulacion(escenario.get(nuevo.getId()));
			}else {
				colaSimulacion.agregarCola(escenario,idPaquete);
				logger.debug("-------CANTIDAD DE SIMULACIONES INDIVIDUALES"+ colaSimulacion.getEscenarios().size() + "-------");				
			}
			
			return HttpStatus.OK;
				
		}catch(Exception e) {
			logger.error("Fallo en la peticion de agregar simulacion para el usuario "+e.getMessage());
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public HttpStatus createSimulaciones(@Valid @RequestBody VariacionesReact variacionesReact) {
		try {
			logger.debug("------------------------------COMIENZA LA GENERACION DE SIMULACIONES USUARIO ["+variacionesReact.getUsuario().getIdUser()+"]------------------------------");
			int idPaquete = siguientePaquete.idSiguiente();
			Paquete nuevoPaquete = new Paquete(idPaquete);			
			
			generadorVariaciones.generarDocumento(variacionesReact);
			
			Hashtable<Integer,Documento> escenarios = generadorVariaciones.generarSimulaciones(variacionesReact,idPaquete);
			nuevoPaquete.setIdUsuario(Integer.parseInt(variacionesReact.getUsuario().getIdUser()));
			nuevoPaquete.setTotalEscenarios(escenarios.size());
			
			colaPaquetes.addPaquete(nuevoPaquete);
			
			//Agregamos el usuario a la cola
			colaUsuarios.addUsuario(variacionesReact.getUsuario(), escenarios.size());
			
			logger.debug("------> cantidad de escenarios generados : "+ escenarios.size());
			
			logger.debug("---- Conjunto de simulaciones experimentales numero " + idPaquete);
			if(this.utilizarSimugan) {
				this.mockgrid.setColaPaquetes(colaPaquetes);
				//Agregamos el elemento a la cola de mockgrid
				for (Integer index : escenarios.keySet()) {
					escenarios.get(index).setId(nextId.idSiguiente());
					escenarios.get(index).setIdPaquete(idPaquete);
					this.mockgrid.procesarSimulacion(escenarios.get(index));					
				}
			}else {
				colaExperimentacion.agregarCola(escenarios, idPaquete);				
			}
			
			logger.debug("-------CANTIDAD DE SIMULACIONES EXPERIMENTALES : "+ colaExperimentacion.getEscenarios().size() + "-------");
			
			
			logger.debug("------------------------------FIN LA GENERACION DE SIMULACIONES USUARIO ["+variacionesReact.getUsuario().getIdUser()+"]------------------------------");
			return HttpStatus.OK;
		}catch(Exception e) {
			logger.error("Fallo en la peticion de agregar simulaciones para el usuario "+variacionesReact.getUsuario());
			System.out.println(e);
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
