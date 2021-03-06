package com.mapa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mapa.models.Vehiculo;
public class DAOVehiculo{
	
	public void registrar(Vehiculo vehiculo){
		String sql = "INSERT INTO vehiculos(latitud, longitud, fecha, velocidad) values(?,?,?,?)";
		try {
			Conexion.getConnection();
	        PreparedStatement p_statement =
	        		Conexion.getConnection().prepareStatement(sql);    
	        p_statement.setDouble(1, vehiculo.getLatitud());
	        p_statement.setDouble(2, vehiculo.getLongitud());
	        p_statement.setString(3, vehiculo.getFecha());
	        p_statement.setDouble(4, vehiculo.getVelocidad());
	        p_statement.executeUpdate();
	        p_statement.close();
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	
	public ArrayList<Vehiculo> listar(){	
		ArrayList<Vehiculo> list = new ArrayList<Vehiculo>();
		String sql = "SELECT id, "
				+ "latitud, "
				+ "longitud, "
				+ "fecha, "
				+ "velocidad "
				+ "FROM vehiculos";
		try {	
			Conexion.getConnection();
	        Statement statement = Conexion.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);
			while(result.next()){
                list.add(
                        new Vehiculo(
                                result.getInt("id"),
                                result.getDouble("latitud"),
                                result.getDouble("longitud"),
                                result.getString("fecha"),
                                result.getDouble("velocidad")
                        )
                );
            }
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		return list;			
	}
}
