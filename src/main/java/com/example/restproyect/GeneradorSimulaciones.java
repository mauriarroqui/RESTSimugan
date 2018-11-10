package com.example.restproyect;

import javax.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restproyect.states.Ensilaje;

@RestController
@RequestMapping(value = "/simugan")
public class GeneradorSimulaciones {
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public HttpStatus getSimulaciones() {

		return HttpStatus.OK;
    }
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public HttpStatus createSimulaciones(@Valid @RequestBody Ensilaje ensilaje) {
        //User userCreated = userService.create(user);
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
		System.out.println(ensilaje.toString());
		return HttpStatus.OK;
    }
}
