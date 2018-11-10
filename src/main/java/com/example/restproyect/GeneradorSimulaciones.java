package com.example.restproyect;

import java.util.concurrent.RecursiveAction;

import javax.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restproyect.states.Ensilaje;
import com.example.restproyect.states.Potreros;
import com.example.restproyect.states.Rastrojo;
import com.example.restproyect.states.RecursosForrajeros;
import com.example.restproyect.states.VariacionesReact;

@RestController
@RequestMapping(value = "/simugan")
public class GeneradorSimulaciones {
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public HttpStatus getSimulaciones() {

		return HttpStatus.OK;
    }
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public HttpStatus createSimulaciones(@Valid @RequestBody VariacionesReact variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		System.out.println(variacionesReact.toString());
		return HttpStatus.OK;
    }
	
	/*SOLO PARA PRUEBAS DE CADA POST POR SEPARADO*/
	@RequestMapping(value = "/potreros", method = RequestMethod.POST)
    public HttpStatus postPotreros(@Valid @RequestBody Potreros variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		System.out.println(variacionesReact.toString());
		return HttpStatus.OK;
    }
	
	@RequestMapping(value = "/ensilaje", method = RequestMethod.POST)
    public HttpStatus postEnsilaje(@Valid @RequestBody Ensilaje variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		System.out.println(variacionesReact.toString());
		return HttpStatus.OK;
    }
	
	@RequestMapping(value = "/forrajeros", method = RequestMethod.POST)
    public HttpStatus postForrajeros(@Valid @RequestBody RecursosForrajeros variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		System.out.println(variacionesReact.toString());
		return HttpStatus.OK;
    }
	
	@RequestMapping(value = "/rastrojo", method = RequestMethod.POST)
    public HttpStatus postForrajeros(@Valid @RequestBody Rastrojo variacionesReact) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		System.out.println(variacionesReact.toString());
		return HttpStatus.OK;
    }
}
