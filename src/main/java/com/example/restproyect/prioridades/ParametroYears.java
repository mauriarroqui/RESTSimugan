package com.example.restproyect.prioridades;

import java.time.chrono.ChronoLocalDate;
import static java.time.temporal.ChronoUnit.*;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroNombre;


public class ParametroYears extends AbsParametro {

	private List<FiltroAbs> filtros;
	private FiltroAbs filtroNombre;
	
	public ParametroYears(double[] prioridades, List<FiltroAbs> filtroYears) {
		super(2,prioridades);
		this.filtros = filtroYears;
		this.filtroNombre = new FiltroNombre("simulation");
	}

	// en caso de que los valores estan delimitado por rangos, es necesario usar esta funcion
	// para poder obtener el valor del arreglo
	// TO-DO dependiendo de los rangos del parametro.
	private int getIndex(int valor) {
		return 0;
	}
	
	@Override
	public double getPuntaje(Documento doc) {
		//cambiar el 0 por el valor del parametro obtenido del xml
		//NodeList parametro = (NodeList) doc.getDocumento().getElementsByTagName("simulation");
		NodeList node = (NodeList) doc.getDocumento().getChildNodes().item(0).getChildNodes();
		for(int j=0; j < node.getLength(); j++) {
			if(j%2 != 0) {
				Node nodo =  node.item(j);
				if(this.filtroNombre.cumple(nodo)) {
					String diaInicio , mesInicio, añoInicio, diaFin, mesFin, añoFin = "";
					
					diaInicio = nodo.getAttributes().getNamedItem("startingDay").getNodeValue();
					mesInicio = nodo.getAttributes().getNamedItem("startingMonth").getNodeValue();
					añoInicio = nodo.getAttributes().getNamedItem("startingYear").getNodeValue();
					diaFin = nodo.getAttributes().getNamedItem("finishingDay").getNodeValue();
					mesFin = nodo.getAttributes().getNamedItem("finishingMonth").getNodeValue();
					añoFin = nodo.getAttributes().getNamedItem("finishingYear").getNodeValue();
					 
			        
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			        if(mesInicio.length()==1) {
			        	mesInicio="0"+mesInicio;
			        }
			        if(mesFin.length()==1) {
			        	mesFin="0"+mesFin;
			        }
			        if(diaInicio.length()==1) {
			        	diaInicio = "0"+diaInicio;
			        }
			        if(diaFin.length()==1) {
			        	diaFin = "0"+diaFin;
			        }
			        ChronoLocalDate from = ChronoLocalDate.from(formatter.parse(diaInicio+"/"+mesInicio+"/"+añoInicio));
//			        ChronoLocalDate to = ChronoLocalDate.from(formatter.parse(diaInicio+"/"+mesInicio+"/"+añoInicio));
			        ChronoLocalDate to = ChronoLocalDate.from(formatter.parse(diaInicio+"/"+mesInicio+"/2029"));
			        ChronoPeriod period = ChronoPeriod.between(from, to);
			        double diferencia = period.get(YEARS);
					for(int index = 0; index < filtros.size(); index++) {
						if(filtros.get(index).cumple(diferencia)) {
							return prioridades[this.getIndex(index)];
						}			
					}
				}
			}
		}
		
		//Si no cumple con ninguno, retorno 0 como valor de prioridad
		return 0;
	}

}
