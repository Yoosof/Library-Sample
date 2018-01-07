package com.company.dao;

import com.company.Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getConnection(){
		Connection con=null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(String.valueOf(System.out.printf("jdbc:mysql://%s:$d/%s","%s","%s", Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USERNAME, Config.DB_PASS)));
		}catch(Exception e){System.out.println(e);}
		return con;
	}

}
