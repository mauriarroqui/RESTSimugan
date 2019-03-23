
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
import com.example.restproyect.hilos.tareas.TareaEngorde;
import com.example.restproyect.states.objetosinternos.engorde.VariacionEngorde;
import com.example.restproyect.states.objetosinternos.mobs.VariacionesMobs;
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
public class Mob implements Serializable{

    @JsonProperty("Variaciones")
    private List<VariacionesMobs> variaciones = null;
    
    @Transient
    private FiltroAbs filtro = new FiltroNombre("");
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Variaciones")
    public List<VariacionesMobs> getVariaciones() {
        return variaciones;
    }

    @JsonProperty("Variaciones")
    public void setVariaciones(List<VariacionesMobs> variaciones) {
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

	@Override
	public String toString() {
		return "Mob [variaciones=" + variaciones + ", additionalProperties=" + additionalProperties + "]"+"\n";
	}

	public Hashtable<Integer, Documento> generarEscenarios(Hashtable<Integer, Documento> escenarios,
			ThreadPool pool) {
		System.out.println("---------------------------------ENGORDE-------------------------------");
		try {
			for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {				
				//Generar para ese escenario, la variacion correspondiente					
				AbsTarea tarea = new TareaMobs(cloneList(this.variaciones),this.filtro,escenarios.get(indexEscenarios), new Integer(indexEscenarios));
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

	private ArrayList<VariacionesMobs> cloneList(List<VariacionesMobs> variaciones2) {
		// TODO Auto-generated method stub
		ArrayList<VariacionesMobs> arrayClone = new ArrayList<VariacionesMobs>(variaciones2.size());
	    for (VariacionesMobs item : variaciones2) {
	    	arrayClone.add(item.clone());		    	
	    } 
	    return arrayClone;
	}

   

}
