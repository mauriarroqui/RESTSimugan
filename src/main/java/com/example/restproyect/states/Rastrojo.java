package com.example.restproyect.states;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.persistence.Transient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;
import com.example.restproyect.hilos.Tarea;
import com.example.restproyect.hilos.TareaRastrojo;
import com.example.restproyect.states.objetosinternos.Pastura;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "digestibilidadVariaciones", "rindeVariaciones" })
public class Rastrojo implements Serializable{

	@JsonProperty("digestibilidadVariaciones")
	private List<Pastura> digestibilidadVariaciones = null;
	
	@JsonProperty("rindeVariaciones")
	private List<Pastura> rindeVariaciones = null;
	
	@Transient
    private FiltroAbs filtro = new FiltroNombre("crop_stubbles");
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	
	
	public List<Pastura> getDigestibilidadVariaciones() {
		return digestibilidadVariaciones;
	}

	public void setDigestibilidadVariaciones(List<Pastura> digestibilidadVariaciones) {
		this.digestibilidadVariaciones = digestibilidadVariaciones;
	}

	public List<Pastura> getRindeVariaciones() {
		return rindeVariaciones;
	}

	public void setRindeVariaciones(List<Pastura> rindeVariaciones) {
		this.rindeVariaciones = rindeVariaciones;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Rastrojo [digestibilidadVariaciones=" + digestibilidadVariaciones + ", rindeVariaciones="
				+ rindeVariaciones + ", additionalProperties=" + additionalProperties + "]"+"\n";
	}

	public static ArrayList<Pastura> cloneList( List<Pastura> list) {
		 ArrayList<Pastura> clone = new ArrayList<Pastura>(list.size());
	    for (Pastura item : list) 
	    	clone.add(item.clone());
	    return clone;
	}
	
	public Hashtable<Integer, Documento> generarEscenarios(Hashtable<Integer, Documento> escenarios) {
		Hashtable<Integer, Documento> newEscenarios = new Hashtable<Integer, Documento>();
		//Numero de threads
		ExecutorService executor = Executors.newFixedThreadPool(10);
		ArrayList<Future<ArrayList<Documento>>> listFuture = new ArrayList<>();
		//Por cada escenario que entre. Los escenarios arrancan en 1
		
		for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {
			//Generar para ese escenario, la variacion correspondiente
			Document newDocument = escenarios.get(indexEscenarios+1).getDocumento();			
			Documento doc = new Documento(newDocument);			
			Document insertDoc = doc.clonarDocumento();
			newDocument = null;
			
			doc.setDocumento(insertDoc);
			
			listFuture.add(executor.submit(new TareaRastrojo(cloneList(digestibilidadVariaciones),cloneList(rindeVariaciones), filtro,doc, new Integer(indexEscenarios))));
			
		}		
		executor.shutdown();
		int count = 1;
		for(Future<ArrayList<Documento>> resultado:listFuture){
			if(resultado.isDone()){
				try {
					for(Documento doc:resultado.get()) {
//						System.out.println("---------------------------AGREGANDO ESCENARIO["+count+"]---------------------------------------");
						count++;
						newEscenarios.put(newEscenarios.size(), doc);
					}
					//System.out.println("-------CANTIDAD DE ESCENARIOS------["+newEscenarios.size()+"]");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			  
		}						
	
		System.out.println("-------CANTIDAD DE ESCENARIOS------");
		System.out.println("-------CANTIDAD DE ESCENARIOS------["+newEscenarios.size()+"]");
		return newEscenarios;
	}
	
	
	
	

}