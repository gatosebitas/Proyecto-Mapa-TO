package com.mapa.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mapa.dao.DAOVehiculo;
import com.mapa.models.Vehiculo;

@Path("/vehiculos")
public class VehiculoService {

	private static DAOVehiculo daoVehiculo = new DAOVehiculo();
	ArrayList<Vehiculo> list = daoVehiculo.listar();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVehiculos() {
		return Response.ok(list).build();
	}
}
