package com.mapa.api;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.mapa.dao.DAOPunto_Interes;
import com.mapa.dao.DAOVehiculo;
import com.mapa.models.Punto_Interes;
import com.mapa.models.Vehiculo;

public class FacadeAPI {
	

	private String response="";
	public void initVehiculo() {
		DAOVehiculo daoVehiculo = new DAOVehiculo();
		ArrayList<Vehiculo> list = daoVehiculo.listar();
		
		for (Vehiculo vehiculo : list) {
			response+= new Gson().toJson(vehiculo);	
		}
	}
	
	public void initPuntoInteres() {
		DAOPunto_Interes daoPuntoInteres = new DAOPunto_Interes();
		ArrayList<Punto_Interes> list = daoPuntoInteres.listar();
		
		for (Punto_Interes punto : list) {
			response+= new Gson().toJson(punto);	
		}
	}
	
	public String getStringResponse() {
		return response;
	}
}
