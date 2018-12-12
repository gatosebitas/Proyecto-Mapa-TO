package com.mapa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class Conexion extends Proxy{
	
	public static Connection connection;
	private static String url = "jdbc:mysql://localhost/mapadb";
    private static String user = "root";
    private static String password = "";

    
    static Proxy conection2 = new Proxy();
    

	public static Connection getConnection() {
		try {
			if(connection == null) {
				Runtime.getRuntime().addShutdownHook(new getClose());
				Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(url, user, password);
			}
            return connection;
		  } catch (ClassNotFoundException | SQLException e) {
			//INICIALIZO UNA CONEXION 2 PARA USANDO LA CLASE PROXY
			  return conection2.getConnection2();
//			  throw new RuntimeException("Conexion Fallida", e);
			  
        } 	
    }
	
	static class getClose extends Thread{
		@Override
		public void run() {
			try {
				Connection con = Conexion.getConnection();
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
}
