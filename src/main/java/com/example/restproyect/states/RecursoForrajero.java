package com.example.restproyect.states;




import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.persistence.Transient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.example.restproyect.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;
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
    
	private String getMonth(int valorMes) {
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
	public Hashtable<Integer, Documento> generarEscenarios(Hashtable<Integer, Documento> escenarios) {
		
		Hashtable<Integer, Documento> newEscenarios = new Hashtable<>();
		
		//Por cada escenario que entre. Los escenarios arrancan en 1
		for(int indexEscenarios = 0; indexEscenarios < escenarios.size(); indexEscenarios++) {
			for(int indexVariaciones = 0; indexVariaciones < forrajeroPasturas.get(0).getForrajeroVariacion().size(); indexVariaciones++) {
				//Generar para ese escenario, la variacion correspondiente			
				Document newDocument = escenarios.get(indexEscenarios).getDocumento();
				
				Documento doc = new Documento(newDocument);			
				Document insertDoc = doc.clonarDocumento();
				doc.setDocumento(insertDoc);
				
				//Para cada tag dentro del tag <escenario> Busco los tags que tienen las variaciones
				NodeList node = doc.getDocumento().getChildNodes().item(0).getChildNodes();		
				

				for(int j=0; j < node.getLength(); j++) {
					/*
					 * indice par es un text dentro de los tags, solo 
					 * se trabaja con los elementos impares
					 * que son los TAGS
					 */
					
					if(j%2 != 0) {
						Element nodo = (Element) node.item(j);
						if(filtro.cumple(nodo)) {
							//Obtengo la pastura a variar
							NodeList nodePastura = nodo.getChildNodes();
							for(int indexPasturas = 0; indexPasturas < forrajeroPasturas.size(); indexPasturas++) {
								//Formula para obtener la pastura que va a variar
								Element nodoPastura = (Element) nodePastura.item(indexPasturas*2+1);
								
								//Obtengo los hijos de la pastura
								NodeList nodePasturaIndex = nodoPastura.getChildNodes();
								
								//Parametro que va a variar pastureAccumRateMean
								Element  nodoPasturaIndex = (Element) nodePasturaIndex.item(1);
								
								for(int month = 0; month < 12; month ++) {
									nodoPasturaIndex.setAttribute(this.getMonth(month),String.valueOf(forrajeroPasturas.get(indexPasturas).next()));
								}
								
								
							}
							newEscenarios.put(newEscenarios.size(),doc);
							
							
						}
						
					}
					
				}				
			
				for(int indexPastura = 0; indexPastura < this.forrajeroPasturas.size(); indexPastura++) {								
					this.forrajeroPasturas.get(indexPastura).resetUltimaSeleccion();
					
				}
			}
		}
		
		
		
		return newEscenarios;
	}

}
