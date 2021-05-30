package com.IsteMySQL.Util;
import java.sql.*;



public class VeritabaniUtil {
static Connection connection = null ;
 
public static Connection Baglan() {
	try {
		connection=DriverManager.getConnection("jdbc:mysql://localhost/eczanedb","root","mysql");
		return connection;
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage().toString());
		return null;
	}
}
}
