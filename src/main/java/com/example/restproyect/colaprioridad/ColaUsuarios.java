package com.example.restproyect.colaprioridad;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.example.restproyect.dto.Usuario;

@Controller
public class ColaUsuarios {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private Hashtable<String,Usuario> usuarios;

	public ColaUsuarios() {
		super();
		usuarios = new Hashtable<String,Usuario>();
	}

	public Hashtable<String,Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Hashtable<String,Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public synchronized Usuario getUsuario(String usuario) {
		return usuarios.get(usuario);
	}
	
	/*
	 	Agregamos un usuario a la lista de simulaciones.
	 */
	public synchronized void addUsuario(Usuario usuario, int cantidadEscenarios) {
		if(this.usuarios.get(usuario.getIdUser()) != null) {
			int cantidadAnterior = this.usuarios.get(usuario.getIdUser()).getCantidadEscenarios();
			//El usuario existe, sumar cantidad de simulaciones
			logger.debug("Usuario numero ["+usuario.getIdUser()+"] cantidad de escenarios agregados ["+cantidadAnterior + cantidadEscenarios+"]");
			this.usuarios.get(usuario.getIdUser()).setCantidadEscenarios(cantidadAnterior + cantidadEscenarios);
		}else {
			usuario.setCantidadEscenarios(cantidadEscenarios);
			logger.debug("Usuario numero ["+usuario.getIdUser()+"] cantidad de escenarios agregados ["+cantidadEscenarios+"]");
//			System.out.println("Usuario numero ["+usuario.getIdUser()+"] cantidad de escenarios agregados ["+cantidadEscenarios+"]");
			this.usuarios.put(usuario.getIdUser(), usuario);
			
		}
	}
	
	/*
	 *Eliminamos los usuarios que no tengan simulaciones para enviar a simugan
	 */
	public synchronized void eliminarUsuarios() {		
		for (Usuario u : this.usuarios.values()) {
			if(u.getCantidadEscenarios() == 0) {
				this.usuarios.remove(u.getIdUser());			
			}			
		}
	}
	
	
	
	
	
}
