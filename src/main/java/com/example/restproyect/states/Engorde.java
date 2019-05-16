package com.example.restproyect.states;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.Transient;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;
import com.example.restproyect.hilos.ThreadPool;
import com.example.restproyect.hilos.tareas.AbsTarea;
import com.example.restproyect.hilos.tareas.TareaDigestibilidad;
import com.example.restproyect.hilos.tareas.TareaEngorde;
import com.example.restproyect.states.objetosinternos.Pastura;
import com.example.restproyect.states.objetosinternos.engorde.VariacionEngorde;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Variaciones"
})
public class Engorde implements Serializable{

    @JsonProperty("Variaciones")
    private List<VariacionEngorde> variaciones = null;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Transient
    private FiltroAbs filtro = new FiltroNombre("fattening");
    
    @JsonProperty("Variaciones")
    public List<VariacionEngorde> getVariaciones() {
        return variaciones;
    }

    @JsonProperty("Variaciones")
    public void setVariaciones(List<VariacionEngorde> variaciones) {
        this.variaciones = variaciones;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    private ArrayList<VariacionEngorde> cloneList( List<VariacionEngorde> list) {
		 ArrayList<VariacionEngorde> clone = new ArrayList<VariacionEngorde>(list.size());
	    for (VariacionEngorde item : list) 
	    	clone.add(item.clone());
	    return clone;
	}
    
	public Hashtable<Integer, Documento> generarEscenarios(Hashtable<Integer, Documento> escenarios,
			ThreadPool pool) {
		System.out.println("---------------------------------ENGORDE-------------------------------");
		try {
			for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {				
				//Generar para ese escenario, la variacion correspondiente
				AbsTarea tarea = new TareaEngorde(cloneList(this.variaciones),this.filtro,escenarios.get(indexEscenarios), new Integer(indexEscenarios));
				pool.addLista(tarea);				
			}	
			pool.getExecutor().shutdown(); 
			while (!pool.getExecutor().awaitTermination(10, TimeUnit.SECONDS)) { 
				System.out.println("Awaiting completion of threads."); 
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("***** FINALIZANDO LOS ENGORDE *****");
					    	
		}

		return pool.getEscenarios();
	}

	@Override
	public String toString() {
		return "Engorde [variaciones=" + variaciones + "]" + " size = " + variaciones.size();
	}
	
	

}
