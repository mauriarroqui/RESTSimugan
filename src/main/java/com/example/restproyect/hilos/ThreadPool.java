package com.example.restproyect.hilos;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.hilos.tareas.AbsTarea;


public class ThreadPool {

	private ExecutorService executor;
	private ArrayList<Future<ArrayList<Documento>>> listFuture;	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ArrayList<AbsTarea> tareas = new ArrayList<AbsTarea>();
	
	public ThreadPool(int numero) {
		super();
		this.executor = Executors.newFixedThreadPool(numero);
		this.listFuture = new ArrayList<>();
	}
	
	public void addLista(AbsTarea tarea){
		
		this.listFuture.add(executor.submit(tarea));
		this.tareas.add(tarea);
	}
	
	
	public void limpiarPool() {
		this.listFuture = new ArrayList<>();
	}
	
	public Hashtable<Integer, Documento> getEscenarios(){
		Hashtable<Integer, Documento> newEscenarios = new Hashtable<Integer, Documento>();
		int i = 0;
		try {
			for(Future<ArrayList<Documento>> resultado:this.listFuture){
				if(resultado.isDone()){
					try {
						for(Documento doc:resultado.get()) {
							newEscenarios.put(newEscenarios.size(), doc);
						}					
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						logger.error( i +  "---->Error en la tarea: ["+newEscenarios.size()+"]"+e);
					} 
				i++;
				}			  
			}			
			
		} finally {
			//System.out.println("--------------------------------FINALIZAR AGREGAR------------------------------");
		}
		return newEscenarios;
		
	}
	
	public ExecutorService getExecutor() {
		return executor;
	}
	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}
	public ArrayList<Future<ArrayList<Documento>>> getListFuture() {
		return listFuture;
	}
	public void setListFuture(ArrayList<Future<ArrayList<Documento>>> listFuture) {
		this.listFuture = listFuture;
	}


	
}
