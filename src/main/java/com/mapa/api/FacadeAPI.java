package com.mapa.api;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.mapa.controllers.Converter;
import com.mapa.controllers.JsonObjectBuilder;
import com.mapa.controllers.ObjectBuilder;
import com.mapa.dao.DAOPunto_Interes;
import com.mapa.dao.DAOVehiculo;
import com.mapa.models.ObjectFormat;
import com.mapa.models.Punto_Interes;
import com.mapa.models.Vehiculo;

public class FacadeAPI {
	

	private String response="";
	public void initVehiculo() throws IllegalArgumentException, IllegalAccessException {
		DAOVehiculo daoVehiculo = new DAOVehiculo();
		ArrayList<Vehiculo> list = daoVehiculo.listar();
		Converter convetir = new Converter();
		for (Vehiculo vehiculo : list) {
			
			System.out.println(vehiculo.getLatitud());
			ObjectBuilder json = new JsonObjectBuilder(vehiculo);
			convetir.setObjectBuilder(json);
			convetir.construirObject();
			ObjectFormat js =convetir.getObject();
			
			System.out.println(js.getFormat());
			
			//response+= new Gson().toJson(vehiculo);
			response+=js.getFormat();
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
