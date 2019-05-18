package com.example.restproyect.colaprioridad;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.restproyect.dto.Usuario;

@Controller
public class ColaUsuarios {
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
	
	public Usuario getUsuario(String usuario) {
		return usuarios.get(usuario);
	}
	
	/*
	 	Agregamos un usuario a la lista de simulaciones.
	 */
	public void addUsuario(Usuario usuario, int cantidadEscenarios) {
		if(this.usuarios.get(usuario.getIdUser()) != null) {
			//El usuario existe, sumar cantidad de simulaciones
			this.usuarios.get(usuario.getIdUser()).setCantidadEscenarios(usuario.getCantidadEscenarios() + cantidadEscenarios);
		}else {
			this.usuarios.put(usuario.getIdUser(), usuario);
			
		}
	}
	
	/*
	 *Eliminamos los usuarios que no tengan simulaciones para enviar a simugan
	 */
	public void eliminarUsuarios() {		
		for (Usuario u : this.usuarios.values()) {
			if(u.getCantidadEscenarios() == 0) {
				this.usuarios.remove(u.getIdUser());			
			}			
		}
	}
	
	
	
	
	
}
