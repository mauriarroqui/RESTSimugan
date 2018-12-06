package com.example.restproyect.hilos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;



import com.example.restproyect.Documento;

public abstract class Tarea implements Callable<ArrayList<Documento>>{

	public abstract ArrayList<Documento> call();


}
