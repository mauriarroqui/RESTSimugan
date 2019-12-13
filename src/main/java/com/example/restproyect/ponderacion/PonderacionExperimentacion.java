package com.example.restproyect.ponderacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restproyect.colaprioridad.ColaUsuarios;
import com.example.restproyect.dto.Documento;
import com.example.restproyect.filtros.FiltroAND;
import com.example.restproyect.filtros.FiltroAbs;
import com.example.restproyect.filtros.FiltroMayor;
import com.example.restproyect.filtros.FiltroMenor;
import com.example.restproyect.prioridades.ParametroAnimales;
import com.example.restproyect.prioridades.ParametroEspera;
import com.example.restproyect.prioridades.ParametroMob;
import com.example.restproyect.prioridades.ParametroUsuario;
import com.example.restproyect.prioridades.ParametroYears;


public class PonderacionExperimentacion extends PonderacionAbs{

	
	
	public PonderacionExperimentacion() {
		super();
		/*
		 * Ponderacion por cantidad de escenarios totales que tiene el usuario. 
		 */
		FiltroAbs rangoCantEscenarios1 = new FiltroAND(new FiltroMayor(0),new FiltroMenor(100));
		FiltroAbs rangoCantEscenarios2 = new FiltroAND(new FiltroMayor(100),new FiltroMenor(150));
		FiltroAbs rangoCantEscenarios3 = new FiltroAND(new FiltroMayor(150),new FiltroMenor(300));
		FiltroAbs rangoCantEscenarios4 = new FiltroAND(new FiltroMayor(300),new FiltroMenor(500));
		FiltroAbs rangoCantEscenarios5 = new FiltroMayor(500);		
		List<FiltroAbs> filtroCantEscenarios = new ArrayList<FiltroAbs>();
		//Menor cantidad mas prioridad
		filtroCantEscenarios.add(rangoCantEscenarios1);
		filtroCantEscenarios.add(rangoCantEscenarios2);
		filtroCantEscenarios.add(rangoCantEscenarios3);
		filtroCantEscenarios.add(rangoCantEscenarios4);		
		filtroCantEscenarios.add(rangoCantEscenarios5);
		this.parametros.add(new ParametroUsuario(new double[] {5.0,4.0,3.0,2.0,1.0},filtroCantEscenarios,5));
		
		/*
		 * Parametro por Tiempo de espera de los escenarios.
		 * Los valores dentro del tiempo de espera son en MINUTOS
		 */
		FiltroAbs rangoEspera1 = new FiltroMayor(190);
		FiltroAbs rangoEspera2 = new FiltroAND(new FiltroMayor(160),new FiltroMenor(189));
		FiltroAbs rangoEspera3 = new FiltroAND(new FiltroMayor(130),new FiltroMenor(159));
		FiltroAbs rangoEspera4 = new FiltroAND(new FiltroMayor(100),new FiltroMenor(129));
		FiltroAbs rangoEspera5 = new FiltroAND(new FiltroMayor(70),new FiltroMenor(99));
		FiltroAbs rangoEspera6 = new FiltroAND(new FiltroMayor(40),new FiltroMenor(69));
		FiltroAbs rangoEspera7 = new FiltroAND(new FiltroMayor(0),new FiltroMenor(39));
		List<FiltroAbs> filtroEspera = new ArrayList<FiltroAbs>();
		filtroEspera.add(rangoEspera1);
		filtroEspera.add(rangoEspera2);
		filtroEspera.add(rangoEspera3);
		filtroEspera.add(rangoEspera4);
		filtroEspera.add(rangoEspera5);
		filtroEspera.add(rangoEspera6);
		filtroEspera.add(rangoEspera7);
		
		this.parametros.add(new ParametroEspera(new double[] {10.0,8.0,7.0,5.0,3.0,2.0,0.1},filtroEspera,4));
		
		/*
		 * Parametro por Años de Simulacion.
		 * Mientras menos años son para simular, mas prioridad tiene
		 */
		FiltroAbs rango1 = new FiltroAND(new FiltroMayor(0),new FiltroMenor(10));
		FiltroAbs rango2 = new FiltroAND(new FiltroMayor(11),new FiltroMenor(20));
		FiltroAbs rango3 = new FiltroAND(new FiltroMayor(21),new FiltroMenor(40));
		FiltroAbs rango4 = new FiltroMayor(41);
		List<FiltroAbs> filtroYears = new ArrayList<FiltroAbs>();
		filtroYears.add(rango1);
		filtroYears.add(rango2);
		filtroYears.add(rango3);
		filtroYears.add(rango4);
		this.parametros.add(new ParametroYears(new double[] {8.0,3.0,1.0,0.1},filtroYears,3));		
		
		
		/*
		 * Parametros de rango de mobs. 
		 * Mientras mas cantidad de mobs tiene, menos prioridad tiene la simulacion 
		 */
		FiltroAbs rangoMob1 = new FiltroAND(new FiltroMayor(0),new FiltroMenor(2));
		FiltroAbs rangoMob2 = new FiltroAND(new FiltroMayor(3),new FiltroMenor(4));
		FiltroAbs rangoMob3 = new FiltroAND(new FiltroMayor(5),new FiltroMenor(6));
		FiltroAbs rangoMob4 = new FiltroMayor(7);		
		List<FiltroAbs> filtroMob = new ArrayList<FiltroAbs>();
		filtroMob.add(rangoMob1);
		filtroMob.add(rangoMob2);
		filtroMob.add(rangoMob3);
		filtroMob.add(rangoMob4);		
		this.parametros.add(new ParametroMob(new double[] {6.0,4.0,2.0,0.1},filtroMob,2));
		
		/*
		 * Parametro de rango por cantidad de animales. 
		 * Mientras menos cantidad de animales tiene, mas prioridad para simular le damos
		 */
		FiltroAbs rangoAnimales1 = new FiltroAND(new FiltroMayor(0),new FiltroMenor(600));
		FiltroAbs rangoAnimales2 = new FiltroAND(new FiltroMayor(601),new FiltroMenor(1200));
		FiltroAbs rangoAnimales3 = new FiltroAND(new FiltroMayor(1201),new FiltroMenor(1600));
		FiltroAbs rangoAnimales4 = new FiltroAND(new FiltroMayor(1601),new FiltroMenor(2000));
		FiltroAbs rangoAnimales5 = new FiltroAND(new FiltroMayor(2001),new FiltroMenor(2400));
		FiltroAbs rangoAnimales6 = new FiltroAND(new FiltroMayor(2401),new FiltroMenor(2800));
		FiltroAbs rangoAnimales7 = new FiltroMayor(2801);		
		List<FiltroAbs> filtroAnimales = new ArrayList<FiltroAbs>();
		filtroAnimales.add(rangoAnimales1);
		filtroAnimales.add(rangoAnimales2);
		filtroAnimales.add(rangoAnimales3);
		filtroAnimales.add(rangoAnimales4);		
		filtroAnimales.add(rangoAnimales5);
		filtroAnimales.add(rangoAnimales6);
		filtroAnimales.add(rangoAnimales7);
		this.parametros.add(new ParametroAnimales(new double[] {9.0,7.0,5.0,4.0,3.0,2.0,1.0},filtroAnimales,1));		
	
		
	}
	
	@Override
	public double getValor(Documento doc) {
		double resultado = 0;
		
		for(int i = 0; i< parametros.size();i++) {
			//R = P1*V1 + P2*V2 + … + Pn*Vn
			resultado += parametros.get(i).getValorDePrioridad()*parametros.get(i).getPuntaje(doc);
//			System.out.println("Valor del parametro ["+parametros.get(i).getValorDePrioridad()*parametros.get(i).getPuntaje(doc)+"] parametro numero: ["+i+"] Documento id ["+doc.getId()+"]");
		}
		return resultado;
	}


	
}
