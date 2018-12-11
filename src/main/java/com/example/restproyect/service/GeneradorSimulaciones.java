package com.example.restproyect.service;



import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.example.restproyect.hilos.ThreadPool;
import com.example.restproyect.logicanegocio.GeneradorService;
import com.example.restproyect.states.Diferido;
import com.example.restproyect.states.RecursoForrajero;
import com.example.restproyect.states.VariacionesReact;

//Capa de servicios
@RestController
@RequestMapping(value = "/simugan")
public class GeneradorSimulaciones {
	
	//Inyectamos el generador de las variaciones
	@Autowired
	GeneradorService generadorVariaciones;	
	private Hashtable<Integer, Documento> escenarios = new Hashtable<>();
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public HttpStatus getSimulaciones() {
		return HttpStatus.OK;
    }
	

	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public HttpStatus createSimulaciones(@Valid @RequestBody VariacionesReact variacionesReact) {
		try {
			System.out.println(variacionesReact.toString());
			
			generadorVariaciones.generarDocumento(variacionesReact);
			
			//Agregar todos los escenarios del arreglo principal tambien
			escenarios = generadorVariaciones.generarSimulaciones(variacionesReact,escenarios);
			
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }
	
	/*SOLO PARA PRUEBAS DE CADA POST POR SEPARADO
	@RequestMapping(value = "/potreros", method = RequestMethod.POST)
    public HttpStatus postPotreros(@Valid @RequestBody Potrero variacionesReact) {
		try {
			System.out.println(variacionesReact.toString());
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }
	
	@RequestMapping(value = "/ensilaje", method = RequestMethod.POST)
    public HttpStatus postEnsilaje(@Valid @RequestBody Ensilaje variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		try {
			System.out.println(variacionesReact.toString());
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
    }*/
	
	@RequestMapping(value = "/forrajeros", method = RequestMethod.POST)
    public HttpStatus postForrajeros(@Valid @RequestBody RecursoForrajero variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		try {
			System.out.println(variacionesReact.toString());
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }
	
	/*@RequestMapping(value = "/invernada", method = RequestMethod.POST)
    public HttpStatus postInvernada(@Valid @RequestBody Invernada variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		try {
			System.out.println(variacionesReact.toString());
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }
	
	@RequestMapping(value = "/rastrojo", method = RequestMethod.POST)
    public HttpStatus postRastrojo(@Valid @RequestBody Rastrojo variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		try {
			System.out.println(variacionesReact.toString());
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }
	
	@RequestMapping(value = "/feedlot", method = RequestMethod.POST)
    public HttpStatus postFeedlot(@Valid @RequestBody Feedlot variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		try {
			System.out.println(variacionesReact.toString());
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
    }*/
	
	@RequestMapping(value = "/diferido", method = RequestMethod.POST)
    public HttpStatus postDiferido(@Valid @RequestBody Diferido variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		try {
			System.out.println(variacionesReact.toString());
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
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
