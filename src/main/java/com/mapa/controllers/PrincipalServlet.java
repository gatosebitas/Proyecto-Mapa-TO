package com.mapa.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mapa.dao.DAOVehiculo;
import com.mapa.models.Vehiculo;
import com.mapa.service.Facade;

/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrincipalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOVehiculo daoVehiculo = new DAOVehiculo();
		ArrayList<Vehiculo> list = daoVehiculo.listar();
		String vehiculoJsonString="";
		for (Vehiculo vehiculo : list) {
			vehiculoJsonString+= new Gson().toJson(vehiculo);	
		}
		/*
		Vehiculo vehiculo= new Vehiculo();
		vehiculo.setId(1);
		vehiculo.setLatitud(13.75554);
		vehiculo.setLongitud(878.343432);
		*/
		
		
		 PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(vehiculoJsonString);
	        out.flush();   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Funcionando");
		
		doGet(request, response);
	}

}
