package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Conect {
	
	
	int result;
	private static final String INSERT_PERSON_QUERY = "INSERT INTO user VALUES(?,?)";
	
	Scanner scan = null;
	int id = 0;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/mansoor";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	Connection con = null;
	Conect() throws SQLException{
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		
	}
	
	public void insert(String a , String b) throws SQLException {
		if(con != null)
			ps = con.prepareStatement(INSERT_PERSON_QUERY);
		ps.setString(1, a);
		ps.setString(2, b);
		result = ps.executeUpdate();
		if(result == 0)
			System.out.println("\nRecords not inserted");
			else
			System.out.println("\nRecords inserted"+
			" successfully");
	}
	
}
