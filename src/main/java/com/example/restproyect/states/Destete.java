package com.example.restproyect.states;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.Transient;

import org.springframework.util.SerializationUtils;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;
import com.example.restproyect.hilos.ThreadPool;
import com.example.restproyect.hilos.tareas.AbsTarea;
import com.example.restproyect.hilos.tareas.TareaDestete;
import com.example.restproyect.hilos.tareas.TareaEngorde;
import com.example.restproyect.states.objetosinternos.destete.EstadoDestete;
import com.example.restproyect.states.objetosinternos.destete.VariacionDestete;
import com.example.restproyect.states.objetosinternos.engorde.VariacionEngorde;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "variaciones"
})
public class Destete implements Serializable{

    @JsonProperty("variaciones")
    private List<EstadoDestete> variaciones = null;

    @Transient
    private FiltroAbs filtro = new FiltroNombre("earlyWeaning");
    
	public List<EstadoDestete> getVariaciones() {
		return variaciones;
	}


	public void setVariaciones(List<EstadoDestete> variaciones) {
		this.variaciones = variaciones;
	}


	@Override
	public String toString() {
		return "Destete [variaciones=" + variaciones + "]"+"\n";
	}


	private ArrayList<EstadoDestete> cloneList( List<EstadoDestete> list) {
		 List<EstadoDestete> clone = new ArrayList<EstadoDestete>(list.size());
	    for (EstadoDestete item : list) {
	    	try {
	    		EstadoDestete aux = (EstadoDestete) item.clone();
				clone.add(aux);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }	
	    return (ArrayList<EstadoDestete>) clone;
	}
	
	public Hashtable<Integer, Documento> generarEscenarios(Hashtable<Integer, Documento> escenarios,
			ThreadPool threadPool) {
		// TODO Auto-generated method stub
		
		System.out.println("---------------------------------DESTETE-------------------------------");
		try {
			for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {				
				//Generar para ese escenario, la variacion correspondiente					
				AbsTarea tarea = new TareaDestete(cloneList(this.variaciones),this.filtro,escenarios.get(indexEscenarios), new Integer(indexEscenarios));
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
			System.out.println("***** FINALIZANDO LOS ENGORDE *****");
					    	
		}

		return threadPool.getEscenarios();
	}

   

}
