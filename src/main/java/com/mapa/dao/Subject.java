package com.mapa.dao;

import java.util.ArrayList;

import com.mapa.models.Punto_Interes;
import com.mapa.models.Vehiculo;

public abstract class Subject {
	
	abstract void registrar(Vehiculo vehiculo);
	abstract void registrar(Punto_Interes punto);

	}

