package com.example.restproyect.states;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.Transient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.example.restproyect.ThreadPool;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;
import com.example.restproyect.hilos.Tarea;
import com.example.restproyect.hilos.TareaFeedLot;
import com.example.restproyect.hilos.TareaRastrojo;
import com.example.restproyect.states.objetosinternos.Pastura;
import com.example.restproyect.states.objetosinternos.feedlot.VariacionFeedLot;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "VariacionFeedLot" })
public class Feedlot implements Serializable{

	@JsonProperty("VariacionFeedLot")
	private List<VariacionFeedLot> variacionFeedLot = null;
	
	@Transient
    private FiltroAbs filtro = new FiltroNombre("feedlot");
	
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

	public List<VariacionFeedLot> getVariacionFeedLot() {
		return variacionFeedLot;
	}

	public void setVariacionFeedLot(List<VariacionFeedLot> variacionFeedLot) {
		this.variacionFeedLot = variacionFeedLot;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "Feedlot [variacionFeedLot=" + variacionFeedLot + ", additionalProperties=" + additionalProperties + "]"+"\n";
	}

	/*public static ArrayList<VariacionFeedLot> cloneList( List<VariacionFeedLot> list) {
		 ArrayList<VariacionFeedLot> clone = new ArrayList<VariacionFeedLot>(list.size());
	    for (VariacionFeedLot item : list) 
	    	clone.add(item.clone());
	    return clone;
	}*/
	
	public Hashtable<Integer, Documento> generarEscenarios(Hashtable<Integer, Documento> escenarios, ThreadPool threadPool) {
		try {
			
			for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {
				Tarea tarea = new TareaFeedLot(new ArrayList<VariacionFeedLot>(variacionFeedLot),escenarios.get(indexEscenarios),filtro, new Integer(indexEscenarios));
				threadPool.addLista(tarea);
			}
			threadPool.getExecutor().shutdown(); 
			while (!threadPool.getExecutor().awaitTermination(10, TimeUnit.SECONDS)) { 
				System.out.println("Awaiting completion of threads."); 
			} 
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("TERMINARON LOS FEEDLOT");
		}
	   
		return threadPool.getEscenarios();
	}
	
	

}