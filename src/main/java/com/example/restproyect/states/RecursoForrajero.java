package com.example.restproyect.states;




import java.io.InterruptedIOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.Transient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;
import com.example.restproyect.hilos.ThreadPool;
import com.example.restproyect.hilos.tareas.AbsTarea;
import com.example.restproyect.hilos.tareas.TareaDigestibilidad;
import com.example.restproyect.hilos.tareas.TareaForrajero;
import com.example.restproyect.states.objetosinternos.recursosforrajeros.ForrajeroPastura;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ForrajeroPasturas"
})
public class RecursoForrajero implements Serializable{

    @JsonProperty("ForrajeroPasturas")
    public List<ForrajeroPastura> forrajeroPasturas = null;
    
    @Transient
    private FiltroAbs filtro = new FiltroNombre("pastureType");

	public List<ForrajeroPastura> getForrajeroPasturas() {
		return forrajeroPasturas;
	}

	public void setForrajeroPasturas(List<ForrajeroPastura> forrajeroPasturas) {
		this.forrajeroPasturas = forrajeroPasturas;
	}

	@Override
	public String toString() {
		return "RecursoForrajero [forrajeroPasturas=" + forrajeroPasturas + "]"+"\n";
	}
    
	public static String getMonth(int valorMes) {
		switch(valorMes) {
			case 0: 
				return "January";
			case 1: 
				return "February";
			case 2: 
				return "March";
			case 3: 
				return "April";
			case 4: 
				return "May";
			case 5: 
				return "June";
			case 6: 
				return "July";
			case 7: 
				return "August";
			case 8: 
				return "September";
			case 9: 
				return "October";
			case 10: 
				return "November";
			case 11: 
				return "December";
		}
		
		return "";
	}
	
	public Hashtable<Integer, Documento> generarEscenarios(Hashtable<Integer, Documento> escenarios,ThreadPool pool) {
		try {

			for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {				
				//generar para ese escenario, la variacion correspondiente
				ArrayList<ForrajeroPastura> clonado = new ArrayList<ForrajeroPastura>();
				for(ForrajeroPastura p : forrajeroPasturas) {
					clonado.add(p.clone());
				}
				AbsTarea tarea = new TareaForrajero(this.clonePasturas(), filtro, escenarios.get(indexEscenarios), new Integer(indexEscenarios));
				pool.addLista(tarea);				
			}	
			pool.getExecutor().shutdown(); 
			while (!pool.getExecutor().awaitTermination(10, TimeUnit.SECONDS)) { 
				System.out.println("awaiting completion of threads."); 
			}
		} catch (InterruptedException e) {
			// todo auto-generated catch block
			e.printStackTrace();
		}
		return pool.getEscenarios();
	}

	private ArrayList<ForrajeroPastura> clonePasturas(){
		ArrayList<ForrajeroPastura> clonado = new ArrayList<ForrajeroPastura>();
		for(ForrajeroPastura p : forrajeroPasturas) {
			clonado.add(p.clone());
		}
		return clonado;
	}
}
