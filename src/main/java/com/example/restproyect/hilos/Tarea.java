package com.example.restproyect.hilos;

import java.util.List;
import java.util.concurrent.Callable;



import com.example.restproyect.Documento;

public abstract class Tarea implements Callable<List<Documento>>{

	public abstract List<Documento> call();


}
