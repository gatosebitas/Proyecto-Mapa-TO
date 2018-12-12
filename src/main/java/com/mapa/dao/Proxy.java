package com.mapa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mapa.dao.Conexion.getClose;

public class Proxy {
/**
 * Genero una conexion alterna para que muestre los servicion en nuestra segunda BD que
 * servira como respaldo para nuestra BD inicial.
 */
	
	public static Connection con;
	private static String url = "jdbc:mysql://localhost/mapadb2"; //redireccionamos
    private static String user = "root";
    private static String password = "";
    
	public static Connection getConnection2() {
		try {
			if(con == null) {
				Runtime.getRuntime().addShutdownHook(new getClose());
				Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);
			}
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Conexion Fallida", e);
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
