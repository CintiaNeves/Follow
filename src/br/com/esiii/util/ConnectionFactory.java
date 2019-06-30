package br.com.esiii.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection(){
		
		String url = "jdbc:mariadb://localhost:3308/sistema_follow";
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection(url, "root", "");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}



